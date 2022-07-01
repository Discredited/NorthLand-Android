package com.nl.room.excel

import com.nl.lib.element.role.RoleEntity
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import timber.log.Timber
import java.io.IOException
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
        val fieldList = mutableListOf<String>()
        val valueList = mutableListOf<Any>()
        try {
            val excelWorkBook = XSSFWorkbook(inputStream)
            val sheet = excelWorkBook.getSheetAt(0)
            // 获取最大行数
            val rows = sheet.physicalNumberOfRows
            // 获取标题行
            val rowHeader = sheet.getRow(0)
            // 获取字段行
            val rowField = sheet.getRow(1)
            // 获取最大列数
            val columns = rowHeader.physicalNumberOfCells
            for (rowNum in 0 until rows) {
                sheet.getRow(rowNum)?.let { rowCell ->
                    for (column in 0 until columns) {
                        rowCell.getCell(column)?.let { columnCell ->
                            when (rowNum) {
                                0 -> {
                                    val columnValue = getCellValue(columnCell)
                                    headerList.add(columnValue.toString())
                                }
                                1 -> {
                                    val columnValue = getCellValue(columnCell)
                                    fieldList.add(columnValue.toString())
                                }
                                else -> {
                                    val headerValue = rowHeader.getCell(column).richStringCellValue.string
                                    val fieldName = rowField.getCell(column).richStringCellValue.string
                                    val columnValue = getCellValue(columnCell, headerValue, fieldName)
                                    valueList.add(columnValue)
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: IOException) {
            Timber.e("excel读取失败:${e}")
        } catch (e: Exception) {
            Timber.e("excel解析异常： $e")
        }
        Timber.e("头部：${headerList}")
        Timber.e("值值：${valueList}")
        callback(mutableListOf())
    }

    private fun getCellValue(cell: Cell, headerValue: Any? = null, fieldValue: String? = null): Any {
        val headerName = headerValue ?: "当前Cell值"
        val fieldName = fieldValue ?: ""
        return when (cell.cellType) {
            Cell.CELL_TYPE_NUMERIC -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  ${fieldName}:${cell.numericCellValue.toInt()}")
                cell.numericCellValue.toInt()
            }
            Cell.CELL_TYPE_FORMULA -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  ${fieldName}:${cell.numericCellValue.toInt()}")
                cell.numericCellValue.toInt()
            }
            Cell.CELL_TYPE_STRING -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  ${fieldName}:${cell.richStringCellValue.string}")
                cell.richStringCellValue.string
            }
            else -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  $fieldName")
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