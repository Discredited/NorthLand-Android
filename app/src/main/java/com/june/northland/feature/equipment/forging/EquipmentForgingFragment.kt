package com.june.northland.feature.equipment.forging

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.EquipmentVo
import kotlinx.android.synthetic.main.fragment_equipment_forging.*

/**
 * 装备锻造
 */
class EquipmentForgingFragment : BaseFragment() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()

    override fun getLayoutResId(): Int = R.layout.fragment_equipment_forging

    override fun initView() {
        btForging.click {
            forgingEquipment("")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mEquipmentViewModel.mEquipmentLive.observe(viewLifecycleOwner, Observer {
            requestForgingInfo(it)
        })
    }

    private fun requestForgingInfo(equipment: EquipmentVo) {
        vForgingDisplay.initForgingDisplay(equipment)

        val forgingQualityString = EquipmentHelper.equipmentQuality(equipment.quality + 1)
        tvEquipmentProperty.text = "基本属性由100增至200，成长属性由100增至200"
        tvForgingStrengthen.text = "增加一条${forgingQualityString}增幅属性"
        tvForgingIncrease.text = "开启${forgingQualityString}强化加成"

        tvSilverCost.text = "银两:2000"
        tvMaterialCost.text = "锻造石:2000"

        btForging.isEnabled = !equipment.isQualityMax()
    }

    private fun forgingEquipment(id:String) {
        mEquipmentViewModel.equipmentForging(id)
    }

    companion object {
        fun newInstance(): EquipmentForgingFragment {
            return EquipmentForgingFragment()
        }
    }
}