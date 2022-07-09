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

    /**
     * 查找装备列表
     */
    @Query("SELECT * FROM equipments")
    suspend fun loadEquipments(): MutableList<EquipmentEntity>

    /**
     * 根据部位查找装备列表
     */
    @Query("SELECT * FROM equipments WHERE part = :part")
    suspend fun loadEquipmentsByPart(part: Int): MutableList<EquipmentEntity>
}