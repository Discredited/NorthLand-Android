package com.june.northland.feature.plot

import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import com.june.northland.feature.main.vo.PlotVo
import kotlinx.android.synthetic.main.activity_plot.*

class PlotActivity : BaseActivity() {

    private val mAdapter = PlotAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_plot

    override fun initView() {
        mAdapter.itemClick { _, _, _ ->
            startActivity(Intent(this, PlotBattleActivity::class.java))
        }

        rvPlot.setLinearManager()
        rvPlot.adapter = mAdapter
        rvPlot.setHasFixedSize(true)
        rvPlot.addLinearItemDecoration()
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                PlotVo("红尘天", R.drawable.img_practice_0, "30 / 900"),
                PlotVo("魔刹天", R.drawable.img_practice_1, "0 / 900"),
                PlotVo("罗生天", R.drawable.img_practice_2, "0 / 900"),
                PlotVo("清虚天", R.drawable.img_practice_3, "0 / 900"),
                PlotVo("吉祥天", R.drawable.img_practice_0, "0 / 900")
            )
        )
    }
}