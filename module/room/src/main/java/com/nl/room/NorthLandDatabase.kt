package com.nl.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nl.lib.element.effect.EffectDao
import com.nl.lib.element.effect.EffectEntity
import com.nl.lib.element.effect.PlayerEffectDao
import com.nl.lib.element.effect.PlayerEffectEntity
import com.nl.lib.element.equipment.EquipmentDao
import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.lib.element.player.PlayerDao
import com.nl.lib.element.player.PlayerEntity
import com.nl.lib.element.role.PlayerRoleDao
import com.nl.lib.element.role.PlayerRoleEntity
import com.nl.lib.element.role.RoleDao
import com.nl.lib.element.role.RoleEntity
import com.nl.lib.element.skill.PlayerRoleSkillDao
import com.nl.lib.element.skill.PlayerRoleSkillEntity
import com.nl.lib.element.skill.SkillDao
import com.nl.lib.element.skill.SkillEntity

@Database(
    entities = [
        RoleEntity::class,
        PlayerRoleEntity::class,
        EquipmentEntity::class,
        SkillEntity::class,
        PlayerRoleSkillEntity::class,
        EffectEntity::class,
        PlayerEffectEntity::class,
        PlayerEntity::class,
    ],
    version = 1
)
abstract class NorthLandDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    abstract fun roleDao(): RoleDao

    abstract fun playerRoleDao(): PlayerRoleDao

    abstract fun skillDao(): SkillDao

    abstract fun playerRoleSkillDao(): PlayerRoleSkillDao

    abstract fun effectDao(): EffectDao

    abstract fun playerEffectDao(): PlayerEffectDao

    abstract fun equipmentDao(): EquipmentDao
}