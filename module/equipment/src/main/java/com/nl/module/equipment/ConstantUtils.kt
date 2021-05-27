package com.nl.module.equipment

import com.nl.component.common.PropertyHelper

object ConstantUtils {

    fun randomEquipment(part: Int): EquipmentVo {
        return when (part) {
            EquipmentHelper.PART_TOPS -> {
                EquipmentVo(
                    R.drawable.ic_defense,
                    "防具",
                    100,
                    EquipmentHelper.PART_TOPS,
                    "222222",
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
                    100,
                    PropertyHelper.PRO_SPEED,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_RING -> {
                EquipmentVo(
                    R.drawable.ic_menu_practice,
                    "首饰",
                    100,
                    EquipmentHelper.PART_RING,
                    "444444",
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
                    100,
                    PropertyHelper.PRO_ATTACK,
                    "",
                    ""
                )
            }
        }

    }
}