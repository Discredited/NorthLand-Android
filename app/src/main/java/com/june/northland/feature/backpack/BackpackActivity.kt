package com.june.northland.feature.backpack

import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.feature.equipment.EquipmentViewModel
import kotlinx.android.synthetic.main.activity_backpack.*
import kotlinx.android.synthetic.main.view_close_image.*

class BackpackActivity : BaseActivity() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()

    private lateinit var mAdapter: BackpackAdapter
    private val mPagerTitleList = mutableListOf<String>()

    override fun getLayoutResId(): Int = R.layout.activity_backpack

    override fun initView() {
        mAdapter = BackpackAdapter(supportFragmentManager, lifecycle)

        vpGoods.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vpGoods.adapter = mAdapter
        ivClose.click { finish() }
    }

    override fun loadData() {
        mPagerTitleList.add(getString(R.string.str_goods))
        mPagerTitleList.add(getString(R.string.str_equipment))
        mPagerTitleList.add(getString(R.string.str_magic))
        mPagerTitleList.add(getString(R.string.str_soul))

        TabLayoutMediator(
            tlCategory,
            vpGoods,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = mPagerTitleList[position]
            }).attach()
    }
}