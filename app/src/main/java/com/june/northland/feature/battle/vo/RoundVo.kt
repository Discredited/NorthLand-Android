package com.june.northland.feature.battle.vo

/**
 * 回合
 */
data class RoundVo(
    val round: Int,
    val attackPosition: Int,
    val defenderPosition: IntArray = intArrayOf(0),
    val attackType: Int, //0-普通攻击  1-技能攻击
    val damage: Int,
    val damageType: Int  //0-普通伤害  1-暴击伤害  2-真实伤害
)