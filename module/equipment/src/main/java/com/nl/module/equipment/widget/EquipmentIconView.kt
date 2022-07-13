package com.nl.module.equipment.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadImage
import com.nl.component.ext.setDrawableWithStroke
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.databinding.WidgetEquipmentIconBinding

/**
 * 装备图标显示
 *
 * 2022/7/12
 * @author June
 */
class EquipmentIconView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val mBinding = WidgetEquipmentIconBinding.inflate(LayoutInflater.from(context), this)

    fun setEquipmentIcon(equipment: EquipmentVo, qualityColor: Int) {
        mBinding.ivEquipmentIconBg.setDrawableWithStroke(strokeColor = qualityColor, strokeWidth = 20)
        mBinding.ivEquipmentIcon.loadImage(FilePathHelper.getEquipmentIcon(equipment.icon))
    }
}