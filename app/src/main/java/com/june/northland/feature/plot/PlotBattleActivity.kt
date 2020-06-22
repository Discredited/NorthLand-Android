package com.june.northland.feature.plot

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.activity_plot_battle.*

class PlotBattleActivity : BaseActivity() {
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