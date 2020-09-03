package com.june.northland.feature.battle.vo

class BattleResultVo(
    val ownSideList: MutableList<BattleVo>,
    val opponentList: MutableList<BattleVo>,
    val rounds: MutableList<RoundVo>,
    val ownSideDataList: MutableList<BattleDataVo>,
    val opponentDataList: MutableList<BattleDataVo>,
    val result: Boolean
)