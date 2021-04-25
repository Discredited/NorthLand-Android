package com.june.northland.feature.practice

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setLinearManager
import com.june.northland.databinding.ActivityPracticeBinding

class PracticeActivity : BaseActivity<ActivityPracticeBinding>() {

    private val mAdapter = PracticeAdapter()

    override fun viewBinding(): ActivityPracticeBinding {
        return ActivityPracticeBinding.inflate(layoutInflater)
    }

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