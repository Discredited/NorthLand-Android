package com.nl.room.source

import com.nl.lib.element.role.RoleEntity
import com.nl.room.excel.ExcelAnalyze
import com.nl.room.excel.ExcelManager

object RoleDataSource {

    fun mockRoles(): MutableList<RoleEntity> {
        return ExcelManager.getRoleExcel()?.let { ExcelAnalyze.analyzeExcel(it) } ?: mutableListOf()
    }
}