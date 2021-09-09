package com.nl.module.characters.list

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.common.ColorUtils
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadAvatar
import com.nl.component.ext.setDrawable
import com.nl.module.characters.CharacterVo
import com.nl.module.characters.R
import com.nl.module.characters.databinding.ItemCharacterBinding

class CharacterListAdapter :
    BaseQuickAdapter<CharacterVo, BaseDataBindingHolder<ItemCharacterBinding>>(R.layout.item_character) {

    override fun convert(holder: BaseDataBindingHolder<ItemCharacterBinding>, item: CharacterVo) {
        val realm = holder.layoutPosition % 10
        val realmColor = ContextCompat.getColor(
            holder.itemView.context,
            ColorUtils.getPowerColor(realm)
        )
        holder.dataBinding?.apply {
            ivAvatar.setDrawable(strokeColor = realmColor)
            if (holder.layoutPosition < 6) {
                tvLineUp.text = "已上阵"
            } else {
                tvLineUp.text = ""
            }
            ivAvatar.loadAvatar(FilePathHelper.getCharacterAvatar(item.avatar))
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