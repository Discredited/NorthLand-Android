package com.june.northland.feature.main.ui

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.databinding.ItemMainScenesCharacterBinding
import com.june.northland.feature.character.CharacterVo
import com.june.northland.utils.ColorUtils

class ScenesCharacterAdapter :
    BaseQuickAdapter<CharacterVo, BaseDataBindingHolder<ItemMainScenesCharacterBinding>>(R.layout.item_main_scenes_character) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemMainScenesCharacterBinding>,
        item: CharacterVo
    ) {
        val realm = ColorUtils.getPowerColor(item.realm)
        val realmColor = ContextCompat.getColor(holder.itemView.context, realm)
        holder.dataBinding?.apply {
            ivCharacter.setDrawable(
                strokeColor = realmColor,
                strokeWidth = holder.itemView.resources.getDimensionPixelSize(R.dimen.dp_3)
            )
            ivCharacter.setImageResource(item.avatarIcon)
        }
    }
}