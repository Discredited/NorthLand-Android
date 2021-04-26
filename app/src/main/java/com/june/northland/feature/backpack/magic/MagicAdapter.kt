package com.june.northland.feature.backpack.magic

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemMagicBinding
import com.june.northland.feature.magic.MagicVo

class MagicAdapter :
    BaseQuickAdapter<MagicVo, BaseDataBindingHolder<ItemMagicBinding>>(R.layout.item_magic) {

    override fun convert(holder: BaseDataBindingHolder<ItemMagicBinding>, item: MagicVo) {
        holder.dataBinding?.apply {
            ivCover.setImageResource(item.icon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.level}"
        }
    }
}