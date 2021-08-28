package com.june.northland.feature.main

import androidx.core.view.GravityCompat
import com.june.northland.R
import com.june.northland.databinding.ActivityMainBinding
import com.june.northland.feature.main.ui.ScenesFragment
import com.june.northland.feature.main.ui.SettingFragment
import com.nl.component.NLBaseActivity
import com.nl.component.ext.commitFragment

class MainActivity : NLBaseActivity<ActivityMainBinding>() {

    override fun viewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        // drawLayout center布局顶部自有一个间距的问题
    }

    override fun loadData() {
        mBinding.fcScenesContainer.commitFragment(
            supportFragmentManager,
            R.id.fcScenesContainer,
            ScenesFragment()
        )

        mBinding.fcSettingContainer.commitFragment(
            supportFragmentManager,
            R.id.fcSettingContainer,
            SettingFragment()
        )
    }

    fun openDrawLayout() {
        mBinding.drawLayout.openDrawer(GravityCompat.START)
    }
}