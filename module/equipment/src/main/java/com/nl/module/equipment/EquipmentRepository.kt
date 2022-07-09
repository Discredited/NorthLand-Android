package com.nl.module.equipment

import com.nl.room.RoomHelper

class EquipmentRepository {

    private val mEquipmentDao by lazy { RoomHelper.getInstance().database().equipmentDao() }

    suspend fun equipmentList(part: Int): MutableList<EquipmentVo> {
        val entityList = if (part == EquipmentHelper.PART_ALL) {
            mEquipmentDao.loadEquipments()
        } else {
            mEquipmentDao.loadEquipmentsByPart(part)
        }
        return entityList.map {
            EquipmentVo(
                id = it.id,
                name = it.name,
                icon = it.icon,
                part = it.part,
                quality = it.quality,
                value = it.value,
                valueGrowth = it.valueGrowth,
                property = it.property,
                basicDesc = it.basicDesc,
                extraDesc = it.extraDesc,
                strengthen = it.strength,
                strengthenGrowth = it.strength,
                forging = it.forging,
                forgingGrowth = it.forgingGrowth
            )
        }.toMutableList()
    }
}