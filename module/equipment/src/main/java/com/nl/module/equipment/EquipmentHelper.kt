package com.nl.module.equipment

import com.blankj.utilcode.util.Utils

object EquipmentHelper {

    /**
     * 装备部位
     * 武器：固定属性攻击
     * 服装：固定属性生命
     * 防具：固定属性防御
     * 鞋子：固定属性速度
     * 戒指：固定属性攻击、生命、防御
     * 项链：固定属性攻击、生命、防御
     */
    const val PART_ALL = 0  // 所有部位
    const val PART_WEAPON = 1  // 武器
    const val PART_CLOTHING = 2  // 服装
    const val PART_ARMOR = 3 // 防具
    const val PART_SHOES = 4  // 鞋子
    const val PART_RING = 5  // 戒指
    const val PART_NECKLACE = 6  // 项链
    const val PART_AID = 6  // 辅助装备

    /**
     * 品质
     */
    const val QUALITY_NORMAL = 0  // 普通
    const val QUALITY_REFINE = 1  // 精炼
    const val QUALITY_FLAWLESS = 2  // 无暇
    const val QUALITY_EXTRAORDINARY = 3  // 非凡
    const val QUALITY_EXTREME = 4  // 至臻
    const val QUALITY_PEERLESS = 5  // 绝世
    const val QUALITY_NAMELESS = 6  // 無名

    const val OPERATE_STRENGTHEN = 0  // 强化
    const val OPERATE_FORGING = 1  // 锻造
    const val OPERATE_INCREASE = 2  // 增幅
    const val OPERATE_SPELL = 3  // 符篆

    fun equipmentQuality(quality: Int): String {
        val qualityId = when (quality) {
            QUALITY_REFINE -> R.string.equipment_refine
            QUALITY_FLAWLESS -> R.string.equipment_flawless
            QUALITY_EXTRAORDINARY -> R.string.equipment_extraordinary
            QUALITY_EXTREME -> R.string.equipment_extreme
            QUALITY_PEERLESS -> R.string.equipment_peerless
            QUALITY_NAMELESS -> R.string.equipment_name_less
            else -> R.string.equipment_normal
        }
        return Utils.getApp().getString(qualityId)
    }

    fun equipmentQualityColor(quality: Int): Int {
        return when (quality) {
            //精炼
            1 -> R.color.color_equipment_refine
            //无暇
            2 -> R.color.color_equipment_flawless
            //非凡
            3 -> R.color.color_equipment_extraordinary
            //至臻
            4 -> R.color.color_equipment_extreme
            //绝世
            5 -> R.color.color_equipment_peerless
            //普通
            else -> R.color.color_equipment_normal
        }
    }
}