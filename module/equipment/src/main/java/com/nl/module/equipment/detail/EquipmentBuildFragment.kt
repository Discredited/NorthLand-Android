package com.nl.module.equipment.detail

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.june.base.basic.ext.click
import com.nl.component.NLBaseDialogFragment
import com.nl.component.ext.setDrawable
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.FragmentEquipmentBuildBinding

/**
 * 初次锻造装备
 */
class EquipmentBuildFragment : NLBaseDialogFragment<FragmentEquipmentBuildBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentBuildBinding {
        return FragmentEquipmentBuildBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mBinding.btCancel.click { dismiss() }
        mBinding.btBuild.click { buildEquipment() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initEquipmentBuild()
    }

    private fun initEquipmentBuild() {
        val part = arguments?.getInt("PART") ?: EquipmentHelper.PART_WEAPON
        val equipment = mEquipmentViewModel.equipmentBuildInfo(part)

        mBinding.tvBuildTitle.text = "打造${equipment.name}"
        mBinding.ivEquipmentIcon.setImageResource(equipment.coverIcon)
        mBinding.ivEquipmentIcon.setDrawable(
            strokeColor = ContextCompat.getColor(
                requireContext(),
                R.color.color_equipment_normal
            ),
            strokeWidth = resources.getDimensionPixelSize(R.dimen.dp_3)
        )
        mBinding.ivEquipmentName.text = equipment.name
        mBinding.ivEquipmentQuality.text = "品质 ${EquipmentHelper.equipmentQuality(equipment.quality)}"
        mBinding.tvEquipmentValue.text = "攻击+${equipment.value}"
        mBinding.tvEquipmentCost.text = "打造石：2000"
    }

    private fun buildEquipment() {
        showLoading()
        mBinding.tvBuildTitle.postDelayed({
            hideLoading()
            val part = arguments?.getInt("PART") ?: EquipmentHelper.PART_WEAPON
            val equipment = mEquipmentViewModel.equipmentBuild(part)
            mEquipmentViewModel.mEquipmentLive.value = equipment
            dismiss()
        }, 500)
    }

    override fun layoutParamsWidth(): Int = WindowManager.LayoutParams.WRAP_CONTENT
    override fun layoutParamsHeight(): Int = WindowManager.LayoutParams.WRAP_CONTENT
    override fun layoutGravity(): Int = Gravity.CENTER

    companion object {
        fun newInstance(part: Int): EquipmentBuildFragment {
            val args = Bundle()
            args.putInt("PART", part)
            val fragment = EquipmentBuildFragment()
            fragment.arguments = args
            return fragment
        }
    }
}