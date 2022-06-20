package com.nl.module.battle.vo

/**
 * 战斗结果
 */
data class BattleResultVo(
    val ownSideList: MutableList<BattleVo>,
    val opponentList: MutableList<BattleVo>,
    val rounds: MutableList<RoundVo>,
    val ownSideDataList: MutableList<BattleDataVo>,
    val opponentDataList: MutableList<BattleDataVo>,
    val result: Boolean
)