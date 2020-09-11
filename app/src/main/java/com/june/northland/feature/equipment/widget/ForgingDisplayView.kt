package com.june.northland.feature.equipment.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentVo
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.widget_forging_display_view.view.*

class ForgingDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_forging_display_view, this, true)
    }

    fun initForgingDisplay(equipment: EquipmentVo) {
        val qualityColor = ContextCompat.getColor(context, ColorUtils.equipmentQualityColor(equipment.quality))
        val qualityString = EquipmentHelper.equipmentQuality(equipment.quality)
        ivEquipment.setDrawable(strokeColor = qualityColor)
        ivEquipmentName.text = "${qualityString}长剑"
        ivEquipmentName.setTextColor(qualityColor)
        val forgingQualityColor = ContextCompat.getColor(
            context,
            ColorUtils.equipmentQualityColor(equipment.quality + 1)
        )
        val forgingQualityString = EquipmentHelper.equipmentQuality(equipment.quality + 1)
        ivEquipmentForging.setDrawable(strokeColor = forgingQualityColor)
        tvEquipmentForgingName.text = "${forgingQualityString}长剑"
        tvEquipmentForgingName.setTextColor(forgingQualityColor)
    }
}