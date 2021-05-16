package com.nl.module.equipment.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.nl.component.common.ColorUtils
import com.nl.component.ext.setDrawable
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.WidgetForgingDisplayViewBinding

class ForgingDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mBinding :WidgetForgingDisplayViewBinding = WidgetForgingDisplayViewBinding.inflate(LayoutInflater.from(context),this)

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_forging_display_view, this, true)
    }

    fun initForgingDisplay(equipment: EquipmentVo) {
        val qualityColor = ContextCompat.getColor(context, ColorUtils.equipmentQualityColor(equipment.quality))
        val qualityString = EquipmentHelper.equipmentQuality(equipment.quality)
        mBinding.ivEquipment.setDrawable(strokeColor = qualityColor)
        mBinding.ivEquipmentName.text = "${qualityString}长剑"
        mBinding.ivEquipmentName.setTextColor(qualityColor)

        if (equipment.isQualityMax()) {
            mBinding.vForgingGroup.visibility = View.GONE
        } else {
            val forgingQualityColor = ContextCompat.getColor(
                context,
                ColorUtils.equipmentQualityColor(equipment.quality + 1)
            )
            val forgingQualityString = EquipmentHelper.equipmentQuality(equipment.quality + 1)
            mBinding.ivEquipmentForging.setDrawable(strokeColor = forgingQualityColor)
            mBinding.tvEquipmentForgingName.text = "${forgingQualityString}长剑"
            mBinding.tvEquipmentForgingName.setTextColor(forgingQualityColor)
            mBinding.vForgingGroup.visibility = View.VISIBLE
        }
    }
}