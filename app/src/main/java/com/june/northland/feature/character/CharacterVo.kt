package com.june.northland.feature.character

import com.june.northland.R

class CharacterVo(
    val name: String = "甘柠真",
    val avatar: String = "",
    val avatarIcon: Int = R.drawable.ic_avatar_gan_ning_zhen,
    val quality: Int = 3,  //品质
    val realm: Int = 0,  //境界
    var level: Int = 0,
    var experience: Long = 0,  //总经验
    var expLevel: Long = 20,  //单级经验
    var expNextLevel: Long = 20, //下一级所需总经验
    val expFactor: Int = 20,  //经验系数
    var attack: Int = 195,
    var defense: Int = 120,
    var health: Int = 220,
    var potential: Int = 0,
    val attackUpgrade: Int = 30,
    val defenseUpgrade: Int = 22,
    val healthUpgrade: Int = 95,
    val potentialUpgrade: Int = 40
) {

    //lv 提升的等级
    fun levelUp(lv: Int) {
        level += lv
        //属性提升
        attack += lv * attackUpgrade
        defense += lv * defenseUpgrade
        health += lv * healthUpgrade
        potential += lv * potentialUpgrade
        //经验相关修改
        expLevel = (level * expFactor).toLong()
        expNextLevel = expSum(level).toLong()
    }

    private fun expSum(lv: Int): Int {
        var sum = 0
        for (index in 0..lv) {
            sum += expFactor * index
        }
        return sum
    }
}