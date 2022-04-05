package com.nl.module.role.detail

data class RoleAttrVo(
    val name: String,
    val value: String
) {
    fun getNameColon(): String {
        return "${name}:"
    }
}
