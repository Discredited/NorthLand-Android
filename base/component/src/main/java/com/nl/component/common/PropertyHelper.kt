package com.nl.component.common

import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.Utils
import com.nl.component.R

object PropertyHelper {

    const val PRO_ATTACK = 1  // 攻击
    const val PRO_DEFENSE = 2  // 防御
    const val PRO_HEALTH = 3  // 生命
    const val PRO_SPEED = 4  // 速度
    const val PRO_CRITICAL = 5  // 暴击
    const val PRO_RESISTER = 6  // 抵抗
    const val PRO_HIT = 7  // 命中
    const val PRO_DODGE = 8  // 闪避
    const val PRO_POTENTIAL = 9  // 暴击

    fun getPropertyName(property: Int): String {
        val strId = when (property) {
            PRO_ATTACK -> R.string.str_attack
            PRO_DEFENSE -> R.string.str_defense
            PRO_HEALTH -> R.string.str_health
            PRO_SPEED -> R.string.str_speed
            PRO_CRITICAL -> R.string.str_critical
            PRO_RESISTER -> R.string.str_resister
            PRO_HIT -> R.string.str_hit
            PRO_DODGE -> R.string.str_dodge
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
            PRO_ATTACK -> R.color.color_attack
            PRO_DEFENSE -> R.color.color_defense
            PRO_HEALTH -> R.color.color_health
            PRO_SPEED -> R.color.color_speed
            PRO_CRITICAL -> R.color.color_health
            PRO_RESISTER -> R.color.color_health
            PRO_HIT -> R.color.color_health
            PRO_DODGE -> R.color.color_health
            else -> R.color.color_text_1E2E50
        }
        return ContextCompat.getColor(Utils.getApp(), colorId)
    }
}