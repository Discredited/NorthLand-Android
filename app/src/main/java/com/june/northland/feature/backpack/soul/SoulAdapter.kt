package com.june.northland.feature.backpack.soul

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemSoulBinding
import com.june.northland.feature.soul.SoulVo

class SoulAdapter :
    BaseQuickAdapter<SoulVo, BaseDataBindingHolder<ItemSoulBinding>>(R.layout.item_soul) {

    override fun convert(holder: BaseDataBindingHolder<ItemSoulBinding>, item: SoulVo) {
        holder.dataBinding?.apply {
            ivCover.setImageResource(item.icon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.level}"
        }
    }
}