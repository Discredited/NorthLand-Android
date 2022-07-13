package com.nl.lib.element.base

import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.Utils
import com.nl.lib.element.R
import com.nl.lib.element.enum.PropertyEnum

/**
 * 和资源相关的属性帮助类
 */
object PropertyHelper {

    fun getPropertyName(property: Int): String {
        val strId = when (property) {
            PropertyEnum.PRO_RANDOM -> R.string.str_property_random
            PropertyEnum.PRO_ATTACK -> R.string.str_attack
            PropertyEnum.PRO_DEFENSE -> R.string.str_defense
            PropertyEnum.PRO_HEALTH -> R.string.str_health
            PropertyEnum.PRO_SPEED -> R.string.str_speed
            PropertyEnum.PRO_BASIC_RANDOM -> R.string.str_property_basic_random
            PropertyEnum.PRO_CRITICAL -> R.string.str_critical
            PropertyEnum.PRO_RESISTER -> R.string.str_resister
            PropertyEnum.PRO_HIT -> R.string.str_hit
            PropertyEnum.PRO_DODGE -> R.string.str_dodge
            PropertyEnum.PRO_EXTRA_RANDOM -> R.string.str_property_extra_random
            else -> 0
        }
        return if (strId == 0) {
            ""
        } else {
            Utils.getApp().getString(strId)
        }
    }

    fun getPropertyColor(property: Int): Int {
        val colorId = when (property) {
            PropertyEnum.PRO_ATTACK -> R.color.color_attack
            PropertyEnum.PRO_DEFENSE -> R.color.color_defense
            PropertyEnum.PRO_HEALTH -> R.color.color_health
            PropertyEnum.PRO_SPEED -> R.color.color_speed
            PropertyEnum.PRO_CRITICAL -> R.color.color_health
            PropertyEnum.PRO_RESISTER -> R.color.color_health
            PropertyEnum.PRO_HIT -> R.color.color_health
            PropertyEnum.PRO_DODGE -> R.color.color_health
            else -> R.color.color_text_1E2E50
        }
        return ContextCompat.getColor(Utils.getApp(), colorId)
    }
}