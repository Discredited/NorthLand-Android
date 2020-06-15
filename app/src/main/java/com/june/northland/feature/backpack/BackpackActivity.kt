package com.june.northland.feature.backpack

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.activity_backpack.*
import kotlinx.android.synthetic.main.view_close_image.*

class BackpackActivity : BaseActivity() {

    private lateinit var mAdapter: BackpackAdapter

    override fun getLayoutResId(): Int = R.layout.activity_backpack

    override fun initView() {
        mAdapter = BackpackAdapter(supportFragmentManager, lifecycle)

        vpGoods.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vpGoods.adapter = mAdapter

        TabLayoutMediator(
            tlCategory,
            vpGoods,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = "$position"
            }).attach()

        ivClose.click { finish() }
    }

    override fun loadData() {
    }
}