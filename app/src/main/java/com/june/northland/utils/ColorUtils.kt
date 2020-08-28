package com.june.northland.utils

import com.june.northland.R

object ColorUtils {

    fun getRealmColor(realm: Int): Int {
        return when (realm) {
            //1-身  2-受  3-数
            1, 2, 3 -> R.color.color_quality_advanced
            //4-意  5-神
            4, 5 -> R.color.color_quality_rare
            //6-转  7-世
            6, 7 -> R.color.color_quality_artifact
            //8-末那  9-阿赖耶
            8, 9 -> R.color.color_quality_epic
            else -> R.color.color_quality_ordinary
        }
    }
}