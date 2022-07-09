package com.nl.room.source

import com.nl.lib.element.effect.EffectEntity
import com.nl.room.excel.ExcelAnalyze
import com.nl.room.excel.ExcelManager
import timber.log.Timber

object EffectDataSource {

    fun mockEffects(): MutableList<EffectEntity> {
        return ExcelManager.getEffectExcel()?.let { ExcelAnalyze.analyzeExcel(it) } ?: mutableListOf()
    }
}