package com.nl.lib.element.enum

object PowerEnum {

    const val POWER_0 = 0
    const val POWER_0_NAME = "无"
    const val POWER_1 = 1
    const val POWER_1_NAME = "身"
    const val POWER_2 = 2
    const val POWER_2_NAME = "受"
    const val POWER_3 = 3
    const val POWER_3_NAME = "数"
    const val POWER_4 = 4
    const val POWER_4_NAME = "意"
    const val POWER_5 = 5
    const val POWER_5_NAME = "神"
    const val POWER_6 = 6
    const val POWER_6_NAME = "转"
    const val POWER_7 = 7
    const val POWER_7_NAME = "世"
    const val POWER_8 = 8
    const val POWER_8_NAME = "末那"
    const val POWER_9 = 9
    const val POWER_9_NAME = "阿赖耶"

    fun getPowerName(power: Int): String {
        return when (power) {
            POWER_1 -> POWER_1_NAME
            POWER_2 -> POWER_2_NAME
            POWER_3 -> POWER_3_NAME
            POWER_4 -> POWER_4_NAME
            POWER_5 -> POWER_5_NAME
            POWER_6 -> POWER_6_NAME
            POWER_7 -> POWER_7_NAME
            POWER_8 -> POWER_8_NAME
            POWER_9 -> POWER_9_NAME
            else -> POWER_0_NAME
        }
    }
}