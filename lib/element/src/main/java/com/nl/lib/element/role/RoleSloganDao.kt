package com.nl.lib.element.role

import androidx.room.Dao
import androidx.room.Query
import com.nl.lib.element.base.BaseDao

@Dao
interface RoleSloganDao : BaseDao<RoleSloganEntity> {

    @Query("SELECT * FROM role_slogans WHERE id = :id")
    fun findRoleSloganById(id: String): RoleSloganEntity?

    @Query("SELECT * FROM role_slogans")
    suspend fun loadRoleSlogans(): List<RoleSloganEntity>

    @Query("SELECT * FROM role_slogans WHERE roleId = :roleId")
    suspend fun findRoleSloganByRoleId(roleId: String): RoleSloganEntity?
}