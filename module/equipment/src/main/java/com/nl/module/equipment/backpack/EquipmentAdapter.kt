package com.nl.module.equipment.backpack

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.ext.loadAvatar
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ItemEquipmentBinding

class EquipmentAdapter :
    BaseQuickAdapter<EquipmentVo, BaseDataBindingHolder<ItemEquipmentBinding>>(R.layout.item_equipment) {

    override fun convert(holder: BaseDataBindingHolder<ItemEquipmentBinding>, item: EquipmentVo) {
        holder.dataBinding?.apply {
            ivCover.loadAvatar(item.icon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.value}"
        }
    }
}