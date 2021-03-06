package com.june.northland.feature.backpack

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.base.basic.part.BaseActivity
import com.june.northland.R
import com.june.northland.databinding.ActivityBackpackBinding
import com.nl.component.ext.click

class BackpackActivity : BaseActivity<ActivityBackpackBinding>() {

    private lateinit var mAdapter: BackpackAdapter
    private val mPagerTitleList = mutableListOf<String>()

    override fun viewBinding(): ActivityBackpackBinding {
        return ActivityBackpackBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mAdapter = BackpackAdapter(supportFragmentManager, lifecycle)

        mBinding.vpGoods.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mBinding.vpGoods.adapter = mAdapter
        mBinding.iClose.ivClose.click { finish() }
    }

    override fun loadData() {
        mPagerTitleList.add(getString(R.string.str_goods))
        mPagerTitleList.add(getString(R.string.str_equipment))
        mPagerTitleList.add(getString(R.string.str_magic))
        mPagerTitleList.add(getString(R.string.str_soul))

        TabLayoutMediator(
            mBinding.tlCategory,
            mBinding.vpGoods
        ) { tab, position ->
            tab.text = mPagerTitleList[position]
        }.attach()
    }
}