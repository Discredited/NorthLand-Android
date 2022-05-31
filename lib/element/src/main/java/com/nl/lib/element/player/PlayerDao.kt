package com.nl.lib.element.player

import androidx.room.*

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(vararg players: PlayerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: MutableList<PlayerEntity>)

    @Delete
    suspend fun deletePlayers(vararg players: PlayerEntity)

    @Update
    suspend fun updatePlayers(vararg players: PlayerEntity)

    @Query("SELECT * FROM players")
    suspend fun loadPlayers(): MutableList<PlayerEntity>

    @Query("SELECT * FROM players WHERE account=:account")
    suspend fun findPlayersByAccount(account: String): PlayerEntity?
}