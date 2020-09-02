package com.june.northland.feature.battle

import android.app.Application
import com.june.northland.base.component.AppViewModel
import com.june.northland.common.ConstantUtils
import com.june.northland.feature.battle.vo.BattleListVo
import com.june.northland.feature.battle.vo.BattleVo

class BattleViewModel(application: Application) : AppViewModel(application) {

    fun battleList(ownId: String, opponentId: String): BattleListVo {
        //随机生成己方
        val ownSize = (Math.random() * 7).toInt() + 1
        val ownList = mutableListOf<BattleVo>()
        for (index in 0 until ownSize) {
            ownList.add(ConstantUtils.randomBattleVo(index))
        }

        //随机生成对方
        val opponentSize = (Math.random() * 7).toInt() + 1
        val opponentList = mutableListOf<BattleVo>()
        for (index in 0 until opponentSize) {
            opponentList.add(ConstantUtils.randomBattleVo(index))
        }

        return BattleListVo(ownList, opponentList)
    }
}