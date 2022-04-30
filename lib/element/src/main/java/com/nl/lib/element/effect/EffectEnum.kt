package com.nl.lib.element.effect

/**
 * 效果枚举
 *
 * 2022年04月28日23:14:48
 *
 * @author:June
 */
object EffectEnum {

    /**
     * ## 效果模式
     * 属性效果：增加|减少属性，一般是以自身属性为基数提升多少百分比或者数值。如：增加自身20%攻击力、无视敌方30%防御力
     * 伤害效果：对敌方|自身造成伤害，一般是基于自身属性造成多少百分比伤害。如：造成自身攻击140%的伤害、造成自身防御70%的伤害
     * 真实伤害效果：对敌方|自身造成真实伤害，同上
     * 行动效果：增加自身行动|限制敌方行动
     * 复活效果：复活自身
     * 闪避效果：闪避敌方攻击
     */
    const val EFFECT_MODE_PROPERTY = 0          // 属性效果
    const val EFFECT_MODE_DAMAGE = 1            // 伤害效果
    const val EFFECT_MODE_DAMAGE_TRUE = 2       // 真实伤害效果
    const val EFFECT_MODE_ACTION = 3            // 行动效果
    const val EFFECT_MODE_REVIVE = 4            // 复活效果
    const val EFFECT_MODE_DODGE = 5             // 闪避效果

    /**
     * ## 效果触发时机
     */
    const val EFFECT_TIMING_IMMEDIATE = 0       // 立即触发
    const val EFFECT_TIMING_ATTACK = 1          // 进攻时触发
    const val EFFECT_TIMING_DEFEND = 1          // 防守时触发
    const val EFFECT_TIMING_INJURED = 1         // 受到伤害时触发
    const val EFFECT_TIMING_ROUND_START = 1     // 回合开始时触发
    const val EFFECT_TIMING_ROUND_END = 1       // 回合结束时触发
    const val EFFECT_TIMING_KILL = 1            // 击杀时触发
    const val EFFECT_TIMING_DEATH = 1           // 死亡时触发
    const val EFFECT_TIMING_CRITICAL = 1        // 暴击时触发
    const val EFFECT_TIMING_DODGE = 1           // 闪避时触发

    /**
     * ## 效果作用
     * 增益
     * 减益
     * 无效
     */
    const val EFFECT_ACTION_BUFF = 1            // 增益
    const val EFFECT_ACTION_NULL = 0            // 无效
    const val EFFECT_ACTION_DEBUFF = -1         // 减益


    /**
     * ## 作用对象
     * 己方
     * 敌方
     */
    const val EFFECT_OBJECT_SELF = 1            // 己方
    const val EFFECT_OBJECT_OTHERS = 2          // 敌方

    ////////// 作用范围
    const val EFFECT_SCOPE_SINGLE = 1           // 单体
    const val EFFECT_SCOPE_ALL = 2              // 全体
    const val EFFECT_SCOPE_ROW = 3              // 行
    const val EFFECT_SCOPE_COLUMN = 4           // 列
    const val EFFECT_SCOPE_AROUND = 5           // 周围（十字范围）
    const val EFFECT_SCOPE_ATTACK_HIGH = 6      // 攻击最高
    const val EFFECT_SCOPE_HEALTH_LOW = 7       // 生命最低
    const val EFFECT_SCOPE_DODGE = 8            // 闪避值

    ////////// 效果优先级
    const val EFFECT_PRIORITY_LOW = 1           // 优先级低
    const val EFFECT_PRIORITY_NORMAL = 3        // 优先级一般
    const val EFFECT_PRIORITY_MIDDLE = 5        // 优先级中等
    const val EFFECT_PRIORITY_HIGH = 10         // 优先级高

    ////////// 效果类型
    const val EFFECT_TYPE_PERCENTAGE = 0        // 百分比类型
    const val EFFECT_TYPE_VALUE = 1             // 固定值类型
}