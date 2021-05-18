package com.nl.module.soul.backpack

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.module.soul.R
import com.nl.module.soul.databinding.ItemSoulBinding

class SoulAdapter :
    BaseQuickAdapter<com.nl.module.soul.SoulVo, BaseDataBindingHolder<ItemSoulBinding>>(R.layout.item_soul) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemSoulBinding>,
        item: com.nl.module.soul.SoulVo
    ) {
        holder.dataBinding?.apply {
            ivCover.setImageResource(item.icon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.level}"
        }
    }
}