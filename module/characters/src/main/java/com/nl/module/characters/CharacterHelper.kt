package com.nl.module.characters

import com.nl.component.R

/**
 * 人物常量和枚举定义
 */
object CharacterHelper {

    // 妖力|境界
    const val POWER_NONE = 0
    const val POWER_ONE = 1 // 1-身
    const val POWER_TWO = 2 // 2-受
    const val POWER_THREE = 3  //3-数
    const val POWER_FOUR = 4  //4-意
    const val POWER_FIVE = 5 // 5-神
    const val POWER_SIX = 6 // 6-转
    const val POWER_SEVEN = 7 // 7-世
    const val POWER_EIGHT = 8 // 8-末那
    const val POWER_NINE = 9 //9-阿赖耶

    const val REALM_ORDINARY = 0
    const val REALM_ADVANCED = 1
    const val REALM_RARE = 2
    const val REALM_ARTIFACT = 3
    const val REALM_EPIC = 4

    fun getRealmColor(realm: Int): Int {
        return when (realm) {
            REALM_ADVANCED -> R.color.color_quality_advanced
            REALM_RARE -> R.color.color_quality_rare
            REALM_ARTIFACT -> R.color.color_quality_artifact
            REALM_EPIC -> R.color.color_quality_epic
            else -> R.color.color_quality_ordinary
        }
    }
}