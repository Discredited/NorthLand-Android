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
    val passResult: Int = 0,   //通过结果
    val plot: Int = 0  //是含有剧情  0-没有剧情 1-需要显示剧情
) {
    fun hasPlot(): Boolean = plot == 1
}