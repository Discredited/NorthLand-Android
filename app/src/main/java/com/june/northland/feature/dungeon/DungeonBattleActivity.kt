package com.june.northland.feature.dungeon

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.activity_plot_battle.*

/**
 * @author June
 * @description 副本对战
 * @version
 * @time 2020/7/28 15:51
 */
class DungeonBattleActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.activity_plot_battle

    override fun initView() {
        vBattleground.initBattleView()
    }

    override fun loadData() {
        damage.click {
            vBattleground.roundStart()
        }
    }
}