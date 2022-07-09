package com.nl.room.source

import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.room.excel.ExcelAnalyze
import com.nl.room.excel.ExcelManager

object EquipmentDataSource {

    fun mockEquipments(): MutableList<EquipmentEntity> {
        return ExcelManager.getEquipmentExcel()?.let { ExcelAnalyze.analyzeExcel(it) } ?: mutableListOf()
    }
}