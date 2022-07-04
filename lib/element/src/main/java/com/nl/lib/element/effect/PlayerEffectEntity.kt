package com.nl.lib.element.effect

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 玩家技能、装备、道心等等效果
 *
 * 2022/6/10
 * @author June
 */
@Entity(tableName = "player_effects")
data class PlayerEffectEntity(
    @PrimaryKey val id: String,
    val effectId: String,
    val relationType: Int,
    val relationId: String,
    val relationName: String,
    val isActive: Boolean = false,
    val percentage: Double = 0.0,
    val value: Int = 0,
    val triggerProbability: Double = 1.0
)