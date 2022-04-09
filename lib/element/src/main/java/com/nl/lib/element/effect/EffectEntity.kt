package com.nl.lib.element.effect

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nl.lib.element.enum.PropertyEnum

/**
 * 技能、装备、道具等等效果
 */
@Entity(tableName = "effects")
data class EffectEntity(
    @PrimaryKey val id: String,
    val relationType: Int,              // 关联类型：技能、装备、秘籍、道心
    val relationId: String,             // 关联id：技能ID  装备ID  秘籍ID  道心ID
    val relationName: String,           // 关联名称
    val desc: String,                   // 效果描述
    val activeLevel: Int = 0,           // 激活等级
    val isActive: Boolean = false,      // 是否激活
    val priority: Int = EffectEnum.EFFECT_PRIORITY_MIDDLE,      // 效果优先级：0-high,5-middle,10-low
    val effectFrom: Int = PropertyEnum.PRO_NULL,                // 效果来源：攻防血速爆抗命闪护盾
    val effectTarget: Int = PropertyEnum.PRO_NULL,              // 效果目标：攻防血速爆抗命闪护盾
    val effectMode: Int = EffectEnum.EFFECT_MODE_BUFF,          // 效果模式：0-buff,1-普通伤害,2-真实伤害
    val effectAction: Int = EffectEnum.EFFECT_ACTION_NULL,      // 效果作用：1-增益、-1-减益 0-无效
    val effectObject: Int = EffectEnum.EFFECT_OBJECT_OTHERS,    // 效果作用对象
    val effectScope: Int = EffectEnum.EFFECT_SCOPE_SINGLE,      // 效果作用范围
    val effectType: Int = EffectEnum.EFFECT_TYPE_PERCENTAGE,    // 效果类型：0-百分比 / 1-固定值
    val percentage: Float = 0F,                  // 百分比
    val percentageGrowth: Float = 0F,            // 百分比成长
    val value: Int = 0,                          // 固定值
    val valueGrowth: Int = 0,                    // 固定值成长
    val triggerProbability: Float = 1F,          // 效果触发概率
    val triggerProbabilityGrowth: Float = 0F     // 效果触发概率成长
)