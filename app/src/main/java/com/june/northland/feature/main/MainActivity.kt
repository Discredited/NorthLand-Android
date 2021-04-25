package com.june.northland.feature.main

import androidx.core.view.GravityCompat
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.commitFragment
import com.june.northland.databinding.ActivityMainBinding
import com.june.northland.feature.main.ui.ScenesFragment
import com.june.northland.feature.main.ui.SettingFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

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