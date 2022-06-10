package com.nl.lib.element.effect

import androidx.room.*

/**
 * 效果增删查改
 *
 * 2022/4/5
 * @author June
 */
@Dao
interface EffectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEffect(vararg effects: EffectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEffects(effects: MutableList<EffectEntity>)

    @Delete
    suspend fun deleteEffects(vararg effects: EffectEntity)

    @Update
    suspend fun updateEffects(vararg effects: EffectEntity)

    @Query("SELECT * FROM effects")
    suspend fun loadEffects(): List<EffectEntity>

    @Query("SELECT * FROM effects WHERE id = :id")
    suspend fun findEffectById(id: String): EffectEntity?

    @Query("SELECT * FROM effects WHERE relationId = :relationId and relationType = :relationType")
    suspend fun findEffectByRelation(relationId: String, relationType: Int): MutableList<EffectEntity>?
}