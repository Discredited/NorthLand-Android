package com.june.northland.feature.equipment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.databinding.FragmentDialogEquipmentInfoBinding
import com.june.northland.feature.equipment.detail.EquipmentDetailActivity
import com.june.northland.utils.ColorUtils

class EquipmentInfoFragment : BaseDialogFragment<FragmentDialogEquipmentInfoBinding>() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDialogEquipmentInfoBinding {
        return FragmentDialogEquipmentInfoBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mBinding.btStrengthen.click {
            EquipmentDetailActivity.start(requireActivity(), "")
            dismiss()
        }
        mBinding.btForging.click {
            EquipmentDetailActivity.start(requireActivity(), "", EquipmentHelper.OPERATE_FORGING)
            dismiss()
        }
        mBinding.btIncrease.click {
            EquipmentDetailActivity.start(requireActivity(), "", EquipmentHelper.OPERATE_INCREASE)
            dismiss()
        }
        mBinding.btSpell.click {
            EquipmentDetailActivity.start(requireActivity(), "", EquipmentHelper.OPERATE_SPELL)
            dismiss()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestEquipment()
    }

    private fun requestEquipment() {
        val equipment = mEquipmentViewModel.equipmentDetail("")
        val qualityColor = ContextCompat.getColor(
            requireContext(),
            ColorUtils.equipmentQualityColor(equipment.quality)
        )
        mBinding.ivEquipmentIcon.setDrawable(strokeColor = qualityColor)
        mBinding.ivEquipmentIcon.setImageResource(R.drawable.ic_attack)
        mBinding.tvEquipmentName.text = equipment.name
        mBinding.tvEquipmentName.setTextColor(qualityColor)
        mBinding.tvBasic.text = equipment.basicDesc
        mBinding.tvExtra.text = equipment.extraDesc
        mBinding.tvDescContent.text = "比电更快，比雷更烈。北境第一攻击魂器，可以破开时空的极限之枪，是林飞自灵宝天取得"
    }

    override fun layoutParamsWidth(): Int {
        return WindowManager.LayoutParams.WRAP_CONTENT
    }

    override fun layoutParamsHeight(): Int {
        return WindowManager.LayoutParams.WRAP_CONTENT
    }

    companion object {
        fun newInstance(id: String): EquipmentInfoFragment {
            val fragment = EquipmentInfoFragment()
            val arguments = Bundle()
            arguments.putString("ID", id)
            fragment.arguments = arguments
            return fragment
        }
    }
}