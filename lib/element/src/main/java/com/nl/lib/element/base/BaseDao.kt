package com.nl.lib.element.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntity(vararg entity: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntities(entities: MutableList<T>)

    @Delete
    suspend fun deleteEntities(vararg entities: T)

    @Update
    suspend fun updateEntities(vararg entities: T)

    fun randomIdByDao(idExist: (randomId: String) -> Boolean): String {
        var uuid: String
        do {
            uuid = DatabaseUtils.randomId()
        } while (idExist(uuid))
        return uuid
    }
}