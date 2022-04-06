package com.nl.room

import android.content.Context
import androidx.room.Room
import com.nl.room.source.EquipmentDataSource
import com.nl.room.source.RoleDataSource
import com.nl.room.source.SkillDataSource
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

    fun database() = mDatabase

    suspend fun checkDataBase(): Boolean {
        // 检查角色数据
        val roles = mDatabase.roleDao().loadRoles()
        val equipments = mDatabase.equipmentDao().loadEquipments()
        Timber.e("角色数据:${roles.size}")
        Timber.e("装备数据:${equipments.size}")
        return roles.isNotEmpty() && equipments.isNotEmpty()
    }

    suspend fun mockDataBase() {
        // 角色数据mock
        if (mDatabase.roleDao().loadRoles().isEmpty()) {
            mDatabase.roleDao().insertRoles(RoleDataSource.mockRoles())
        }
        // 装备数据mock
        if (mDatabase.equipmentDao().loadEquipments().isEmpty()) {
            mDatabase.equipmentDao().insertEquipments(EquipmentDataSource.mockEquipments())
        }
        // 技能数据mock
        if (mDatabase.skillDao().loadSkills().isEmpty()) {
            mDatabase.skillDao().insertSkills(SkillDataSource.mockSkills())
        }
    }

    companion object {
        private val mInstance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { RoomHelper() }

        fun getInstance() = mInstance
    }
}