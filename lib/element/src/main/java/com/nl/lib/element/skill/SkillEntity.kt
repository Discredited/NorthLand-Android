package com.nl.lib.element.skill

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 技能
 *
 * 2022/4/5
 * @author June
 */
@Entity(tableName = "skills")
data class SkillEntity(
    @PrimaryKey val id: String,                   // 主键id
    val roleId: String,                           // 关联角色id
    val type: Int,                                // 技能类型
    val name: String,                             // 技能名称
    val icon: String,                             // 技能图标
    val desc: String,                             // 技能描述
    val level: Int = 1,                           // 技能等级
    val maxLevel: Int = 10,                       // 技能最大等级
    val triggerProbability: Float = 0F,           // 技能触发概率
    val triggerProbabilityGrowth: Float = 0.3F,   // 技能触发概率成长值
)