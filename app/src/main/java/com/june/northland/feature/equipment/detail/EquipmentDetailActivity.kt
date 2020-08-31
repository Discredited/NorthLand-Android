package com.june.northland.feature.equipment.detail

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.activity_equipment_detail.*

class EquipmentDetailActivity : BaseActivity() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()
    private val mPagerTitleList = mutableListOf<String>()

    override fun getLayoutResId(): Int = R.layout.activity_equipment_detail

    override fun initView() {
        vpEquipment.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vpEquipment.adapter = EquipmentDetailAdapter(supportFragmentManager, lifecycle)
    }

    override fun loadData() {
        mPagerTitleList.add(getString(R.string.str_strengthen))
        mPagerTitleList.add(getString(R.string.str_forging))
        mPagerTitleList.add(getString(R.string.str_increase))
        mPagerTitleList.add(getString(R.string.str_spell))

        TabLayoutMediator(
            tlEquipment,
            vpEquipment,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = mPagerTitleList[position]
            }).attach()

        requestEquipment()

        val operate = intent.getIntExtra("OPERATE", EquipmentHelper.OPERATE_STRENGTHEN)
        if (operate > EquipmentHelper.OPERATE_STRENGTHEN) {
            vpEquipment.currentItem = operate
        }
    }

    private fun requestEquipment() {
        val equipment = mEquipmentViewModel.equipmentDetail("")
        val qualityColor = ContextCompat.getColor(this, ColorUtils.equipmentQualityColor(equipment.quality))
        ivEquipmentIcon.setDrawable(strokeColor = qualityColor)
        tvEquipmentName.setTextColor(qualityColor)
        tvEquipmentName.text = equipment.name
    }

    companion object {
        fun start(context: Context, id: String, operate: Int = EquipmentHelper.OPERATE_STRENGTHEN) {
            val starter = Intent(context, EquipmentDetailActivity::class.java)
                .putExtra("ID", id)
                .putExtra("OPERATE", operate)
            context.startActivity(starter)
        }
    }
}