package com.nl.lib.element.effect

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 技能、装备、道具等等效果
 */
@Entity(tableName = "effects")
data class EffectEntity(
    @PrimaryKey val id: String,
    val relationType: Int,          // 关联类型：技能、装备、秘籍、道心
    val relationId: String,         // 关联id：技能ID  装备ID  秘籍ID  道心ID
    val relationName: String,       // 关联名称
    val desc: String,               // 效果描述
    val activeLevel: Int = 0,       // 激活等级
    val isActive: Boolean = false,  // 是否激活
    val effectAction: Int = 0,      // 效果作用：0-buff,1-attack,2-真实伤害
    val priority: Int = 0,          // 效果优先级：0-high,5-middle,10-low
    val effectFrom: Int = 0,        // 效果来源：攻防血速爆抗命闪护盾
    val effectTarget: Int = 0,      // 效果目标：攻防血速爆抗命闪护盾
    val effect: Int = 0,            // 效果：1-增益、-1-减益 0-无效
    val effectObject: Int,          // 效果作用对象
    val effectScope: Int,           // 效果作用范围
    val effectType: Int,            // 效果类型：0-百分比 / 1-固定值
    val percentage: Float,          // 百分比
    val percentageGrowth: Float,    // 百分比成长
    val value: Int,                 // 固定值
    val valueGrowth: Int,           // 固定值成长
    val triggerProbability: Float = 1F,         // 效果触发概率
    val triggerProbabilityGrowth: Float = 0F    // 效果触发概率成长
)