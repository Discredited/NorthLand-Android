package com.june.northland.feature.main.ui

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemMainScenesCharacterBinding
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadAvatar
import com.nl.component.ext.setDrawableWithStroke
import com.nl.module.characters.CharacterHelper
import com.nl.module.characters.CharacterVo

class ScenesCharacterAdapter :
    BaseQuickAdapter<CharacterVo, BaseDataBindingHolder<ItemMainScenesCharacterBinding>>(R.layout.item_main_scenes_character) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemMainScenesCharacterBinding>,
        item: CharacterVo
    ) {
        val realm = CharacterHelper.getRealmColor(item.realm)
        val realmColor = ContextCompat.getColor(holder.itemView.context, realm)
        holder.dataBinding?.apply {
            ivCharacter.setDrawableWithStroke(
                strokeColor = realmColor,
                strokeWidth = holder.itemView.resources.getDimensionPixelSize(R.dimen.dp_3)
            )
            ivCharacter.loadAvatar(FilePathHelper.getCharacterAvatar(item.avatar))
        }
    }
}