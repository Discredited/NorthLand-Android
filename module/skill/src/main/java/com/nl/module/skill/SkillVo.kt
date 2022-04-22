package com.nl.module.skill

/**
 * 技能显示Vo
 *
 * 2022/4/23
 * @author June
 */
data class SkillVo(
    val id: String,
    val name: String,
    val desc: CharSequence,
    val icon: String
)