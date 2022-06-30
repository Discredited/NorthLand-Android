package com.nl.room.excel

import com.nl.lib.element.role.RoleEntity
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import timber.log.Timber
import java.io.InputStream

/**
 * Excel解析
 *
 * 2022/6/29
 * @author June
 */
object ExcelAnalyze {

    fun analyzeExcel(inputStream: InputStream, callback: (list: MutableList<RoleEntity>) -> Unit) {
        Timber.e("文件读取开始")
        val headerList = mutableListOf<String>()
        val valueList = mutableListOf<Any>()
        try {
            val excelWorkBook = XSSFWorkbook(inputStream)
            val sheet = excelWorkBook.getSheetAt(0)
            // 获取最大行数
            val rows = sheet.physicalNumberOfRows
            // 获取第一行
            val rowHeader = sheet.getRow(0)
            // 获取最大列数
            val columns = rowHeader.physicalNumberOfCells
            for (rowNum in 0..rows) {
                sheet.getRow(rowNum)?.let { rowCell ->
                    for (column in 0..columns) {
                        val columnCell = rowCell.getCell(column)
                        if (null != columnCell) {
                            if (rowNum == 0) {
                                val columnValue = getCellValue(columnCell)
                                headerList.add(columnValue.toString())
                            } else {
                                val headerValue = rowHeader.getCell(column).richStringCellValue.string
                                val columnValue = getCellValue(columnCell, headerValue)
                                valueList.add(columnValue)
                            }
                        } else {
                            continue
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Timber.e("解析失败： $e")
        }
        Timber.e("头部：${headerList}")
        Timber.e("值值：${valueList}")
        callback(mutableListOf())
    }

    private fun getCellValue(cell: Cell, headerValue: Any? = null): Any {
        val headerName = headerValue ?: "当前Cell值"
        return when (cell.cellType) {
            Cell.CELL_TYPE_NUMERIC -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  ${headerName}:${cell.numericCellValue}")
                cell.numericCellValue
            }
            Cell.CELL_TYPE_FORMULA -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  ${headerName}:${cell.numericCellValue}")
                cell.numericCellValue
            }
            Cell.CELL_TYPE_STRING -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  ${headerName}:${cell.richStringCellValue.string}")
                cell.richStringCellValue.string
            }
            else -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)} $headerName")
                ""
            }
        }
    }

    private fun getCellTypeStr(type: Int): String = when (type) {
        Cell.CELL_TYPE_NUMERIC -> "NUMERIC"
        Cell.CELL_TYPE_STRING -> "STRING"
        Cell.CELL_TYPE_FORMULA -> "FORMULA"
        Cell.CELL_TYPE_BLANK -> "BLANK"
        Cell.CELL_TYPE_BOOLEAN -> "BOOLEAN"
        Cell.CELL_TYPE_ERROR -> "ERROR"
        else -> "UN-KNOW"
    }

}