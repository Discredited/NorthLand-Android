package com.nl.component.common

import com.nl.component.R


object ColorUtils {

    fun getPowerColor(realm: Int): Int {
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

    fun equipmentQualityColor(quality: Int): Int {
        return when (quality) {
            //精炼
            1 -> R.color.color_equipment_refine
            //无暇
            2 -> R.color.color_equipment_flawless
            //非凡
            3 -> R.color.color_equipment_extraordinary
            //至臻
            4 -> R.color.color_equipment_extreme
            //绝世
            5 -> R.color.color_equipment_peerless
            //普通
            else -> R.color.color_equipment_normal
        }
    }
}