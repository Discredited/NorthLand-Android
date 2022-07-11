package com.nl.module.equipment.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.nl.lib.element.equipment.EquipmentEnum
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.WidgetEquipmentStarBinding

/**
 * 装备质量星星显示
 *
 * 2022/7/11
 * @author June
 */
class EquipmentStarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayoutCompat(context, attrs) {

    private val mBinding = WidgetEquipmentStarBinding.inflate(LayoutInflater.from(context), this)

    fun setEquipmentStar(equipment: EquipmentVo) {
        val starDrawable = when (equipment.quality) {
            EquipmentEnum.QUALITY_REFINE -> R.drawable.svg_star_refine
            EquipmentEnum.QUALITY_FLAWLESS -> R.drawable.svg_star_flawless
            EquipmentEnum.QUALITY_EXTRAORDINARY -> R.drawable.svg_star_extraordinary
            EquipmentEnum.QUALITY_EXTREME -> R.drawable.svg_star_extreme
            EquipmentEnum.QUALITY_PEERLESS -> R.drawable.svg_star_peerless
            else -> R.drawable.svg_star_normal
        }
        mBinding.ivStar1.setImageResource(starDrawable)
        mBinding.ivStar2.setImageResource(starDrawable)
        mBinding.ivStar3.setImageResource(starDrawable)
        mBinding.ivStar4.setImageResource(starDrawable)
        mBinding.ivStar5.setImageResource(starDrawable)
    }
}