package com.june.northland.feature.character.magic

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_magic_display.view.*

class MagicDisplayAdapter : BaseQuickAdapter<MagicVo, BaseViewHolder>(R.layout.item_magic_display) {

    override fun convert(holder: BaseViewHolder, item: MagicVo) {
        holder.itemView.ivMagicIcon.setImageResource(item.icon)
        holder.itemView.tvMagicName.text = context.getString(
            R.string.str_skill_name_and_level,
            item.name,
            item.level.toString()
        )
        //holder.itemView.tvMagicDesc.text = item.desc
    }
}