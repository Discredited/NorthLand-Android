package com.june.northland.feature.equipment.forging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import com.june.northland.databinding.FragmentEquipmentForgingBinding
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.EquipmentVo

/**
 * 装备锻造
 */
class EquipmentForgingFragment : BaseFragment<FragmentEquipmentForgingBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentForgingBinding {
        return FragmentEquipmentForgingBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.btForging.click {
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