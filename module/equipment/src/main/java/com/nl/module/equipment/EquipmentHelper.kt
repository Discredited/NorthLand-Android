package com.nl.module.equipment

import com.blankj.utilcode.util.Utils

object EquipmentHelper {

    const val PART_ALL = 0  // 所有部位
    const val PART_WEAPON = 1  // 武器
    const val PART_TOPS = 2  // 防具上装
    const val PART_BOTTOMS = 3 // 防具下装
    const val PART_SHOES = 4  //鞋子
    const val PART_RING = 5  //戒指
    const val PART_NECKLACE = 6  //项链

    const val QUALITY_NORMAL = 0  // 普通
    const val QUALITY_REFINE = 1  // 精炼
    const val QUALITY_FLAWLESS = 2  // 无暇
    const val QUALITY_EXTRAORDINARY = 3  // 非凡
    const val QUALITY_EXTREME = 4  // 至臻
    const val QUALITY_PEERLESS = 5  // 绝世

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