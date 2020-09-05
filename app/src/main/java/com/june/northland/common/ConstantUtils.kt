package com.june.northland.common

import com.june.northland.R
import com.june.northland.feature.battle.vo.BattleVo
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentVo

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

    fun randomEquipment(part: Int): EquipmentVo {
        return when (part) {
            EquipmentHelper.PART_ARMOR -> {
                EquipmentVo(
                    R.drawable.ic_defense,
                    "防具",
                    100,
                    EquipmentHelper.PART_ARMOR,
                    "222222",
                    0,
                    0,
                    100,
                    PropertyHelper.PRO_DEFENSE,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_SHOES -> {
                EquipmentVo(
                    R.drawable.ic_speed,
                    "鞋子",
                    100,
                    EquipmentHelper.PART_SHOES,
                    "333333",
                    0,
                    0,
                    100,
                    PropertyHelper.PRO_SPEED,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_JEWELRY -> {
                EquipmentVo(
                    R.drawable.ic_menu_practice,
                    "首饰",
                    100,
                    EquipmentHelper.PART_JEWELRY,
                    "444444",
                    0,
                    0,
                    100,
                    PropertyHelper.PRO_ATTACK,
                    "",
                    ""
                )
            }
            else -> {
                EquipmentVo(
                    R.drawable.ic_attack,
                    "武器",
                    100,
                    EquipmentHelper.PART_WEAPON,
                    "111111",
                    0,
                    0,
                    100,
                    PropertyHelper.PRO_ATTACK,
                    "",
                    ""
                )
            }
        }

    }
}