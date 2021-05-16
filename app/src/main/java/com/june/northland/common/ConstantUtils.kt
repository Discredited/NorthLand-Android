package com.june.northland.common

import com.june.northland.feature.battle.vo.BattleVo
import com.nl.component.common.FilePathHelper

object ConstantUtils {

    private val AVATAR_SET: Array<String> = arrayOf(
        "gan_ning_zhen.png",
        "hai_ji.png",
        "jiu_dan_mei.png",
        "lin_fei.png",
        "ding_xiang_chou.png"
    )

    private val NAME_SET: Array<String> = arrayOf(
        "甘柠真",
        "海姬",
        "鸠丹媚",
        "林飞",
        "丁香愁"
    )

    fun randomBattleVo(position: Int = 0): BattleVo {
        val random = (Math.random() * 100).toInt() % AVATAR_SET.size
        val name = NAME_SET[random]
        val avatar = FilePathHelper.getCharacterAvatar(AVATAR_SET[random])
        return BattleVo("$position", avatar, name, position, 250, 100, position)
    }
}