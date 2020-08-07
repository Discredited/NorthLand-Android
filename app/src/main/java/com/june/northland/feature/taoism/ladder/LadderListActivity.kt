package com.june.northland.feature.taoism.ladder

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.activity_ladder_list.*
import kotlinx.android.synthetic.main.view_close_image.*

/**
 * @author June
 * @description 莲华盛会(天梯)
 * @version 1.0.0
 * @time 2020/8/6 15:36
 */
class LadderListActivity : BaseActivity() {

    private val mAdapter = LadderAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_ladder_list

    override fun initView() {
        rvLadder.setLinearManager()
        rvLadder.adapter = mAdapter
        rvLadder.setHasFixedSize(true)
        rvLadder.addLinearItemDecoration()

        ivClose.click { finish() }
    }

    override fun loadData() {
        val list = mutableListOf<LadderVo>()
        for (index in 0 until 20) {
            list.add(LadderVo())
        }
        mAdapter.setNewInstance(list)
    }
}