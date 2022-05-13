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
    // 基本attr
    val attack: Int,
    val defense: Int,
    val health: Int,
    val speed: Int,
    val potential: Int,
    // 额外attr
    val critical: Int,
    val resister: Int,
    val hit: Int,
    val dodge: Int,
    // 技能
    val skillPassive: String,
    val skillInitiative: String,
    // equipment
    val weapon: String? = null,
    val clothing: String? = null,
    val armor: String? = null,
    val shoes: String? = null,
    val ring: String? = null,
    val necklace: String? = null,
    val aid: String? = null,
)