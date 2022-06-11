package com.nl.lib.element.effect

import androidx.room.Dao
import androidx.room.Query
import com.nl.lib.element.base.BaseDao

/**
 *
 *
 * 2022/6/10
 * @author June
 */
@Dao
interface PlayerEffectDao : BaseDao<PlayerEffectEntity> {

    @Query("SELECT * FROM player_effects WHERE id=:id")
    fun findPlayerEffectById(id: String): PlayerEffectEntity?

    @Query("SELECT * FROM player_effects")
    suspend fun loadPlayerEffects(): List<PlayerEffectEntity>
}