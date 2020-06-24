package com.june.northland.feature.character

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterListAdapter : BaseQuickAdapter<CharacterVo, BaseViewHolder>(R.layout.item_character) {
    override fun convert(holder: BaseViewHolder, item: CharacterVo) {
        val realm = holder.layoutPosition % 9
        holder.itemView.ivAvatar.setDrawable(
            strokeColor = ContextCompat.getColor(
                holder.itemView.context,
                ColorUtils.getRealmColor(realm)
            )
        )
        if (holder.layoutPosition < 8) {
            holder.itemView.tvLineUp.text = "已上阵"
        } else {
            holder.itemView.tvLineUp.text = ""
        }

        holder.itemView.ivAvatar.setImageResource(item.avatarIcon)
        holder.itemView.tvName.text = item.name
        holder.itemView.tvLevel.text = "Lv.${holder.layoutPosition}"
        holder.itemView.tvHealth.text = "${holder.layoutPosition * 33}"
        holder.itemView.tvSpeed.text = "${holder.layoutPosition * 3}"
        holder.itemView.tvAttack.text = "${holder.layoutPosition * 23}"
        holder.itemView.tvDefense.text = "${holder.layoutPosition * 13}"
    }
}