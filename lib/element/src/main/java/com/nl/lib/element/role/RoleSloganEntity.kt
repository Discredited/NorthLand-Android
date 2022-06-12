package com.nl.lib.element.role

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 角色Slogan
 *
 * 2022/6/12
 * @author June
 */
@Entity(tableName = "role_slogans")
data class RoleSloganEntity(
    @PrimaryKey val id: String,
    val roleId: String,
    val slogan: String,
)