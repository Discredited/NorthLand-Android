package com.nl.module.equipment.strengthen

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ItemStrengthenAdditionBinding

class StrengthenAttrAdapter :
    BaseQuickAdapter<StrengthAdditionVo, BaseDataBindingHolder<ItemStrengthenAdditionBinding>>(R.layout.item_strengthen_addition) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemStrengthenAdditionBinding>,
        item: StrengthAdditionVo
    ) {
        val color = if (holder.layoutPosition % 2 == 0) {
            ContextCompat.getColor(context, R.color.color_yellow_light)
        } else {
            ContextCompat.getColor(context, R.color.color_transparent)
        }
        holder.itemView.setBackgroundColor(color)
        holder.dataBinding?.apply {
            tvAddition.text = item.description
            btAdditionStatus.text = item.statusString
            btAdditionStatus.isEnabled = item.statusEnable
        }
    }
}