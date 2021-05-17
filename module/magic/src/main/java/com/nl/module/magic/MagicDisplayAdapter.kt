package com.nl.module.magic

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.module.magic.databinding.ItemMagicDisplayBinding

class MagicDisplayAdapter : BaseQuickAdapter<MagicVo, BaseDataBindingHolder<ItemMagicDisplayBinding>>(R.layout.item_magic_display) {

    override fun convert(holder: BaseDataBindingHolder<ItemMagicDisplayBinding>, item: MagicVo) {
        holder.dataBinding?.apply {
            ivMagicIcon.setImageResource(item.icon)
            tvMagicName.text = context.getString(
                R.string.str_skill_name_and_level,
                item.name,
                item.level.toString()
            )
        }
    }
}