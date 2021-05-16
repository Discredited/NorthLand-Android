package com.nl.module.equipment.increase

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.ext.setDrawable
import com.nl.module.equipment.IncreaseVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ItemEquipmentIncreaseBinding

class EquipmentIncreaseAdapter :
    BaseQuickAdapter<IncreaseVo, BaseDataBindingHolder<ItemEquipmentIncreaseBinding>>(R.layout.item_equipment_increase) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemEquipmentIncreaseBinding>,
        item: IncreaseVo
    ) {
        holder.itemView.setDrawable(strokeColor = item.color)
        holder.dataBinding?.apply {
            tvIncrease.text = item.description
            tvIncreaseLevel.text = "增幅等级:${holder.layoutPosition}/10"
        }
    }
}