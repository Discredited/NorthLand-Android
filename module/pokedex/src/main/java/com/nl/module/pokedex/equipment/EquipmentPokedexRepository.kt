package com.nl.module.pokedex.equipment

import com.nl.room.RoomHelper
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map

class EquipmentPokedexRepository {

    suspend fun equipmentPokedex() {
        RoomHelper.getInstance().database().equipmentDao().loadEquipments().asFlow().map {

        }
    }
}