package com.nl.lib.element.skill

import androidx.room.Dao
import androidx.room.Query
import com.nl.lib.element.base.BaseDao

/**
 * 玩家角色技能增删查改
 *
 * 2022/4/5
 * @author June
 */
@Dao
interface PlayerRoleSkillDao : BaseDao<PlayerRoleSkillEntity> {

    @Query("SELECT * FROM player_role_skills WHERE id = :id")
    fun findPlayerRoleSkillById(id: String): PlayerRoleSkillEntity?

    @Query("SELECT * FROM player_role_skills")
    suspend fun loadPlayerRoleSkills(): List<PlayerRoleSkillEntity>

    @Query("SELECT * FROM player_role_skills WHERE playerRoleId = :roleId")
    suspend fun findPlayerRoleSkillByRoleId(roleId: String): MutableList<PlayerRoleSkillEntity>?

//    @Query("SELECT skills.id,skills.name FROM skills,effects WHERE id = :id AND effects.relationId = :id")
//    suspend fun findSkill(id: String): MutableList<Any>?
}