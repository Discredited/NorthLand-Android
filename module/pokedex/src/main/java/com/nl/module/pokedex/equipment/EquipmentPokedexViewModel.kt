package com.nl.module.pokedex.equipment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.room.NorthLandDatabase
import com.nl.room.RoomHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EquipmentPokedexViewModel(application: Application) : AndroidViewModel(application) {

    fun equipmentPokedex(): Flow<MutableList<EquipmentEntity>> {
        return flow {
            //RoomHelper.getInstance().database().equipmentDao()
        }
    }
}