package com.june.northland.feature.equipment.detail

import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentViewModel
import kotlinx.android.synthetic.main.fragment_equipment_build.*

/**
 * 初次锻造装备
 */
class EquipmentBuildFragment : BaseDialogFragment() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()

    override fun getLayoutResId(): Int = R.layout.fragment_equipment_build

    override fun initView() {
        btCancel.click { dismiss() }
        btBuild.click { buildEquipment() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initEquipmentBuild()
    }

    private fun initEquipmentBuild() {
        val part = arguments?.getInt("PART") ?: EquipmentHelper.PART_WEAPON
        val equipment = mEquipmentViewModel.equipmentBuildInfo(part)

        tvBuildTitle.text = "打造${equipment.name}"
        ivEquipmentIcon.setImageResource(equipment.coverIcon)
        ivEquipmentIcon.setDrawable(
            strokeColor = ContextCompat.getColor(
                requireContext(),
                R.color.color_equipment_normal
            ),
            strokeWidth = resources.getDimensionPixelSize(R.dimen.dp_3)
        )
        ivEquipmentName.text = equipment.name
        ivEquipmentQuality.text = "品质 ${EquipmentHelper.equipmentQuality(equipment.quality)}"
        tvEquipmentValue.text = "攻击+${equipment.value}"
        tvEquipmentCost.text = "打造石：2000"
    }

    private fun buildEquipment() {
        showLoading()
        tvBuildTitle.postDelayed({
            hideLoading()
            val part = arguments?.getInt("PART") ?: EquipmentHelper.PART_WEAPON
            val equipment = mEquipmentViewModel.equipmentBuildInfo(part)
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