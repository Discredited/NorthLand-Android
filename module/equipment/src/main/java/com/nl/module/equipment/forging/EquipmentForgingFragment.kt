package com.nl.module.equipment.forging

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.june.base.basic.ext.click
import com.nl.component.NLBaseFragment
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.databinding.FragmentEquipmentForgingBinding

/**
 * 装备锻造
 */
class EquipmentForgingFragment : NLBaseFragment<FragmentEquipmentForgingBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()

    override fun initView() {
        mBinding.btForging.click { forgingEquipment("") }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mEquipmentViewModel.mEquipmentLive.observe(viewLifecycleOwner, {
            requestForgingInfo(it)
        })
    }

    private fun requestForgingInfo(equipment: EquipmentVo) {
        mBinding.vForgingDisplay.initForgingDisplay(equipment)

        val forgingQualityString = EquipmentHelper.equipmentQuality(equipment.quality + 1)
        mBinding.tvEquipmentProperty.text = "基本属性由100增至200，成长属性由100增至200"
        mBinding.tvForgingStrengthen.text = "增加一条${forgingQualityString}增幅属性"
        mBinding.tvForgingIncrease.text = "开启${forgingQualityString}强化加成"

        mBinding.tvSilverCost.text = "银两:2000"
        mBinding.tvMaterialCost.text = "锻造石:2000"

        mBinding.btForging.isEnabled = !equipment.isQualityMax()
    }

    private fun forgingEquipment(id: String) {
        mEquipmentViewModel.equipmentForging(id)
    }

    companion object {
        fun newInstance(): EquipmentForgingFragment {
            return EquipmentForgingFragment()
        }
    }
}