package com.nl.room.source

import com.nl.lib.element.skill.SkillEntity
import com.nl.room.excel.ExcelAnalyze
import com.nl.room.excel.ExcelManager

object SkillDataSource {

    fun mockSkills(): MutableList<SkillEntity> {
        return ExcelManager.getSkillExcel()?.let { ExcelAnalyze.analyzeExcel(it) }?: mutableListOf()
    }
}