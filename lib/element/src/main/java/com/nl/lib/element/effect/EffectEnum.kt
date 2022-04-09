package com.nl.lib.element.effect

object EffectEnum {

    const val EFFECT_MODE_BUFF = 0              // BUFF效果
    const val EFFECT_MODE_DAMAGE = 0            // BUFF效果
    const val EFFECT_MODE_DAMAGE_TRUE = 0       // BUFF效果

    ////////// 效果作用
    const val EFFECT_ACTION_BUFF = 1            // 增益
    const val EFFECT_ACTION_NULL = 0            // 无效
    const val EFFECT_ACTION_DEBUFF = -1         // 减益


    ////////// 作用对象
    const val EFFECT_OBJECT_SELF = 1            // 增益
    const val EFFECT_OBJECT_OTHERS = 2          // 无效

    ////////// 作用范围
    const val EFFECT_SCOPE_SINGLE = 1           // 单体
    const val EFFECT_SCOPE_ALL = 2              // 全体
    const val EFFECT_SCOPE_ROW = 3              // 行
    const val EFFECT_SCOPE_COLUMN = 4           // 列
    const val EFFECT_SCOPE_AROUND = 5           // 周围（十字范围）
    const val EFFECT_SCOPE_ATTACK_HIGH = 6      // 攻击最高
    const val EFFECT_SCOPE_HEALTH_LOW = 7       // 生命最低

    ////////// 效果优先级
    const val EFFECT_PRIORITY_LOW = 1           // 优先级低
    const val EFFECT_PRIORITY_MIDDLE = 5        // 优先级中等
    const val EFFECT_PRIORITY_HIGH = 10         // 优先级高

    ////////// 效果类型
    const val EFFECT_TYPE_PERCENTAGE = 0        // 百分比类型
    const val EFFECT_TYPE_VALUE = 1             // 固定值类型
}