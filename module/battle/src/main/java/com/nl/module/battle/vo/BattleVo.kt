package com.nl.module.battle.vo

data class BattleVo(
    val id: String,
    val avatar: String,
    val name: String,
    val power: Int,
    val health: Int,
    val speed: Int,
    val lineupPosition: Int
)