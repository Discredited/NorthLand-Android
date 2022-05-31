package com.nl.lib.element.player

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 玩家实体
 */
@Entity(tableName = "players")
data class PlayerEntity(
    @PrimaryKey val id: String,
    val playerId: String,
    val account: String,
    val password: String,
    val nickname: String,
    val gender: Int,
    // 玩家实名信息
    val realName: String?,
    val realID: String?,
    val token: String?
)