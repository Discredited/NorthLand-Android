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
    val name: String,  // 名称
    val avatar: String,  // 头像
    val image: String,  // 形象
    val desc: String,  // 描述
    val faction: Int,  // 阵营
    val race: Int,  // 种族
    val quality: Int,
    val realm: Int,
    val power: Int,
    val intellect: Int,
    val level: Int,
    val experience: Int,
    val expNextLevel: Long = 20, //下一级所需总经验
    val expFactor: Int = 20,  //经验系数
    val attack: Int = 195,
    val defense: Int = 120,
    val health: Int = 220,
    val potential: Int = 0,
    val attackUpgrade: Int = 30,
    val defenseUpgrade: Int = 22,
    val healthUpgrade: Int = 95,
    val potentialUpgrade: Int = 40
)