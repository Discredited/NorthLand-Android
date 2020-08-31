package com.june.northland.common

import com.blankj.utilcode.util.Utils
import com.june.northland.R

object PropertyHelper {

    const val PRO_ATTACK = 1
    const val PRO_DEFENSE = 2
    const val PRO_HEALTH = 3
    const val PRO_SPEED = 4
    const val PRO_CRITICAL = 5
    const val PRO_RESISTER = 6
    const val PRO_HIT = 7
    const val PRO_DODGE = 8

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
}