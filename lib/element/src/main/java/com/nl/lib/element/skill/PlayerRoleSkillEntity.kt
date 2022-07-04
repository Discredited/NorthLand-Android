package com.nl.lib.element.skill

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 玩家角色技能
 *
 * 2022/6/10
 * @author June
 */
@Entity(tableName = "player_role_skills")
data class PlayerRoleSkillEntity(
    @PrimaryKey val id: String,
    val skillId: String,
    val playerRoleId: String,
    val level: Int,
    val triggerProbability: Double
)