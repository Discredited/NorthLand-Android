package com.june.northland.feature.character.list

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.nl.component.ext.setDrawable
import com.june.northland.databinding.ItemCharacterBinding
import com.june.northland.feature.character.CharacterVo
import com.nl.component.common.ColorUtils

class CharacterListAdapter :
    BaseQuickAdapter<CharacterVo, BaseDataBindingHolder<ItemCharacterBinding>>(R.layout.item_character) {

    override fun convert(holder: BaseDataBindingHolder<ItemCharacterBinding>, item: CharacterVo) {
        val realm = holder.layoutPosition % 10
        val realmColor =
            ContextCompat.getColor(holder.itemView.context, com.nl.component.common.ColorUtils.getPowerColor(realm))
        holder.dataBinding?.apply {
            ivAvatar.setDrawable(strokeColor = realmColor)
            if (holder.layoutPosition < 6) {
                tvLineUp.text = "已上阵"
            } else {
                tvLineUp.text = ""
            }
            ivAvatar.setImageResource(item.avatarIcon)
            tvName.text = item.name
            tvName.setTextColor(realmColor)
            tvLevel.text = "Lv.${holder.layoutPosition}"
            tvHealth.text = "${holder.layoutPosition * 33}"
            tvSpeed.text = "${holder.layoutPosition * 3}"
            tvAttack.text = "${holder.layoutPosition * 23}"
            tvDefense.text = "${holder.layoutPosition * 13}"
        }
    }
}