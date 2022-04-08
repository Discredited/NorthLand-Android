package com.nl.lib.element.effect

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 技能、装备、道具等等效果
 */
@Entity(tableName = "effects")
data class EffectEntity(
    @PrimaryKey val id: String,
    val relationType: Int,
    val relationId: String,
    val isActive:Boolean = false,  // 是否激活
)