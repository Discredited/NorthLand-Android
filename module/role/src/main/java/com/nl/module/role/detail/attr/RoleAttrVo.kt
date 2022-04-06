package com.nl.module.role.detail.attr

data class RoleAttrVo(
    val name: String,
    val value: String
) {
    fun getNameColon(): String {
        return "${name}:"
    }
}
