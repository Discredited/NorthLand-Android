package com.nl.lib.element.enum

/**
 * 种族
 *
 * 2022/4/3
 * @author June
 */
object RaceEnum {

    const val UN_KNOW = 0       // 未知
    const val UN_KNOW_NAME = "未知"
    const val HALF_DEMON = 1    // 人妖|半妖
    const val HALF_DEMON_NAME = "半妖"
    const val HUMAN = 2         // 人类
    const val HUMAN_NAME = "人类"
    const val DEMON = 3         // 妖怪
    const val DEMON_NAME = "妖怪"
    const val EERIE = 4         // 天精
    const val EERIE_NAME = "天精"
    const val FAIRY = 5         // 精怪
    const val FAIRY_NAME = "精怪"
    const val PROTECTOR = 6     // 守护者
    const val PROTECTOR_NAME = "守护者"
    const val SOUL_WEAPON = 7   // 魂器
    const val SOUL_WEAPON_NAME = "魂器"

    fun getRaceName(race: Int): String {
        return when (race) {
            HALF_DEMON -> HALF_DEMON_NAME
            HUMAN -> HUMAN_NAME
            DEMON -> DEMON_NAME
            EERIE -> EERIE_NAME
            FAIRY -> FAIRY_NAME
            PROTECTOR -> PROTECTOR_NAME
            SOUL_WEAPON -> SOUL_WEAPON_NAME
            else -> UN_KNOW_NAME
        }
    }
}