package com.june.northland.feature.taoism.arena

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_arena.view.*

class ArenaAdapter : BaseQuickAdapter<ArenaVo, BaseViewHolder>(R.layout.item_arena) {

    override fun convert(holder: BaseViewHolder, item: ArenaVo) {
        holder.itemView.tvArenaRank.text = "${holder.layoutPosition + 1}"
        holder.itemView.ivArenaAvatar.setImageResource(R.drawable.ic_avatar_gan_ning_zhen)
        holder.itemView.tvArenaName.text = "甘柠真-${holder.layoutPosition + 1}"
        holder.itemView.tvArenaPower.text = "战斗力:${(holder.layoutPosition + 1) * 999}"
    }
}