package com.nl.module.equipment.detail

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayoutMediator
import com.june.base.basic.part.BaseActivity
import com.nl.component.common.ColorUtils
import com.nl.component.common.PropertyHelper
import com.nl.component.ext.setDrawable
import com.nl.component.widget.res.ResourceVo
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ActivityEquipmentDetailBinding

@Route(path = "/equipment/detail")
class EquipmentDetailActivity : BaseActivity<ActivityEquipmentDetailBinding>() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()
    private val mPagerTitleList = mutableListOf<String>()

    override fun viewBinding(): ActivityEquipmentDetailBinding {
        return ActivityEquipmentDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.vEquipmentResource.apply {
            addResource(ResourceVo(R.drawable.ic_gold, 9999))
            addResource(ResourceVo(R.drawable.ic_menu_practice, 200))
            addResource(ResourceVo(R.drawable.ic_menu_practice, 800))
        }

        mBinding.vpEquipment.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = EquipmentDetailAdapter(supportFragmentManager, lifecycle)
        }
    }

    override fun loadData() {
        mEquipmentViewModel.mEquipmentLive.observe(this, {
            initEquipment(it)
        })

        mPagerTitleList.add(getString(R.string.str_strengthen))
        mPagerTitleList.add(getString(R.string.str_forging))
        mPagerTitleList.add(getString(R.string.str_increase))
        mPagerTitleList.add(getString(R.string.str_spell))

        TabLayoutMediator(
            mBinding.tlEquipment,
            mBinding.vpEquipment,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = mPagerTitleList[position]
            }).attach()

        requestEquipment()

        val operate = intent.getIntExtra("OPERATE", EquipmentHelper.OPERATE_STRENGTHEN)
        if (operate > EquipmentHelper.OPERATE_STRENGTHEN) {
            mBinding.vpEquipment.currentItem = operate
        }
    }

    private fun requestEquipment() {
        mEquipmentViewModel.equipmentDetail("")
    }

    private fun initEquipment(equipment: EquipmentVo) {
        val qualityColor = ContextCompat.getColor(this, ColorUtils.equipmentQualityColor(equipment.quality))
        mBinding.ivEquipmentIcon.setDrawable(strokeColor = qualityColor)
        mBinding.tvEquipmentName.setTextColor(qualityColor)
        mBinding.tvEquipmentName.text = equipment.name
        mBinding.tvEquipmentValue.text = "${PropertyHelper.getPropertyName(equipment.property)}+${equipment.value}"
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