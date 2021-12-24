package com.nl.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nl.lib.element.equipment.EquipmentDao
import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.lib.element.role.RoleDao
import com.nl.lib.element.role.RoleEntity

@Database(entities = [RoleEntity::class, EquipmentEntity::class], version = 2)
abstract class NorthLandDatabase : RoomDatabase() {

    abstract fun roleDao(): RoleDao

    abstract fun equipmentDao(): EquipmentDao
}