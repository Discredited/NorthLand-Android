package com.june.northland.feature.dungeon

import androidx.activity.viewModels
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.feature.battle.BattleViewModel
import kotlinx.android.synthetic.main.activity_plot_battle.*

/**
 * @author June
 * @description 副本对战
 * @version
 * @time 2020/7/28 15:51
 */
class DungeonBattleActivity : BaseActivity() {

    private val mBattleViewModel by viewModels<BattleViewModel>()

    override fun getLayoutResId(): Int = R.layout.activity_plot_battle

    override fun initView() {
        vBattleground.bindSkillEffectView(tvSkillEffect)

        tvAttackNormal.click {
            simulationAttack(0)
        }
        tvAttackSkill.click {
            simulationAttack(1)
        }
    }

    override fun loadData() {
        requestBattleList()
        requestBattleRound()
    }

    //对战列表
    private fun requestBattleList() {
        val battleList = mBattleViewModel.battleList("", "")
        vBattleground.initBattleView(battleList.ownSideList, battleList.opponentList)
    }

    //对战回合
    private fun requestBattleRound() {

    }

    //模拟攻击
    private var mOwnSidePosition = 0
    private fun simulationAttack(attackMode: Int = 0) {
        vBattleground.roundStart(mOwnSidePosition, mOwnSidePosition, attackMode)
        mOwnSidePosition++
    }
}