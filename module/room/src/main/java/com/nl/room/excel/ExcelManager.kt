package com.nl.room.excel

import com.blankj.utilcode.util.Utils
import timber.log.Timber
import java.io.InputStream

/**
 * Excel文件管理类
 * 主要提供获取Excel文件的方法
 */
object ExcelManager {

    private const val EXCEL_ROLE = "excel/RoleTable.xlsx"
    private const val EXCEL_SKILL = "excel/SkillTable.xlsx"

    private const val EXCEL_EFFECT = "excel/EffectTable.xlsx"

    private fun assetsOpen(fileName: String): InputStream? {
        return try {
            Utils.getApp().resources.assets.open(fileName)
        } catch (e: Exception) {
            Timber.e("assetsOpen $e")
            null
        }
    }

    fun getRoleExcel(): InputStream? {
        return assetsOpen(EXCEL_ROLE)
    }

    fun getSkillExcel(): InputStream? {
        return assetsOpen(EXCEL_SKILL)
    }

    fun getEffectExcel(): InputStream? {
        return assetsOpen(EXCEL_EFFECT)
    }
}