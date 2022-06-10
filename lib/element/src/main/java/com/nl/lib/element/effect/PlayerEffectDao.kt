package com.nl.lib.element.effect

import androidx.room.*

/**
 *
 *
 * 2022/6/10
 * @author June
 */
@Dao
interface PlayerEffectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEffect(vararg effectEntities: PlayerEffectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEffects(effects: MutableList<PlayerEffectEntity>)

    @Delete
    suspend fun deleteEffects(vararg effects: PlayerEffectEntity)

    @Update
    suspend fun updateEffects(vararg effects: PlayerEffectEntity)

    @Query("SELECT * FROM player_effects")
    suspend fun loadEffects(): List<PlayerEffectEntity>
}