package com.june.northland.feature.main.ui

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.character.CharacterVo
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.item_main_scenes_character.view.*

class ScenesCharacterAdapter :
    BaseQuickAdapter<CharacterVo, BaseViewHolder>(R.layout.item_main_scenes_character) {

    override fun convert(holder: BaseViewHolder, item: CharacterVo) {
        val realm = ColorUtils.getRealmColor((holder.layoutPosition + 1) % 9)
        val realmColor = ContextCompat.getColor(holder.itemView.context, realm)
        holder.itemView.ivCharacter.setDrawable(
            strokeColor = realmColor,
            strokeWidth = holder.itemView.resources.getDimensionPixelSize(R.dimen.dp_3)
        )
        holder.itemView.ivCharacter.setImageResource(R.drawable.ic_avatar_gan_ning_zhen)
    }
}