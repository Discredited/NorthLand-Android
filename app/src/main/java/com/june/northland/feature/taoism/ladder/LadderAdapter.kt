package com.june.northland.feature.taoism.ladder

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemLadderBinding

class LadderAdapter :
    BaseQuickAdapter<LadderVo, BaseDataBindingHolder<ItemLadderBinding>>(R.layout.item_ladder) {

    override fun convert(holder: BaseDataBindingHolder<ItemLadderBinding>, item: LadderVo) {
        holder.dataBinding?.apply {
            tvLadderRank.text = "${holder.layoutPosition + 1}"
            ivLadderAvatar.setImageResource(R.drawable.ic_avatar_gan_ning_zhen)
            tvLadderName.text = "甘柠真-${holder.layoutPosition + 1}"
            tvLadderPower.text = "战斗力:${(holder.layoutPosition + 1) * 999}"
        }
    }
}