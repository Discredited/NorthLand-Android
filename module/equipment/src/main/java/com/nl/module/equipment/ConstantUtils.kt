package com.nl.module.equipment

import com.nl.component.common.PropertyHelper

object ConstantUtils {

    fun randomEquipment(part: Int): EquipmentVo {
        return when (part) {
            EquipmentHelper.PART_CLOTHING -> {
                EquipmentVo(
                    "寂灭战甲",
                    "1_normal/clothing.png",
                    100,
                    EquipmentHelper.PART_CLOTHING,
                    "222222",
                    0,
                    100,
                    PropertyHelper.PRO_HEALTH,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_ARMOR -> {
                EquipmentVo(
                    "寂灭盾牌",
                    "1_normal/armor.png",
                    100,
                    EquipmentHelper.PART_ARMOR,
                    "333333",
                    0,
                    100,
                    PropertyHelper.PRO_DEFENSE,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_SHOES -> {
                EquipmentVo(
                    "寂灭之靴",
                    "1_normal/shoes.png",
                    100,
                    EquipmentHelper.PART_SHOES,
                    "444444",
                    0,
                    100,
                    PropertyHelper.PRO_SPEED,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_RING -> {
                EquipmentVo(
                    "寂灭戒指",
                    "1_normal/ring.png",
                    100,
                    EquipmentHelper.PART_RING,
                    "555555",
                    0,
                    100,
                    PropertyHelper.PRO_CRITICAL,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_NECKLACE -> {
                EquipmentVo(
                    "寂灭项链",
                    "1_normal/necklace.png",
                    100,
                    EquipmentHelper.PART_NECKLACE,
                    "555555",
                    0,
                    100,
                    PropertyHelper.PRO_CRITICAL,
                    "",
                    ""
                )
            }
            EquipmentHelper.PART_AID -> {
                EquipmentVo(
                    "寂灭徽章",
                    "1_normal/aid.png",
                    100,
                    EquipmentHelper.PART_AID,
                    "666666",
                    0,
                    100,
                    PropertyHelper.PRO_CRITICAL,
                    "",
                    ""
                )
            }
            else -> {
                EquipmentVo(
                    "武器",
                    "1_normal/weapon.png",
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