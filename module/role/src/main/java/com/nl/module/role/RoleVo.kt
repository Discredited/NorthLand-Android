package com.nl.module.role

import com.nl.lib.element.role.RoleEntity
import com.nl.lib.element.skill.SkillEntity

data class RoleVo(
    val role: RoleEntity,
    val skills: MutableList<SkillEntity>
)