package com.june.northland.feature.dungeon

/**
 * 副本Vo
 * Dungeon 直译为:地牢、地下城，在游戏中表示副本的意思(来源于暴雪游戏)
 */
class DungeonVo(
    val dungeonName: String,
    val dungeonSubtitle: String,
    val dungeonIcon: Int,
    val dungeonProgress: String = ""
)