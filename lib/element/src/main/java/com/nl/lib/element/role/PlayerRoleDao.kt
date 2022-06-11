package com.nl.lib.element.role

import androidx.room.Dao
import androidx.room.Query
import com.nl.lib.element.base.BaseDao

@Dao
interface PlayerRoleDao : BaseDao<PlayerRoleEntity> {

    @Query("SELECT * FROM player_roles WHERE id = :id")
    fun findPlayerRoleById(id: String): PlayerRoleEntity?

    @Query("SELECT * FROM player_roles")
    suspend fun loadPlayerRoles(): List<PlayerRoleEntity>

    @Query("SELECT * FROM player_roles WHERE id = :playerId")
    suspend fun findPlayerRoleByPlayerId(playerId: String): List<PlayerRoleEntity>?
}