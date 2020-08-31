package com.june.northland.feature.equipment

import com.blankj.utilcode.util.Utils
import com.june.northland.R

object EquipmentHelper {

    const val PART_ALL = 0  //所有部位
    const val PART_WEAPON = 1  //武器
    const val PART_ARMOR = 2  //防具
    const val PART_SHOES = 3  //鞋子
    const val PART_JEWELRY = 4  //首饰

    const val QUALITY_NORMAL = 0
    const val QUALITY_REFINE = 1
    const val QUALITY_FLAWLESS = 2
    const val QUALITY_EXTRAORDINARY = 3
    const val QUALITY_EXTREME = 4
    const val QUALITY_PEERLESS = 5

    const val OPERATE_STRENGTHEN = 0//强化
    const val OPERATE_FORGING = 1//锻造
    const val OPERATE_INCREASE = 2//增幅
    const val OPERATE_SPELL = 3//符篆

    fun equipmentQuality(quality: Int): String {
        val qualityId = when (quality) {
            QUALITY_REFINE -> R.string.equipment_refine
            QUALITY_FLAWLESS -> R.string.equipment_flawless
            QUALITY_EXTRAORDINARY -> R.string.equipment_extraordinary
            QUALITY_EXTREME -> R.string.equipment_extreme
            QUALITY_PEERLESS -> R.string.equipment_peerless
            else -> R.string.equipment_normal
        }
        return Utils.getApp().getString(qualityId)
    }
}