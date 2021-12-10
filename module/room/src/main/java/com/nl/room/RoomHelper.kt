package com.nl.room

import android.content.Context
import androidx.room.Room
import com.nl.room.source.TestDataSource
import timber.log.Timber

class RoomHelper {

    private lateinit var mDatabase: NorthLandDatabase

    fun initialize(context: Context, databaseName: String) {
        mDatabase = Room.databaseBuilder(
            context,
            NorthLandDatabase::class.java,
            databaseName
        ).allowMainThreadQueries().build()
    }

    suspend fun checkDataBase(): Boolean {
        // 检查角色数据
        val roles = mDatabase.roleDao().loadRoles()
        Timber.e("角色数据:${roles.size}")
        return roles.isNotEmpty()
    }

    suspend fun mockDataBase() {
        mDatabase.roleDao().insertRoles(TestDataSource.mockRoles())
    }

    companion object {
        private val mInstance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { RoomHelper() }

        fun getInstance() = mInstance
    }
}