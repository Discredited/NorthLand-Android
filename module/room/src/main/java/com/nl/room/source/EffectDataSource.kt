package com.nl.room.source

import com.nl.lib.element.effect.EffectEntity
import com.nl.lib.element.effect.EffectEnum
import com.nl.lib.element.enum.CommonEnum
import com.nl.lib.element.enum.PropertyEnum

object EffectDataSource {

    fun mockEffects(): MutableList<EffectEntity> {
        return mutableListOf(
            // 术法无双
            EffectEntity(
                id = "1000111",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100011",
                relationName = "术法无双I",
                desc = "技能伤害提升15%",
                activeLevel = 3,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_HIGH,
                effectFrom = PropertyEnum.PRO_DAMAGE,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_PROPERTY,
                effectAction = EffectEnum.EFFECT_ACTION_BUFF,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_ALL,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.15F,
                percentageGrowth = 0.05F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),
            EffectEntity(
                id = "1000112",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100011",
                relationName = "术法无双II",
                desc = "受到的技能伤害减少15%",
                activeLevel = 5,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_HIGH,
                effectFrom = PropertyEnum.PRO_DAMAGE,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_PROPERTY,
                effectAction = EffectEnum.EFFECT_ACTION_BUFF,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.15F,
                percentageGrowth = 0.05F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),

            // 镜花水月
            EffectEntity(
                id = "1000121",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100012",
                relationName = "镜花水月",
                desc = "对全体敌人造成4段伤害，每段伤害为攻击力30%-60%",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE,
                effectAction = EffectEnum.EFFECT_ACTION_BUFF,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_ALL,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.45F,
                percentageGrowth = 0.03F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),

            // 共时交点
            EffectEntity(
                id = "1000211",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100021",
                relationName = "共时交点I",
                desc = "受到攻击时，有30%概率免疫本次伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_HIGH,
                effectFrom = PropertyEnum.PRO_NULL,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.02F
            ),
            EffectEntity(
                id = "1000212",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100021",
                relationName = "共时交点II",
                desc = "伤害免疫成功对方全体造成自身防御20%的真实伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_HIGH,
                effectFrom = PropertyEnum.PRO_DEFENSE,
                effectTarget = PropertyEnum.PRO_DAMAGE_TRUE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE_TRUE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.2F,
                triggerProbabilityGrowth = 0.02F
            ),

            // 超脱物外
            EffectEntity(
                id = "1000221",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100022",
                relationName = "超脱物外I",
                desc = "对敌方单体造成自身防御70%的伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_DEFENSE,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.03F
            ),
            EffectEntity(
                id = "1000222",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100022",
                relationName = "超脱物外II",
                desc = "并给自身制造一个自身生命值20%的护盾",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_HEALTH,
                effectTarget = PropertyEnum.PRO_SHIELD,
                effectMode = EffectEnum.EFFECT_MODE_PROPERTY,
                effectAction = EffectEnum.EFFECT_ACTION_BUFF,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.2F,
                percentageGrowth = 0.02F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),

            // 天地意志
            EffectEntity(
                id = "1000311",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100031",
                relationName = "天地意志",
                desc = "被攻击的目标有20%的概率禁止行动一回合",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_NULL,
                effectTarget = PropertyEnum.PRO_NULL,
                effectMode = EffectEnum.EFFECT_MODE_ACTION,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.2F,
                triggerProbabilityGrowth = 0.02F
            ),

            // 寂灭剑雨
            EffectEntity(
                id = "1000321",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "100032",
                relationName = "寂灭剑雨",
                desc = "对敌方全体造成自身攻击力160%的伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_ACTION,
                effectAction = EffectEnum.EFFECT_MODE_DAMAGE,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_ALL,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.4F,
                triggerProbabilityGrowth = 0.02F
            ),

            // 绕
            EffectEntity(
                id = "2000111",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200011",
                relationName = "绕I",
                desc = "敌方行动后，30%概率追加一次攻击",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_NULL,
                effectTarget = PropertyEnum.PRO_NULL,
                effectMode = EffectEnum.EFFECT_MODE_ACTION,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.03F
            ),
            EffectEntity(
                id = "2000112",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200011",
                relationName = "绕II",
                desc = "对敌方造成自身攻击110%的伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1.1F,
                percentageGrowth = 0.05F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),

            // 刀光
            EffectEntity(
                id = "2000121",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200012",
                relationName = "刀光",
                desc = "对敌方全体造自身攻击95%的伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_ALL,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.95F,
                percentageGrowth = 0.05F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.02F
            ),

            // 豪放不羁
            EffectEntity(
                id = "2000211",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200021",
                relationName = "豪放不羁",
                desc = "每回合增加自身2%攻击力",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_ATTACK,
                effectMode = EffectEnum.EFFECT_MODE_PROPERTY,
                effectAction = EffectEnum.EFFECT_ACTION_BUFF,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.02F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),

            // 破坏真诀
            EffectEntity(
                id = "2000221",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200022",
                relationName = "破坏真诀",
                desc = "对敌方单体造成自身攻击力50%的真实伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_ATTACK,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE_TRUE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.5F,
                percentageGrowth = 0.02F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.2F
            ),

            // 星卜
            EffectEntity(
                id = "2000311",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200031",
                relationName = "星卜I",
                desc = "首次被击败后利用星辰之力复活",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_HIGH,
                effectFrom = PropertyEnum.PRO_NULL,
                effectTarget = PropertyEnum.PRO_NULL,
                effectMode = EffectEnum.EFFECT_MODE_REVIVE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.2F
            ),
            EffectEntity(
                id = "2000312",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200031",
                relationName = "星卜II",
                desc = "恢复自身40%生命",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_HIGH,
                effectFrom = PropertyEnum.PRO_HEALTH,
                effectTarget = PropertyEnum.PRO_HEALTH,
                effectMode = EffectEnum.EFFECT_MODE_PROPERTY,
                effectAction = EffectEnum.EFFECT_ACTION_BUFF,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 0.4F,
                percentageGrowth = 0.2F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 1F,
                triggerProbabilityGrowth = 0F
            ),

            // 星罗棋布
            EffectEntity(
                id = "2000321",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200032",
                relationName = "星罗棋布",
                desc = "对敌方前排造成自身攻击160%的伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_NORMAL,
                effectFrom = PropertyEnum.PRO_ATTACK,
                effectTarget = PropertyEnum.PRO_DAMAGE,
                effectMode = EffectEnum.EFFECT_MODE_DAMAGE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_OTHERS,
                effectScope = EffectEnum.EFFECT_SCOPE_ROW,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1.6F,
                percentageGrowth = 0.02F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.2F
            ),

            // 宿命
            EffectEntity(
                id = "2000411",
                relationType = CommonEnum.OBJECT_SKILL,
                relationId = "200041",
                relationName = "宿命",
                desc = "命运之力缠绕使阿萝有30%几率闪避敌人的伤害",
                activeLevel = 1,
                isActive = false,
                priority = EffectEnum.EFFECT_PRIORITY_MIDDLE,
                effectFrom = PropertyEnum.PRO_NULL,
                effectTarget = PropertyEnum.PRO_NULL,
                effectMode = EffectEnum.EFFECT_MODE_REVIVE,
                effectAction = EffectEnum.EFFECT_ACTION_NULL,
                effectObject = EffectEnum.EFFECT_OBJECT_SELF,
                effectScope = EffectEnum.EFFECT_SCOPE_SINGLE,
                effectType = EffectEnum.EFFECT_TYPE_PERCENTAGE,
                percentage = 1F,
                percentageGrowth = 0F,
                value = 0,
                valueGrowth = 0,
                triggerProbability = 0.3F,
                triggerProbabilityGrowth = 0.2F
            ),

            // 会心一击

            // 元力

            // 孤注一掷

            // 孤傲龙王

            // 刀气

            // 浮光掠影

            // 璀璨光华

            // 沙脉

            // 沙咒

            // 脉经

            // 海上明月

            // 易形残玄

            // 龙象般若

            // 时光之咒

            // 天道刑法

            // 执念

            // 弦线

            // 莲心眼

            // 弱水出鞘

            // 流光金甲

            // 脉经盾

            // 天命蝎尾

            // 丹蝎九尾

            // 天生沙脉

            // 时光之沙

            // 诡诈

            // 垂死坚持
        )
    }
}