package com.june.northland.feature.main

import com.june.northland.databinding.ActivityMainBinding
import com.june.northland.feature.main.ui.ScenesFragment
import com.nl.component.NLBaseActivity
import com.nl.component.ext.commitFragment

class MainActivity : NLBaseActivity<ActivityMainBinding>() {

    override fun initView() {
    }

    override fun loadData() {
        mBinding.fcScenesContainer.commitFragment(supportFragmentManager, ScenesFragment())
    }
}