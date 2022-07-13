package com.nl.module.equipment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseDialogFragment
import com.nl.component.common.ColorUtils
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadAvatar
import com.nl.component.ext.setDrawableWithStroke
import com.nl.module.equipment.choose.EquipmentChooseActivity
import com.nl.module.equipment.databinding.FragmentDialogEquipmentInfoBinding
import com.nl.module.equipment.detail.EquipmentDetailActivity

class EquipmentInfoFragment : BaseDialogFragment<FragmentDialogEquipmentInfoBinding>() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()

    override fun initView() {
        mBinding.btStrengthen.click {
            //ARouter.getInstance().build("/equipment/detail").navigation()
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
        mBinding.tvExchange.click {
            val part = arguments?.getInt("PART") ?: EquipmentHelper.PART_ALL
            EquipmentChooseActivity.starter(requireActivity(), part)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestEquipment()
    }

    private fun requestEquipment() {
        val equipment = mEquipmentViewModel.equipmentDetail2("")
        val qualityColor = ContextCompat.getColor(
            requireContext(),
            ColorUtils.equipmentQualityColor(equipment.quality)
        )
        mBinding.ivEquipmentIcon.setDrawableWithStroke(strokeColor = qualityColor)
        mBinding.ivEquipmentIcon.loadAvatar(FilePathHelper.getEquipmentIcon(equipment.icon))
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
        fun newInstance(id: String, part: Int = EquipmentHelper.PART_ALL): EquipmentInfoFragment {
            val fragment = EquipmentInfoFragment()
            val arguments = Bundle()
            arguments.putString("ID", id)
            arguments.putInt("PART", part)
            fragment.arguments = arguments
            return fragment
        }
    }
}