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
    val part: Int,
    val quality: Int,
    val property: Int,
    val basicDesc: String,  // 基本说明
    val extraDesc: String,  // 额外说明
    val value: Int,  // 数值
    val valueGrowth: Int,  // 数值增长
    val strength: Int,  // 强化
    val strengthMax: Int,  // 强化最大值
    val strengthValue: Int  // 强化数值
)