package com.june.northland.feature.backpack.equipment

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemEquipmentBinding
import com.june.northland.feature.equipment.EquipmentVo

class EquipmentAdapter :
    BaseQuickAdapter<EquipmentVo, BaseDataBindingHolder<ItemEquipmentBinding>>(R.layout.item_equipment) {

    override fun convert(holder: BaseDataBindingHolder<ItemEquipmentBinding>, item: EquipmentVo) {
        holder.dataBinding?.apply {
            ivCover.setImageResource(item.coverIcon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.value}"
        }
    }
}