package com.june.northland.feature.equipment.choose

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemEquipmentChooseBinding
import com.june.northland.feature.equipment.EquipmentVo

class EquipmentChooseAdapter :
    BaseQuickAdapter<EquipmentVo, BaseDataBindingHolder<ItemEquipmentChooseBinding>>(R.layout.item_equipment_choose) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemEquipmentChooseBinding>,
        item: EquipmentVo
    ) {
        holder.dataBinding?.apply {
            ivCover.setImageResource(item.coverIcon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.value}"
        }
    }
}