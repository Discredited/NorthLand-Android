package com.june.northland.feature.practice

import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.june.northland.R
import com.june.northland.databinding.ActivityPracticeBinding
import com.nl.component.NLBaseActivity

class PracticeActivity : NLBaseActivity<ActivityPracticeBinding>() {

    private val mAdapter = PracticeAdapter()

    override fun initView() {
        mBinding.rvPractice.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }

        mBinding.iClose.ivClose.click { finish() }
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                PracticeVo("妖力 | 道境", R.drawable.img_practice_0),
                PracticeVo("怨渊", R.drawable.img_practice_1),
                PracticeVo("风雷池", R.drawable.img_practice_2),
                PracticeVo("迷空岛", R.drawable.img_practice_3)
            )
        )
    }
}