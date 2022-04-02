package com.june.northland.feature.store

import com.june.northland.databinding.ActivityStoreBinding
import com.nl.component.NLBaseActivity

class StoreActivity : NLBaseActivity<ActivityStoreBinding>() {

    private lateinit var mAdapter: StoreAdapter

    override fun initView() {
        mAdapter = StoreAdapter(supportFragmentManager, lifecycle)
        mBinding.vpStore.adapter = mAdapter
    }

    override fun loadData() {
    }
}