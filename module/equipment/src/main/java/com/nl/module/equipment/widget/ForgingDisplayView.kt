package com.nl.module.equipment.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadAvatar
import com.nl.component.ext.setDrawable
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.WidgetForgingDisplayViewBinding

class ForgingDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mBinding: WidgetForgingDisplayViewBinding =
        WidgetForgingDisplayViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_forging_display_view, this, true)
    }

    fun initForgingDisplay(equipment: EquipmentVo) {
        val qualityColor = ContextCompat.getColor(context, EquipmentHelper.equipmentQualityColor(equipment.quality))
        mBinding.ivEquipment.setDrawable(strokeColor = qualityColor)
        mBinding.ivEquipment.loadAvatar(FilePathHelper.getEquipmentIcon(equipment.icon))
        mBinding.ivEquipmentName.text = equipment.name
        mBinding.ivEquipmentName.setTextColor(qualityColor)

        if (equipment.isQualityMax()) {
            mBinding.tvForgingNext.visibility = GONE
            mBinding.ivEquipmentForging.visibility = GONE
            mBinding.tvEquipmentForgingName.visibility = GONE
        } else {
            val equipmentForging = EquipmentHelper.equipmentNextQuality(equipment)
            val forgingQualityColor = ContextCompat.getColor(context, EquipmentHelper.equipmentQualityColor(equipmentForging.quality))
            mBinding.ivEquipmentForging.setDrawable(strokeColor = forgingQualityColor)
            mBinding.ivEquipmentForging.loadAvatar(FilePathHelper.getEquipmentIcon(equipmentForging.icon))
            mBinding.tvEquipmentForgingName.text = equipmentForging.name
            mBinding.tvEquipmentForgingName.setTextColor(forgingQualityColor)

            mBinding.tvForgingNext.visibility = VISIBLE
            mBinding.ivEquipmentForging.visibility = VISIBLE
            mBinding.tvEquipmentForgingName.visibility = VISIBLE
        }
    }
}