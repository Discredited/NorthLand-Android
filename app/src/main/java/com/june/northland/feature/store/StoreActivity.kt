package com.june.northland.feature.store

import com.june.base.basic.part.BaseActivity
import com.june.northland.databinding.ActivityStoreBinding

class StoreActivity : BaseActivity<ActivityStoreBinding>() {

    private lateinit var mAdapter: StoreAdapter

    override fun viewBinding(): ActivityStoreBinding {
        return ActivityStoreBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mAdapter = StoreAdapter(supportFragmentManager, lifecycle)
        mBinding.vpStore.adapter = mAdapter
    }

    override fun loadData() {
    }
}