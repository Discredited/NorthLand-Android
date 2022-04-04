package com.nl.lib.element.enum

import com.nl.lib.element.R

object QualityEnum {

    const val QUALITY_ALL = 0   // 全部
    const val QUALITY_N = 1     // 普通 normal
    const val QUALITY_R = 2     // 稀有 rare
    const val QUALITY_SR = 3    // 超级稀有 super rare
    const val QUALITY_SSR = 4   // 较高级的稀有 superior super rare
    const val QUALITY_UR = 5    // 极度稀有 ultra rare

    fun getQualityName(quality: Int): String {
        return when (quality) {
            QUALITY_N -> "N"
            QUALITY_R -> "R"
            QUALITY_SR -> "SR"
            QUALITY_SSR -> "SSR"
            QUALITY_UR -> "UR"
            else -> "-"
        }
    }

    fun getQualityColor(quality: Int): Int {
        return when (quality) {
            QUALITY_N -> R.color.color_quality_n
            QUALITY_R -> R.color.color_quality_r
            QUALITY_SR -> R.color.color_quality_sr
            QUALITY_SSR -> R.color.color_quality_ssr
            QUALITY_UR -> R.color.color_quality_ur
            else -> R.color.color_quality_ordinary
        }
    }
}