package com.nl.module.soul

data class SoulVo(
    val name: String,
    val desc: String,
    val level: Int,
    val icon: Int,
    val attribute: Int = 0
)