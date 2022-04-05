package com.nl.module.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nl.lib.element.role.RoleEntity
import com.nl.module.role.detail.RoleAttrVo
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

    /**
     * 加载角色列表
     */
    fun loadRoleList() {
        viewModelScope.launch {
            val roleList = withContext(Dispatchers.IO) {
                roleDao.loadRoles()
            }
            roleListFlow.emit(roleList.toMutableList())
        }
    }

    /**
     * 通过roleId查找角色
     */
    fun findRoleById(id: String, response: (role: RoleEntity?) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            val role = withContext(Dispatchers.IO) {
                roleDao.findRoleById(id)
            }
            response(role)
        }
    }

    fun loadRoleDetail(role: RoleEntity?): MutableList<RoleAttrVo> {
        role ?: return mutableListOf()
        return mutableListOf(
            RoleAttrVo(name = "初始攻击:", role.attackInit.toString()),
            RoleAttrVo(name = "初始防御:", role.defenseInit.toString()),
            RoleAttrVo(name = "初始生命:", role.healthInit.toString()),
            RoleAttrVo(name = "初始速度:", role.speedInit.toString()),

            RoleAttrVo(name = "初始暴击:", role.critInit.toString()),
            RoleAttrVo(name = "初始抵抗:", role.resistInit.toString()),
            RoleAttrVo(name = "初始命中:", role.hitInit.toString()),
            RoleAttrVo(name = "初始闪避:", role.dodgeInit.toString()),

            RoleAttrVo(name = "生命成长:", role.attackUpgrade.toString()),
            RoleAttrVo(name = "防御成长:", role.defenseUpgrade.toString()),
            RoleAttrVo(name = "生命成长:", role.healthUpgrade.toString()),
            RoleAttrVo(name = "速度成长:", "0"),

            RoleAttrVo(name = "暴击成长:", role.critUpgrade.toString()),
            RoleAttrVo(name = "抵抗成长:", role.resistUpgrade.toString()),
            RoleAttrVo(name = "命中成长:", role.hitUpgrade.toString()),
            RoleAttrVo(name = "闪避成长:", role.dodgeUpgrade.toString())
        )
    }
}