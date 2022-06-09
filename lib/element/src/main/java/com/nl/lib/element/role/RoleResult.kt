package com.nl.lib.element.role

/**
 * 角色查询结果
 *
 * 2022/6/8
 * @author June
 */
data class RoleResult(
    val id: String,
    val name: String,              // 名称
    val avatar: String,            // 头像
    val image: String,             // 形象
    val desc: String,              // 描述
    val faction: Int,              // 阵营
    val race: Int,                 // 种族
    val quality: Int,              // 品质
    val realm: Int,                // 境界
    val power: Int,                // 妖力|法力
    val intellect: Int = 1,        // 智力
    val level: Int = 1,            // 等级
    val experience: Long = 0L,     // 经验
    val expNextLevel: Long = 20L,  // 下一级所需总经验
    val expFactor: Int = 20,       // 经验系数
    //  基础属性
    val attackInit: Int = 195,        // 初始攻击
    val defenseInit: Int = 120,       // 初始防御
    val healthInit: Int = 220,        // 初始生命
    val speedInit: Int = 90,          // 初始速度，只有初始速度，没有成长值
    val potential: Int = 0,           // 初始潜力
    //  基础成长属性
    val attackGrowth: Int = 30,       // 攻击成长
    val defenseGrowth: Int = 22,      // 防御成长
    val healthGrowth: Int = 95,       // 生命成长
    val potentialGrowth: Int = 40,    // 潜力成长
    //  额外属性
    val critInit: Int = 0,            // 初始暴击
    val resistInit: Int = 0,          // 初始抵抗
    val hitInit: Int = 0,             // 初始命中
    val dodgeInit: Int = 0,           // 初始闪避
    //  额外成长属性
    val critGrowth: Int = 0,          // 暴击成长
    val resistGrowth: Int = 0,        // 抵抗成长
    val hitGrowth: Int = 0,           // 命中成长
    val dodgeGrowth: Int = 0,          // 闪避成长
)