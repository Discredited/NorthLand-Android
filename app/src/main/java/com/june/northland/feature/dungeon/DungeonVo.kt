package com.june.northland.feature.dungeon

/**
 * 副本Vo
 * Dungeon 直译为:地牢、地下城，在游戏中表示副本的意思(来源于暴雪游戏)
 * Raid   译为刷副本
 */
class DungeonVo(
    val title: String,
    val subsection: String,
    val icon: Int,
    val raidCost: Int = 5,  //闯关花费
    val passTarget: Int = 3,  //通关目标
    val passResult: Int = 0   //通过结果
)