package com.nl.lib.element.role

import androidx.room.*

@Dao
interface PlayerRoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerRoles(vararg playerRoles: PlayerRoleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerRoles(playerRoles: MutableList<PlayerRoleEntity>)

    @Delete
    suspend fun deletePlayerRoles(vararg playerRoles: PlayerRoleEntity)

    @Update
    suspend fun updatePlayerRole(vararg playerRoles: PlayerRoleEntity)

    @Query("SELECT * FROM player_roles")
    suspend fun loadPlayerRoles(): List<PlayerRoleEntity>

    @Query("SELECT * FROM player_roles WHERE id = :playerId")
    suspend fun findPlayerRoleByPlayerId(playerId: String): List<PlayerRoleEntity>?
}