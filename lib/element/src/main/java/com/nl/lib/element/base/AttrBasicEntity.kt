package com.nl.lib.element.base

/**
 * 属性实体
 */
data class AttrBasicEntity(
    val attack: Int,       // 攻击
    val defense: Int,      // 防御
    val health: Int,       // 生命
    val speed: Int,        // 速度
    val potential: Int,    // 潜力
    val attackGrowth: Int,
    val defenseGrowth: Int,
    val healthGrowth: Int,
    val potentialGrowth: Int
)
