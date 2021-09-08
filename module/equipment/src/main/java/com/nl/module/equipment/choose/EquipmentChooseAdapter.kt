package com.nl.module.equipment.choose

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadAvatar
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ItemEquipmentChooseBinding

class EquipmentChooseAdapter :
    BaseQuickAdapter<EquipmentVo, BaseDataBindingHolder<ItemEquipmentChooseBinding>>(R.layout.item_equipment_choose) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemEquipmentChooseBinding>,
        item: EquipmentVo
    ) {
        holder.dataBinding?.apply {
            ivCover.loadAvatar(FilePathHelper.getEquipmentIcon(item.icon))
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.value}"
        }
    }
}