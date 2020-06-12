package com.june.northland.utils

import com.june.northland.R

object ColorUtils {

    fun getRealmColor(realm: Int): Int {
        return when (realm) {
            2 -> R.color.color_quality_intermediate
            3 -> R.color.color_quality_advanced
            4 -> R.color.color_quality_rare
            5 -> R.color.color_quality_artifact
            6 -> R.color.color_quality_brave
            7 -> R.color.color_quality_legend
            8 -> R.color.color_quality_epic
            else -> R.color.color_quality_ordinary
        }
    }
}