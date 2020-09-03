package com.june.northland.feature.battle

import android.app.Application
import com.june.northland.base.component.AppViewModel
import com.june.northland.common.ConstantUtils
import com.june.northland.feature.battle.vo.BattleDataVo
import com.june.northland.feature.battle.vo.BattleResultVo
import com.june.northland.feature.battle.vo.BattleVo
import com.june.northland.feature.battle.vo.RoundVo
import timber.log.Timber

class BattleViewModel(application: Application) : AppViewModel(application) {

    fun battleResult(): BattleResultVo {
        val battleList = mutableListOf<Int>()
        //随机生成敌方
        val opponentSize = (Math.random() * 7).toInt() + 1
        val opponentList = mutableListOf<BattleVo>()
        for (index in 0 until opponentSize) {
            opponentList.add(ConstantUtils.randomBattleVo(index))
            battleList.add(index)
        }

        //随机生成己方
        val ownSize = (Math.random() * 7).toInt() + 1
        val ownList = mutableListOf<BattleVo>()
        for (index in 0 until ownSize) {
            ownList.add(ConstantUtils.randomBattleVo(index))
            battleList.add(opponentSize + index)
        }

        battleList.shuffle()

        //val roundSize = (Math.random() * 9).toInt() + 1
        val roundSize = 1 //生个1个回合的战斗
        val roundList = mutableListOf<RoundVo>()
        for (round in 0 until roundSize) {
            //每一个回合
            for (position in 0 until battleList.size) {
                //回合中的每次行动
                val attackerPosition = battleList[position]
                val random = Math.random()
                val attackType = if (random >= 0.5) 1 else 0
                val damageType = when {
                    random >= 0.75 -> 2
                    random >= 0.45 -> 1
                    else -> 0
                }

                val defenderPositionStart = if (attackerPosition < opponentSize) {
                    //敌方进攻  己方防守
                    opponentSize
                } else {
                    //己方进攻  敌方防守
                    0
                }
                val defenderSize = if (attackerPosition < opponentSize) {
                    ownSize
                } else {
                    opponentSize
                }
                //随机生成攻击位置
                val defenderPosition = if (attackType == 1) {
                    if (random > 0.7) {
                        if (random > 0.9 && defenderSize > 2) {
                            intArrayOf(defenderPositionStart, defenderPositionStart + 1, defenderPositionStart + 2)
                        } else if (random > 0.8 && defenderSize > 1) {
                            intArrayOf(defenderPositionStart, defenderPositionStart + 1)
                        } else {
                            intArrayOf(defenderPositionStart)
                        }
                    } else {
                        intArrayOf(defenderPositionStart)
                    }
                } else {
                    intArrayOf(defenderPositionStart)
                }

                val builder = StringBuilder()
                builder.append("[")
                defenderPosition.forEachIndexed { index, i ->
                    if (index != 0) {
                        builder.append(", ")
                    }
                    builder.append(i.toString())
                }
                builder.append("]")

                Timber.e("round:$round  attacker:${attackerPosition}  defender:${builder.toString()}  attackType:$attackType  damageType:$damageType")
                roundList.add(RoundVo(round, attackerPosition, defenderPosition, attackType, 30, damageType))
            }
        }

        val ownSideDataList = mutableListOf<BattleDataVo>()
        ownList.forEachIndexed { index, battleVo ->
            ownSideDataList.add(BattleDataVo(battleVo.avatar, (index + 1) * 33, (index + 1) * 44))
        }

        val opponentDataList = mutableListOf<BattleDataVo>()
        opponentList.forEachIndexed { index, battleVo ->
            opponentDataList.add(BattleDataVo(battleVo.avatar, (index + 1) * 33, (index + 1) * 44))
        }
        val result = Math.random() >= 0.5
        return BattleResultVo(ownList, opponentList, roundList, ownSideDataList, opponentDataList, result)
    }
}