package com.nl.lib.element.enum

/**
 * 阵营枚举
 *
 * 2022/4/3
 * @author June
 */
object FactionEnum {

    const val SKY_UN_KNOW = 0      //未知
    const val SKY_UN_KNOW_NAME = "未知"

    const val SKY_HONG_CHEN = 1    //红尘天
    const val SKY_HONG_CHEN_NAME = "红尘天"

    const val SKY_MO_SHA = 2       //魔刹天
    const val SKY_MO_SHA_NAME = "魔刹天"

    const val SKY_LUO_SHENG = 3    //罗生天
    const val SKY_LUO_SHENG_NAME = "罗生天"

    const val SKY_QING_XU = 4      //清虚天
    const val SKY_QING_XU_NAME = "清虚天"

    const val SKY_JI_XIANG = 5     //吉祥天
    const val SKY_JI_XIANG_NAME = "吉祥天"

    const val SKY_SE_YU = 6        //色欲天
    const val SKY_SE_YU_NAME = "色欲天"

    const val SKY_LING_BAO = 7     //灵宝天
    const val SKY_LING_BAO_NAME = "灵宝天"

    const val SKY_HUANG_QUAN = 8   //黄泉天
    const val SKY_HUANG_QUAN_NAME = "黄泉天"

    const val SKY_FREEDOM = 9      //自在天
    const val SKY_FREEDOM_NAME = "自在天"

    fun getFactionName(faction: Int): String {
        return when (faction) {
            SKY_HONG_CHEN -> SKY_HONG_CHEN_NAME
            SKY_MO_SHA -> SKY_MO_SHA_NAME
            SKY_LUO_SHENG -> SKY_LUO_SHENG_NAME
            SKY_QING_XU -> SKY_QING_XU_NAME
            SKY_JI_XIANG -> SKY_JI_XIANG_NAME
            SKY_SE_YU -> SKY_SE_YU_NAME
            SKY_LING_BAO -> SKY_LING_BAO_NAME
            SKY_HUANG_QUAN -> SKY_HUANG_QUAN_NAME
            SKY_FREEDOM -> SKY_FREEDOM_NAME
            else -> SKY_UN_KNOW_NAME
        }
    }
}