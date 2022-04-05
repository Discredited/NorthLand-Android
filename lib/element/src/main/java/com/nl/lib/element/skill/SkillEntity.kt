package com.nl.lib.element.skill

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 技能
 *
 * 2022/4/5
 * @author June
 */
@Entity(tableName = "skills")
data class SkillEntity(
    @PrimaryKey val id: String,
    val roleId: String,
    val type: Int,
    val name: String,
    val icon: String,
    val desc: String,
    val level: Int = 1
)