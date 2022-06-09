package com.nl.lib.element.role

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 玩家角色
 *
 * 2022/5/5
 * @author June
 */
@Entity(tableName = "player_roles")
data class PlayerRoleEntity(
    @PrimaryKey val id: String,
    val playerId: String,
    val roleId: String,
    val name: String,
    val nick: String,
    val avatar: String,
    val image: String,
    // experience
    val level: Int = 0,
    val experience: Long = 0L,
    val expNextLevel: Long = 0L,
    // 基本attr
    val attack: Int = 0,
    val defense: Int = 0,
    val health: Int = 0,
    val speed: Int = 0,
    val potential: Int = 0,
    // 额外attr
    val critical: Int = 0,
    val resister: Int = 0,
    val hit: Int = 0,
    val dodge: Int = 0,
    // 技能
    val skillPassive: String? = null,
    val skillInitiative: String? = null,
    // equipment
    val weapon: String? = null,
    val clothing: String? = null,
    val armor: String? = null,
    val shoes: String? = null,
    val ring: String? = null,
    val necklace: String? = null,
    val aid: String? = null,
    // 属性百分比
    val attackPercent: Float = 0.0F,
    val defensePercent: Float = 0.0F,
    val healthPercent: Float = 0.0F,
    val speedPercent: Float = 0.0F,
    val criticalPercent: Float = 0.0F,
    val resisterPercent: Float = 0.0F,
    val hitPercent: Float = 0.0F,
    val dodgePercent: Float = 0.0F,
    val damageIncreasePercent: Float = 0.0F,
    val damageReducePercent: Float = 0.0F,
)