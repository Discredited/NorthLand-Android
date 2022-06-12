package com.nl.room.source

import com.nl.lib.element.base.DatabaseUtils
import com.nl.lib.element.role.RoleSloganEntity

/**
 * 角色Slogan
 *
 * 2022/6/12
 * @author June
 */
object RoleSloganDataSource {

    fun mockRoleSlogans(): MutableList<RoleSloganEntity> {
        return mutableListOf(
            RoleSloganEntity(
                id = DatabaseUtils.randomId(),
                roleId = "30001",
                slogan = "这一生，我从不等别人来将我唤醒！"
            ),
            RoleSloganEntity(
                id = DatabaseUtils.randomId(),
                roleId = "30001",
                slogan = "站的最高处的石头，就是星辰"
            ),
            RoleSloganEntity(
                id = DatabaseUtils.randomId(),
                roleId = "30001",
                slogan = "一滩烂泥，也可以面对浩瀚的天空"
            ),
        )
    }
}