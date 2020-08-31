package com.june.northland.feature.backpack.equipment

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.equipment.EquipmentVo
import kotlinx.android.synthetic.main.item_equipment.view.*

class EquipmentAdapter : BaseQuickAdapter<EquipmentVo, BaseViewHolder>(R.layout.item_equipment) {

    override fun convert(holder: BaseViewHolder, item: EquipmentVo) {
        holder.itemView.ivCover.setImageResource(item.coverIcon)
        holder.itemView.tvName.text = item.name
        holder.itemView.tvLevel.text = "${holder.adapterPosition * 3}"
        holder.itemView.tvAttribute.text = "攻击力+${item.value}"
    }
}