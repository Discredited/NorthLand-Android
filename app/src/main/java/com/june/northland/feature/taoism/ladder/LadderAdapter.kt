package com.june.northland.feature.taoism.ladder

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_ladder.view.*

class LadderAdapter : BaseQuickAdapter<LadderVo, BaseViewHolder>(R.layout.item_ladder) {

    override fun convert(holder: BaseViewHolder, item: LadderVo) {
        holder.itemView.tvLadderRank.text = "${holder.layoutPosition + 1}"
        holder.itemView.ivLadderAvatar.setImageResource(R.drawable.ic_avatar_gan_ning_zhen)
        holder.itemView.tvLadderName.text = "甘柠真-${holder.layoutPosition + 1}"
        holder.itemView.tvLadderPower.text = "战斗力:${(holder.layoutPosition + 1) * 999}"
    }
}