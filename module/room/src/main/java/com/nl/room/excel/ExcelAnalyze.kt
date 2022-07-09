package com.nl.room.excel

import com.blankj.utilcode.util.GsonUtils
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import timber.log.Timber
import java.io.IOException
import java.io.InputStream
import kotlin.math.ceil

/**
 * Excel解析
 *
 * 2022/6/29
 * @author June
 */
object ExcelAnalyze {

    /**
     * 解析Excel文件
     */
    inline fun <reified T> analyzeExcel(inputStream: InputStream): MutableList<T> {
        Timber.e("文件读取开始")
        val valueList = mutableListOf<T>()
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
            for (rowNum in 2 until rows) {
                val map = LinkedHashMap<String, Any>()
                sheet.getRow(rowNum)?.let { rowCell ->
                    for (column in 0 until columns) {
                        rowCell.getCell(column)?.let { columnCell ->
                            val headerValue = rowHeader.getCell(column).richStringCellValue.string
                            val fieldName = rowField.getCell(column).richStringCellValue.string
                            val columnValue = getCellValue(columnCell, headerValue, fieldName)
                            map.put(fieldName, columnValue)
                        }
                    }
                }
                if (map.isNotEmpty()) {
                    val json = GsonUtils.toJson(map)
                    valueList.add(GsonUtils.fromJson(json, T::class.java))
                }
            }
            excelWorkBook.close()
        } catch (e: IOException) {
            Timber.e("excel读取失败:${e}")
        } catch (e: Exception) {
            Timber.e("excel解析异常： $e")
        }
        return valueList
    }

    fun getCellValue(cell: Cell, headerValue: Any? = null, fieldValue: String? = null): Any {
        val headerName = headerValue ?: "当前Cell值"
        val fieldName = fieldValue ?: ""
        return when (cell.cellType) {
            Cell.CELL_TYPE_NUMERIC -> {
                Timber.i(
                    "当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  ${fieldName}:${
                        cellNumber(
                            cell.numericCellValue
                        )
                    }"
                )
                cellNumber(cell.numericCellValue)
            }
            Cell.CELL_TYPE_FORMULA -> {
                Timber.i(
                    "当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  ${fieldName}:${
                        cellNumber(
                            cell.numericCellValue
                        )
                    }"
                )
                cellNumber(cell.numericCellValue)
            }
            Cell.CELL_TYPE_BOOLEAN -> {
                Timber.i("当前Cell类型:${cell.cellType}-${getCellTypeStr(cell.cellType)}  $headerName  ${fieldName}:${cell.booleanCellValue}")
                cell.booleanCellValue
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

    private fun cellNumber(double: Double): Any {
        // 判断当前double是整数还是小数
        return if ((double - ceil(double)) == 0.0) {
            double.toInt()
        } else {
            double
        }
    }
}