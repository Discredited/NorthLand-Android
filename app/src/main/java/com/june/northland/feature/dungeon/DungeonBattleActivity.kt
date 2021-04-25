package com.june.northland.feature.dungeon

import androidx.activity.viewModels
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.databinding.ActivityPlotBattleBinding
import com.june.northland.feature.battle.BattleProcedureListener
import com.june.northland.feature.battle.BattleResultFailFragment
import com.june.northland.feature.battle.BattleResultSuccessFragment
import com.june.northland.feature.battle.BattleViewModel
import com.june.northland.feature.battle.vo.RoundVo
import com.june.northland.utils.Toast

/**
 * @author June
 * @description 副本对战
 * @version
 * @time 2020/7/28 15:51
 */
class DungeonBattleActivity : BaseActivity<ActivityPlotBattleBinding>() {

    private val mBattleViewModel by viewModels<BattleViewModel>()

    override fun viewBinding(): ActivityPlotBattleBinding {
        return ActivityPlotBattleBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.vBattleground.bindSkillEffectView(mBinding.tvSkillEffect)
        mBinding.vBattleground.bindBattleProcedureListener(object : BattleProcedureListener {
            override fun onBattleBegin() {
                Toast.toastShort("对战开始")
            }

            override fun onBattleFinish() {
                if (Math.random() > 0.5) {
                    BattleResultSuccessFragment().show(
                        supportFragmentManager,
                        "BattleResultSuccessFragment"
                    )
                } else {
                    BattleResultFailFragment().show(
                        supportFragmentManager,
                        "BattleResultFailFragment"
                    )
                }
                Toast.toastShort("对战结束")
            }
        })

        mBinding.tvAttackNormal.click {
            simulationAttack(0)
        }
        mBinding.tvAttackSkill.click {
            simulationAttack(1)
        }
        mBinding.btSkip.click { Toast.toastShort("跳过战斗") }
    }

    override fun loadData() {
        requestBattleRound()
    }

    //对战回合
    private fun requestBattleRound() {
        val battleResult = mBattleViewModel.battleResult()
        mBinding.vBattleground.initBattle(battleResult)
        mBinding.vBattleground.postDelayed({
            mBinding.vBattleground.roundStart()
        }, 800)
    }

    //模拟攻击
    private var mOwnSidePosition = 0
    private fun simulationAttack(attackMode: Int = 0) {
        val damageType = (Math.random() * 10 % 3).toInt()
        mBinding.vBattleground.roundStart(
            RoundVo(
                1,
                mOwnSidePosition,
                intArrayOf(0),
                attackMode,
                20,
                damageType
            )
        )
        mOwnSidePosition++
    }
}