package com.nl.lib.element.equipment

import androidx.room.*

@Dao
interface EquipmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipment(vararg equipment: EquipmentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipments(equipments: MutableList<EquipmentEntity>)

    @Delete
    suspend fun deleteEquipments(vararg equipments: EquipmentEntity)

    @Update
    suspend fun updateEquipments(vararg equipments: EquipmentEntity)

    @Query("SELECT * FROM equipments")
    suspend fun loadEquipments(): List<EquipmentEntity>
}