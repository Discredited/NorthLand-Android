package com.nl.lib.element.equipment

import androidx.room.*

@Dao
interface EquipmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipment(vararg role: EquipmentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipments(roles: MutableList<EquipmentEntity>)

    @Delete
    suspend fun deleteEquipments(vararg roles: EquipmentEntity)

    @Update
    suspend fun updateEquipments(vararg roles: EquipmentEntity)

    @Query("SELECT * FROM roles")
    suspend fun loadEquipments(): List<EquipmentEntity>
}