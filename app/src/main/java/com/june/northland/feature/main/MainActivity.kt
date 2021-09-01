package com.june.northland.feature.main

import com.june.northland.R
import com.june.northland.databinding.ActivityMainBinding
import com.june.northland.feature.main.ui.ScenesFragment
import com.nl.component.NLBaseActivity
import com.nl.component.ext.commitFragment

class MainActivity : NLBaseActivity<ActivityMainBinding>() {

    override fun viewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
    }

    override fun loadData() {
        mBinding.fcScenesContainer.commitFragment(
            supportFragmentManager,
            R.id.fcScenesContainer,
            ScenesFragment()
        )
    }
}