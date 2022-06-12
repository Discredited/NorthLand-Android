package com.nl.module.store.recruit

import com.nl.lib.element.role.RoleSloganEntity

/**
 * 招募角色
 *
 * 2022/5/5
 * @author June
 */
data class RecruitRoleVo(
    val roleId: String,
    val name: String,
    val avatar: String,
    val image: String,
    val quality: Int,
    val power: Int,
    val realm: Int,
    val slogans: List<RoleSloganEntity>
) {
    fun getSlogan(): String {
        if (slogans.isEmpty()) return "??????????"
        val random = ((slogans.size - 1) * Math.random()).toInt()
        return slogans[random].slogan
    }
}