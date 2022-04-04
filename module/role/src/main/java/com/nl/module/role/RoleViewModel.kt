package com.nl.module.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nl.lib.element.role.RoleEntity
import com.nl.room.RoomHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 角色VIewModel
 *
 * 2022/4/4
 * @author June
 */
class RoleViewModel : ViewModel() {

    private val roleDao by lazy { RoomHelper.getInstance().database().roleDao() }

    val roleListFlow: MutableStateFlow<MutableList<RoleEntity>> = MutableStateFlow(mutableListOf())

    fun loadRoleList() {
        viewModelScope.launch {
            val roleList = withContext(Dispatchers.IO) {
                roleDao.loadRoles()
            }
            roleListFlow.emit(roleList.toMutableList())
        }
    }

    fun findRoleById(id: String, response: (role: RoleEntity?) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            val role = withContext(Dispatchers.IO) {
                roleDao.findRoleById(id)
            }
            response(role)
        }
    }
}