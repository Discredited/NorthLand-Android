package com.nl.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nl.lib.role.RoleDao
import com.nl.lib.role.RoleEntity

@Database(entities = [RoleEntity::class], version = 1)
abstract class NorthLandDatabase : RoomDatabase() {

    abstract fun roleDao(): RoleDao
}