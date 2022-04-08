package com.nl.room.source

import com.nl.lib.element.enum.PropertyEnum
import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.lib.element.equipment.EquipmentEnum

object EquipmentDataSource {

    fun mockEquipments(): MutableList<EquipmentEntity> {
        return mutableListOf<EquipmentEntity>().apply {
            addAll(equipmentNormal())
            addAll(equipmentRefine())
            addAll(equipmentFlawless())
            addAll(equipmentExtraordinary())
            addAll(equipmentExtreme())
            addAll(equipmentPeerless())
        }
    }

    /**
     * 普通
     */
    fun equipmentNormal(): MutableList<EquipmentEntity> {
        return mutableListOf(
            EquipmentEntity(
                id = "000001",
                name = "普通长剑",
                icon = "1_normal/weapon.png",
                part = EquipmentEnum.PART_WEAPON,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "普普通通的长剑",
                extraDesc = "长剑长剑长剑长剑",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000002",
                name = "普通战甲",
                icon = "1_normal/clothing.png",
                part = EquipmentEnum.PART_CLOTHING,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_HEALTH,
                basicDesc = "普普通通的战甲",
                extraDesc = "战甲战甲战甲",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000003",
                name = "普通盾牌",
                icon = "1_normal/armor.png",
                part = EquipmentEnum.PART_ARMOR,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_DEFENSE,
                basicDesc = "普普通通的盾牌",
                extraDesc = "盾牌盾牌盾牌盾牌",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000004",
                name = "普通战靴",
                icon = "1_normal/shoes.png",
                part = EquipmentEnum.PART_SHOES,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_SPEED,
                basicDesc = "普普通通的战靴",
                extraDesc = "战靴战靴战靴战靴",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000005",
                name = "普通戒指",
                icon = "1_normal/ring.png",
                part = EquipmentEnum.PART_RING,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "普普通通的戒指",
                extraDesc = "戒指戒指戒指戒指",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000006",
                name = "普通项链",
                icon = "1_normal/necklace.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "普普通通的项链",
                extraDesc = "项链项链项链项链",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000007",
                name = "普通胸章",
                icon = "1_normal/aid.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_NORMAL,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "普普通通的胸章",
                extraDesc = "胸章胸章胸章胸章",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            )
        )
    }

    /**
     * 精炼
     */
    fun equipmentRefine(): MutableList<EquipmentEntity> {
        return mutableListOf(
            EquipmentEntity(
                id = "000011",
                name = "精炼长剑",
                icon = "2_refine/weapon.png",
                part = EquipmentEnum.PART_WEAPON,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "精炼的长剑",
                extraDesc = "长剑长剑长剑长剑",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000012",
                name = "精炼战甲",
                icon = "2_refine/clothing.png",
                part = EquipmentEnum.PART_CLOTHING,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_HEALTH,
                basicDesc = "精炼的战甲",
                extraDesc = "战甲战甲战甲",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000013",
                name = "精炼盾牌",
                icon = "2_refine/armor.png",
                part = EquipmentEnum.PART_ARMOR,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_DEFENSE,
                basicDesc = "精炼的盾牌",
                extraDesc = "盾牌盾牌盾牌盾牌",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000014",
                name = "精炼战靴",
                icon = "2_refine/shoes.png",
                part = EquipmentEnum.PART_SHOES,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_SPEED,
                basicDesc = "精炼的战靴",
                extraDesc = "战靴战靴战靴",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000015",
                name = "精炼戒指",
                icon = "2_refine/ring.png",
                part = EquipmentEnum.PART_RING,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "精炼的长剑",
                extraDesc = "戒指戒指戒指",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000016",
                name = "精炼项链",
                icon = "2_refine/necklace.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "精炼的项链",
                extraDesc = "项链项链项链",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000017",
                name = "精炼胸章",
                icon = "2_refine/aid.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_REFINE,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "精炼的胸章",
                extraDesc = "胸章胸章胸章",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            )
        )
    }

    /**
     * 无瑕
     */
    fun equipmentFlawless(): MutableList<EquipmentEntity> {
        return mutableListOf(
            EquipmentEntity(
                id = "000021",
                name = "无暇长剑",
                icon = "3_flawless/weapon.png",
                part = EquipmentEnum.PART_WEAPON,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "无暇的长剑",
                extraDesc = "长剑长剑长剑长剑",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000022",
                name = "无暇战甲",
                icon = "3_flawless/clothing.png",
                part = EquipmentEnum.PART_CLOTHING,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_HEALTH,
                basicDesc = "无暇的战甲",
                extraDesc = "战甲战甲战甲",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000023",
                name = "无暇盾牌",
                icon = "3_flawless/armor.png",
                part = EquipmentEnum.PART_ARMOR,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_DEFENSE,
                basicDesc = "无暇的盾牌",
                extraDesc = "盾牌盾牌盾牌盾牌",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000024",
                name = "无暇战靴",
                icon = "3_flawless/shoes.png",
                part = EquipmentEnum.PART_SHOES,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_SPEED,
                basicDesc = "无暇的战靴",
                extraDesc = "战靴战靴战靴",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000025",
                name = "无暇戒指",
                icon = "3_flawless/ring.png",
                part = EquipmentEnum.PART_RING,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "无暇的长剑",
                extraDesc = "戒指戒指戒指",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000026",
                name = "无暇项链",
                icon = "3_flawless/necklace.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "无暇的项链",
                extraDesc = "项链项链项链",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000027",
                name = "无暇徽章",
                icon = "3_flawless/aid.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "无暇的徽章",
                extraDesc = "徽章徽章徽章",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            )
        )
    }

    /**
     * 非凡
     */
    fun equipmentExtraordinary(): MutableList<EquipmentEntity> {
        return mutableListOf(
            EquipmentEntity(
                id = "000031",
                name = "非凡长剑",
                icon = "4_extraordinary/weapon.png",
                part = EquipmentEnum.PART_WEAPON,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "非凡的长剑",
                extraDesc = "长剑长剑长剑长剑",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000032",
                name = "非凡战甲",
                icon = "4_extraordinary/clothing.png",
                part = EquipmentEnum.PART_CLOTHING,
                quality = EquipmentEnum.QUALITY_FLAWLESS,
                property = PropertyEnum.PRO_HEALTH,
                basicDesc = "非凡的战甲",
                extraDesc = "战甲战甲战甲",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000033",
                name = "非凡盾牌",
                icon = "4_extraordinary/armor.png",
                part = EquipmentEnum.PART_ARMOR,
                quality = EquipmentEnum.QUALITY_EXTRAORDINARY,
                property = PropertyEnum.PRO_DEFENSE,
                basicDesc = "非凡的盾牌",
                extraDesc = "盾牌盾牌盾牌盾牌",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000034",
                name = "非凡战靴",
                icon = "4_extraordinary/shoes.png",
                part = EquipmentEnum.PART_SHOES,
                quality = EquipmentEnum.QUALITY_EXTRAORDINARY,
                property = PropertyEnum.PRO_SPEED,
                basicDesc = "非凡的战靴",
                extraDesc = "战靴战靴战靴",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000035",
                name = "非凡戒指",
                icon = "4_extraordinary/ring.png",
                part = EquipmentEnum.PART_RING,
                quality = EquipmentEnum.QUALITY_EXTRAORDINARY,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "非凡的长剑",
                extraDesc = "戒指戒指戒指",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000036",
                name = "非凡项链",
                icon = "4_extraordinary/necklace.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_EXTRAORDINARY,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "非凡的项链",
                extraDesc = "项链项链项链",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000037",
                name = "非凡徽章",
                icon = "4_extraordinary/aid.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_EXTRAORDINARY,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "非凡的徽章",
                extraDesc = "徽章徽章徽章",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            )
        )
    }

    /**
     * 至臻
     */
    fun equipmentExtreme(): MutableList<EquipmentEntity> {
        return mutableListOf(
            EquipmentEntity(
                id = "000041",
                name = "至臻长剑",
                icon = "5_extreme/weapon.png",
                part = EquipmentEnum.PART_WEAPON,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "至臻的长剑",
                extraDesc = "长剑长剑长剑长剑",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000042",
                name = "至臻战甲",
                icon = "5_extreme/clothing.png",
                part = EquipmentEnum.PART_CLOTHING,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_HEALTH,
                basicDesc = "至臻的战甲",
                extraDesc = "战甲战甲战甲",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000043",
                name = "至臻盾牌",
                icon = "5_extreme/armor.png",
                part = EquipmentEnum.PART_ARMOR,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_DEFENSE,
                basicDesc = "至臻的盾牌",
                extraDesc = "盾牌盾牌盾牌盾牌",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000044",
                name = "至臻战靴",
                icon = "5_extreme/shoes.png",
                part = EquipmentEnum.PART_SHOES,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_SPEED,
                basicDesc = "至臻的战靴",
                extraDesc = "战靴战靴战靴",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000045",
                name = "至臻戒指",
                icon = "5_extreme/ring.png",
                part = EquipmentEnum.PART_RING,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "至臻的长剑",
                extraDesc = "戒指戒指戒指",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000046",
                name = "至臻项链",
                icon = "5_extreme/necklace.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "至臻的项链",
                extraDesc = "项链项链项链",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000047",
                name = "至臻徽章",
                icon = "5_extreme/aid.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_EXTREME,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "至臻的徽章",
                extraDesc = "徽章徽章徽章",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            )
        )
    }

    /**
     * 绝世
     */
    fun equipmentPeerless(): MutableList<EquipmentEntity> {
        return mutableListOf(
            EquipmentEntity(
                id = "000051",
                name = "绝世长剑",
                icon = "6_peerless/weapon.png",
                part = EquipmentEnum.PART_WEAPON,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "绝世的长剑",
                extraDesc = "长剑长剑长剑长剑",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000052",
                name = "绝世战甲",
                icon = "6_peerless/clothing.png",
                part = EquipmentEnum.PART_CLOTHING,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_HEALTH,
                basicDesc = "绝世的战甲",
                extraDesc = "战甲战甲战甲",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000053",
                name = "绝世盾牌",
                icon = "6_peerless/armor.png",
                part = EquipmentEnum.PART_ARMOR,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_DEFENSE,
                basicDesc = "绝世的盾牌",
                extraDesc = "盾牌盾牌盾牌盾牌",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000054",
                name = "绝世战靴",
                icon = "6_peerless/shoes.png",
                part = EquipmentEnum.PART_SHOES,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_SPEED,
                basicDesc = "绝世的战靴",
                extraDesc = "战靴战靴战靴",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000055",
                name = "绝世戒指",
                icon = "6_peerless/ring.png",
                part = EquipmentEnum.PART_RING,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "绝世的长剑",
                extraDesc = "戒指戒指戒指",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000056",
                name = "绝世项链",
                icon = "6_peerless/necklace.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "绝世的项链",
                extraDesc = "项链项链项链",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            ),
            EquipmentEntity(
                id = "000057",
                name = "绝世徽章",
                icon = "6_peerless/aid.png",
                part = EquipmentEnum.PART_ALL,
                quality = EquipmentEnum.QUALITY_PEERLESS,
                property = PropertyEnum.PRO_ATTACK,
                basicDesc = "绝世的徽章",
                extraDesc = "徽章徽章徽章",
                value = 30,
                valueGrowth = 4,
                strength = 0,
                strengthMax = 100,
                strengthValue = 5
            )
        )
    }
}