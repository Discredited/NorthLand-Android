package com.nl.module.equipment.list

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ItemEquipmentBinding
import timber.log.Timber

class EquipmentDisplayAdapter :
    BaseQuickAdapter<EquipmentVo, BaseDataBindingHolder<ItemEquipmentBinding>>(R.layout.item_equipment) {

    override fun convert(holder: BaseDataBindingHolder<ItemEquipmentBinding>, item: EquipmentVo) {
        holder.dataBinding?.apply {
            val qualityColor = ContextCompat.getColor(
                holder.itemView.context,
                EquipmentHelper.equipmentQualityColor(item.quality)
            )
            Timber.e("${item.name}  装备品质:${item.quality}  颜色:${qualityColor}")
            tvEquipmentName.setBackgroundColor(qualityColor)
            tvEquipmentName.text = item.name
            vEquipmentIcon.setEquipmentIcon(item, qualityColor)
            vEquipmentStar.setEquipmentStar(item)
        }
    }
}