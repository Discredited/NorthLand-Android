package com.nl.module.magic.backpack

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.module.magic.R
import com.nl.module.magic.databinding.ItemMagicBinding

class MagicAdapter :
    BaseQuickAdapter<com.nl.module.magic.MagicVo, BaseDataBindingHolder<ItemMagicBinding>>(R.layout.item_magic) {

    override fun convert(holder: BaseDataBindingHolder<ItemMagicBinding>, item: com.nl.module.magic.MagicVo) {
        holder.dataBinding?.apply {
            ivCover.setImageResource(item.icon)
            tvName.text = item.name
            tvLevel.text = "${holder.adapterPosition * 3}"
            tvAttribute.text = "攻击力+${item.level}"
        }
    }
}