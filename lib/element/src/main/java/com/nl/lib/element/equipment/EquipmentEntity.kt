package com.nl.lib.element.equipment

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 装备实体
 */
@Entity(tableName = "equipments")
data class EquipmentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val icon: String,
    val basicDesc: String,  // 基本说明
    val extraDesc: String,  // 额外说明
    val part: Int,              // 部位
    val quality: Int,           // 品质
    val property: Int,          // 属性
    val value: Int,             // 数值
    val valueGrowth: Int = 0,       // 数值增长
    val strength: Int = 0,          // 强化
    val strengthGrowth: Int = 0,     // 强化成长
    val forging: Int = 0,           // 锻造
    val forgingGrowth: Double = 0.0,   // 锻造成长
)