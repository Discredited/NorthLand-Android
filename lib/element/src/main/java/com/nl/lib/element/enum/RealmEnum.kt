package com.nl.lib.element.enum

import com.nl.lib.element.R

/**
 * 境界枚举
 */
object RealmEnum {

    const val REALM_0 = 0
    const val REALM_0_NAME = "无"
    const val REALM_1 = 1
    const val REALM_1_NAME = "由技入道"
    const val REALM_2 = 2
    const val REALM_2_NAME = "天人感应"
    const val REALM_3 = 3
    const val REALM_3_NAME = "空"
    const val REALM_4 = 4
    const val REALM_4_NAME = "妙有"
    const val REALM_5 = 5
    const val REALM_5_NAME = "知微"

    fun getRealmName(realm: Int): String {
        return when (realm) {
            REALM_1 -> REALM_1_NAME
            REALM_2 -> REALM_2_NAME
            REALM_3 -> REALM_3_NAME
            REALM_4 -> REALM_4_NAME
            REALM_5 -> REALM_5_NAME
            else -> REALM_0_NAME
        }
    }

    fun getRealmColor(realm: Int): Int {
        return when (realm) {
            REALM_1 -> R.color.color_quality_n
            REALM_2 -> R.color.color_quality_r
            REALM_3 -> R.color.color_quality_sr
            REALM_4 -> R.color.color_quality_ssr
            REALM_5 -> R.color.color_quality_ur
            else -> R.color.color_quality_ordinary
        }
    }
}