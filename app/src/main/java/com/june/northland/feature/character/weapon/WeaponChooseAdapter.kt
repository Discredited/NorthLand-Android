package com.june.northland.feature.character.weapon

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_weapon_choose.view.*

class WeaponChooseAdapter : BaseQuickAdapter<WeaponVo, BaseViewHolder>(R.layout.item_weapon_choose) {

    override fun convert(holder: BaseViewHolder, item: WeaponVo) {
        holder.itemView.ivCover.setImageResource(item.coverIcon)
        holder.itemView.tvName.text = item.name
        holder.itemView.tvLevel.text = "${holder.adapterPosition * 3}"
        holder.itemView.tvAttribute.text = "攻击力+${holder.adapterPosition * 303}"
    }
}