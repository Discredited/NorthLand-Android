package com.june.northland.feature.battle.vo

/**
 * 对战列表
 */
data class BattleListVo(
    val ownSideList: MutableList<BattleVo>,
    val opponentList: MutableList<BattleVo>
)