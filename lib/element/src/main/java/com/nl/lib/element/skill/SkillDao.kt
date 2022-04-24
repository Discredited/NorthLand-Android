package com.nl.lib.element.skill

import androidx.room.*

/**
 * 技能增删查改
 *
 * 2022/4/5
 * @author June
 */
@Dao
interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkill(vararg skill: SkillEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkills(skills: MutableList<SkillEntity>)

    @Delete
    suspend fun deleteSkills(vararg skills: SkillEntity)

    @Update
    suspend fun updateSkills(vararg skills: SkillEntity)

    @Query("SELECT * FROM skills")
    suspend fun loadSkills(): List<SkillEntity>

    @Query("SELECT * FROM skills WHERE id = :id")
    suspend fun findSkillById(id: String): SkillEntity?

    @Query("SELECT * FROM skills WHERE id = :roleId")
    suspend fun findSkillByRoleId(roleId: String): MutableList<SkillEntity>?

//    @Query("SELECT skills.id,skills.name FROM skills,effects WHERE id = :id AND effects.relationId = :id")
//    suspend fun findSkill(id: String): MutableList<Any>?
}