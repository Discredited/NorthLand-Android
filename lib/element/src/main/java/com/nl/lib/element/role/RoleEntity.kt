package com.nl.lib.element.role

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * POJO  简单的Java对象，其中有一些属性及其getter、setter方法的类，没有业务逻辑，不允许有业务方法
 * Bean  是一种JAVA语言写成的可重用组件，所有属性为private，提供无参数的构造器，属性使用getter和setter来访问，可序列化，可以封装一些简单逻辑
 * Entity  就是属性类，通常定义在model层里面，一般的实体类对应一个数据表，其中的属性对应数据表中的字段
 * 三者的区别
 *
 * 角色实体
 */
@Entity(tableName = "roles")
data class RoleEntity(
    @PrimaryKey val id: String,
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
    val experience: Int = 0,       // 经验
    val expNextLevel: Long = 20,   // 下一级所需总经验
    val expFactor: Int = 20,       // 经验系数
    //  基础属性
    val attackInit: Int = 195,         // 初始攻击
    val defenseInit: Int = 120,        // 初始防御
    val healthInit: Int = 220,         // 初始生命
    val speedInit: Int = 90,           // 初始速度，只有初始速度，没有成长值
    val potential: Int = 0,            // 初始潜力
    val attackUpgrade: Int = 30,       // 攻击成长
    val defenseUpgrade: Int = 22,      // 防御成长
    val healthUpgrade: Int = 95,       // 生命成长
    val potentialUpgrade: Int = 40,    // 潜力成长
    //  额外属性
    val critInit: Int = 0,             // 初始暴击
    val resistInit: Int = 0,           // 初始抵抗
    val hitInit: Int = 0,               // 初始命中
    val dodgeInit: Int = 0,            // 初始闪避
    val critUpgrade: Int = 0,          // 暴击成长
    val resistUpgrade: Int = 0,        // 抵抗成长
    val hitUpgrade: Int = 0,            // 命中成长
    val dodgeUpgrade: Int = 0          // 闪避成长
)