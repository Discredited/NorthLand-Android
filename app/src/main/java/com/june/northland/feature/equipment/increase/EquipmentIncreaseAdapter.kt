package com.june.northland.feature.equipment.increase

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.databinding.ItemEquipmentIncreaseBinding
import com.june.northland.feature.equipment.IncreaseVo

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