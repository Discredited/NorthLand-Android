package com.nl.lib.element.equipment

object EquipmentEnum {

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

    /**
     * 武器强化
     */
    const val OPERATE_STRENGTHEN = 0  // 强化
    const val OPERATE_FORGING = 1  // 锻造
    const val OPERATE_INCREASE = 2  // 增幅
    const val OPERATE_SPELL = 3  // 符篆
}