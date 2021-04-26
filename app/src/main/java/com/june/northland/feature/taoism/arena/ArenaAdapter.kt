package com.june.northland.feature.taoism.arena

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemArenaBinding

class ArenaAdapter :
    BaseQuickAdapter<ArenaVo, BaseDataBindingHolder<ItemArenaBinding>>(R.layout.item_arena) {
    override fun convert(holder: BaseDataBindingHolder<ItemArenaBinding>, item: ArenaVo) {
        holder.dataBinding?.apply {
            tvArenaRank.text = "${holder.layoutPosition + 1}"
            ivArenaAvatar.setImageResource(R.drawable.ic_avatar_gan_ning_zhen)
            tvArenaName.text = "甘柠真-${holder.layoutPosition + 1}"
            tvArenaPower.text = "战斗力:${(holder.layoutPosition + 1) * 999}"
        }
    }
}