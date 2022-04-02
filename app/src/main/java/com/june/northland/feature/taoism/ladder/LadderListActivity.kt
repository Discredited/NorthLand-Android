package com.june.northland.feature.taoism.ladder

import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.june.northland.databinding.ActivityLadderListBinding
import com.nl.component.NLBaseActivity

/**
 * @author June
 * @description 莲华盛会(天梯)
 * @version 1.0.0
 * @time 2020/8/6 15:36
 */
class LadderListActivity : NLBaseActivity<ActivityLadderListBinding>() {

    private val mAdapter = LadderAdapter()

    override fun initView() {
        mBinding.rvLadder.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }

        mBinding.iClose.ivClose.click { finish() }
    }

    override fun loadData() {
        val list = mutableListOf<LadderVo>()
        for (index in 0 until 20) {
            list.add(LadderVo())
        }
        mAdapter.setNewInstance(list)
    }
}