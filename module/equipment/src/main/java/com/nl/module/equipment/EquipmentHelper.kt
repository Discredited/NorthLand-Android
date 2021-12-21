package com.nl.module.equipment

import com.blankj.utilcode.util.Utils

object EquipmentHelper {

    /**
     * 装备部位
     * 武器：固定属性攻击
     * 服装：固定属性生命
     * 防具：固定属性防御
     * 鞋子：固定属性速度
     * 戒指：固定属性攻击、生命、防御、暴击、抵抗、命中、闪避
     * 项链：固定属性攻击、生命、防御、暴击、抵抗、命中、闪避
     */
    const val PART_ALL = 0  // 所有部位
    const val PART_WEAPON = 1  // 武器
    const val PART_CLOTHING = 2  // 服装
    const val PART_ARMOR = 3 // 防具
    const val PART_SHOES = 4  // 鞋子
    const val PART_RING = 5  // 戒指
    const val PART_NECKLACE = 6  // 项链
    const val PART_AID = 7  // 辅助装备

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
            QUALITY_REFINE -> R.color.color_equipment_refine
            //无暇
            QUALITY_FLAWLESS -> R.color.color_equipment_flawless
            //非凡
            QUALITY_EXTRAORDINARY -> R.color.color_equipment_extraordinary
            //至臻
            QUALITY_EXTREME -> R.color.color_equipment_extreme
            //绝世
            QUALITY_PEERLESS -> R.color.color_equipment_peerless
            //普通
            else -> R.color.color_equipment_normal
        }
    }

    fun equipmentIcon(quality: Int): String {
        return when (quality) {
            // 精炼
            QUALITY_REFINE -> "2_refine/weapon.png"
            // 无暇
            QUALITY_FLAWLESS -> "3_flawless/weapon.png"
            // 非凡
            QUALITY_EXTRAORDINARY -> "4_extraordinary/weapon.png"
            // 至臻
            QUALITY_EXTREME -> "5_extreme/weapon.png"
            // 绝世
            QUALITY_PEERLESS -> "6_peerless/weapon.png"
            // 無名
            QUALITY_NAMELESS -> "7_nameless/weapon.png"
            // 普通
            else -> "1_normal/weapon.png"
        }
    }

    fun equipmentNextQuality(equipment: EquipmentVo): EquipmentVo {
        val quality = equipment.quality + 1
        val name = "${equipmentQuality(quality)}长剑"
        val icon = equipmentIcon(quality)

        return EquipmentVo(
            name = name,
            icon = icon,
            value = equipment.value,
            part = equipment.part,
            id = equipment.id,
            quality = quality,
            valueUpgrade = equipment.valueUpgrade,
            property = equipment.property,
            basicDesc = equipment.basicDesc,
            extraDesc = equipment.extraDesc,
            strengthenMax = equipment.strengthenMax,
            strengthen = equipment.strengthen,
            strengthenAdditions = equipment.strengthenAdditions
        )
    }
}