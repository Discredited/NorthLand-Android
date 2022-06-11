package com.nl.module.store

import com.nl.component.NLBaseActivity
import com.nl.module.store.databinding.ActivityStoreBinding

/**
 * 商店
 *
 * 2022年06月10日22:42:43
 *
 * @author:June
 */
class StoreActivity : NLBaseActivity<ActivityStoreBinding>() {

    private lateinit var mAdapter: StoreAdapter

    override fun initView() {
        mAdapter = StoreAdapter(supportFragmentManager, lifecycle)
        mBinding.vpStore.adapter = mAdapter
    }

    override fun loadData() {
    }
}