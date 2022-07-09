package com.nl.lib.element.enum

/**
 * 基本属性的枚举
 */
object PropertyEnum {

    const val PRO_NULL = -1         // 无效
    const val PRO_RANDOM = 0       // 随机属性

    // 基本属性
    const val PRO_ATTACK = 1        // 攻击
    const val PRO_DEFENSE = 2       // 防御
    const val PRO_HEALTH = 3        // 生命
    const val PRO_SPEED = 4         // 速度
    const val PRO_BASIC_RANDOM = 10 // 随机基础属性

    // 额外属性
    const val PRO_CRITICAL = 11      // 暴击
    const val PRO_RESISTER = 12      // 抵抗
    const val PRO_HIT = 13           // 命中
    const val PRO_DODGE = 14         // 闪避
    const val PRO_EXTRA_RANDOM = 20  // 随机额外属性

    // 其他属性
    const val PRO_SHIELD = 9         // 护盾
    const val PRO_DAMAGE = 101       // 伤害
    const val PRO_DAMAGE_TRUE = 102  // 真实伤害

    const val PRO_ACTION = 200       // 行动

    const val PRO_REVIVE = 300       // 复活
}