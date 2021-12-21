package com.nl.lib.element.role

import androidx.room.*

@Dao
interface RoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRole(vararg role: RoleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoles(roles: MutableList<RoleEntity>)

    @Delete
    suspend fun deleteRoles(vararg roles: RoleEntity)

    @Update
    suspend fun updateRoles(vararg roles: RoleEntity)

    @Query("SELECT * FROM roles")
    suspend fun loadRoles(): List<RoleEntity>
}