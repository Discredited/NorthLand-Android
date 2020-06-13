package com.june.northland.feature.main

import androidx.core.view.GravityCompat
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.commitFragment
import com.june.northland.feature.main.ui.ScenesFragment
import com.june.northland.feature.main.ui.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {

    }

    override fun loadData() {
        fcScenesContainer.commitFragment(
            supportFragmentManager,
            R.id.fcScenesContainer,
            ScenesFragment()
        )

        fcSettingContainer.commitFragment(
            supportFragmentManager,
            R.id.fcSettingContainer,
            SettingFragment()
        )
    }

    fun openDrawLayout() {
        drawLayout.openDrawer(GravityCompat.START)
    }
}