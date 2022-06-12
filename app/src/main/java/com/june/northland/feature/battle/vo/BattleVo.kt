package com.june.northland.feature.battle.vo

data class BattleVo(
    val id: String,
    val avatar: String,
    val name: String,
    val power: Int,
    val health: Int,
    val speed: Int,
    val lineupPosition: Int
)