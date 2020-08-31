package com.june.northland.feature.equipment

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.equipment.detail.EquipmentDetailActivity
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.fragment_dialog_equipment_info.*

class EquipmentInfoFragment : BaseDialogFragment() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_equipment_info

    override fun initView() {
        btStrengthen.click {
            EquipmentDetailActivity.start(requireActivity(), "")
        }
        btForging.click {
            EquipmentDetailActivity.start(requireActivity(), "", EquipmentHelper.OPERATE_FORGING)
        }
        btIncrease.click {
            EquipmentDetailActivity.start(requireActivity(), "", EquipmentHelper.OPERATE_INCREASE)
        }
        btSpell.click {
            EquipmentDetailActivity.start(requireActivity(), "", EquipmentHelper.OPERATE_SPELL)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestEquipment()
    }

    private fun requestEquipment() {
        val equipment = mEquipmentViewModel.equipmentDetail("")
        val qualityColor = ContextCompat.getColor(requireContext(), ColorUtils.equipmentQualityColor(equipment.quality))
        ivEquipmentIcon.setDrawable(strokeColor = qualityColor)
        ivEquipmentIcon.setImageResource(R.drawable.ic_attack)
        tvEquipmentName.text = equipment.name
        tvEquipmentName.setTextColor(qualityColor)
        tvBasic.text = equipment.basicDesc
        tvExtra.text = equipment.extraDesc
        tvDescContent.text = "比电更快，比雷更烈。北境第一攻击魂器，可以破开时空的极限之枪，是林飞自灵宝天取得"
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