package com.june.northland.feature.backpack.soul

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.character.soul.SoulVo
import kotlinx.android.synthetic.main.item_soul.view.*

class SoulAdapter : BaseQuickAdapter<SoulVo, BaseViewHolder>(R.layout.item_soul) {
    override fun convert(holder: BaseViewHolder, item: SoulVo) {
        holder.itemView.ivCover.setImageResource(item.icon)
        holder.itemView.tvName.text = item.name
        holder.itemView.tvLevel.text = "${holder.adapterPosition * 3}"
        holder.itemView.tvAttribute.text = "攻击力+${item.level}"
    }
}