package com.nl.module.equipment.list

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ToastUtils
import com.nl.component.NLBaseDialogFragment
import com.nl.component.common.ColorUtils
import com.nl.component.ext.setDrawableWithStroke
import com.nl.lib.element.base.PropertyHelper
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.DialogFragmentEquipmentDetailBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * 装备展示详情Fragment
 *
 * 2022/7/12
 * @author June
 */
class EquipmentDisplayDetailDialogFragment : NLBaseDialogFragment<DialogFragmentEquipmentDetailBinding>() {

    private val mViewModel by activityViewModels<EquipmentViewModel>()

    override fun initView() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            mViewModel.mEquipmentsFlow.collect { equipments ->
                val equipmentId = arguments?.getString("EQUIPMENT_ID")
                val equipment = equipments.find { it.id == equipmentId }
                if (null != equipment) {
                    setEquipment(equipment)
                } else {
                    ToastUtils.showShort("装备不能为空 id:$equipmentId")
                }
            }
        }
    }

    private fun setEquipment(equipment: EquipmentVo) {
        val qualityColor = ContextCompat.getColor(requireContext(), EquipmentHelper.equipmentQualityColor(equipment.quality))
        val strokeColor = ContextCompat.getColor(requireContext(), R.color.color_gray)
        val strokeWidth = resources.getDimensionPixelSize(R.dimen.dp_10)
        val topColor = ColorUtils.getColorWithAlpha(0.75F, qualityColor)
        mBinding.vBgRoot.setDrawableWithStroke(strokeColor = strokeColor, strokeWidth = strokeWidth)
        mBinding.vBgBottom.setBackgroundColor(topColor)
        mBinding.vEquipmentIcon.setEquipmentIcon(equipment, qualityColor)
        mBinding.tvEquipmentName.setTextColor(qualityColor)
        mBinding.tvEquipmentName.text = equipment.name
        mBinding.tvEquipmentCombatPower.text = getString(R.string.str_combo_power, equipment.value * 3)
        mBinding.vEquipmentStar.setEquipmentStar(equipment)
        mBinding.tvEquipmentOriginTitle.setBackgroundColor(qualityColor)
        mBinding.tvEquipmentOriginProperty.text = getString(
            R.string.str_name_add_value,
            PropertyHelper.getPropertyName(equipment.property),
            equipment.value
        )
        mBinding.tvEquipmentStrengthTitle.setBackgroundColor(qualityColor)
        mBinding.tvEquipmentStrengthProperty.text = getString(R.string.str_property_basic_random)
        mBinding.tvEquipmentForgingTitle.setBackgroundColor(qualityColor)
        mBinding.tvEquipmentForgingProperty.text = getString(R.string.str_property_extra_random)
    }

    override fun layoutParamsWidth(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    companion object {
        fun newInstance(id: String): EquipmentDisplayDetailDialogFragment {
            val args = Bundle().apply { putString("EQUIPMENT_ID", id) }
            return EquipmentDisplayDetailDialogFragment().apply { arguments = args }
        }
    }
}