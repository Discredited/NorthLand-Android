package com.nl.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nl.lib.element.effect.EffectDao
import com.nl.lib.element.effect.EffectEntity
import com.nl.lib.element.equipment.EquipmentDao
import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.lib.element.role.RoleDao
import com.nl.lib.element.role.RoleEntity
import com.nl.lib.element.skill.SkillDao
import com.nl.lib.element.skill.SkillEntity

@Database(
    entities = [
        RoleEntity::class,
        EquipmentEntity::class,
        SkillEntity::class,
        EffectEntity::class
    ],
    version = 1
)
abstract class NorthLandDatabase : RoomDatabase() {

    abstract fun roleDao(): RoleDao

    abstract fun equipmentDao(): EquipmentDao

    abstract fun skillDao(): SkillDao

    abstract fun effectDao(): EffectDao
}