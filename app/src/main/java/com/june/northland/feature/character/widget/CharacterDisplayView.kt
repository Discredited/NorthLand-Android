package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.character.CharacterVo
import kotlinx.android.synthetic.main.widget_character_display_layout.view.*

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_character_display_layout, this)
    }

    fun setCharacterAndWeapon(realmColor: Int, character: CharacterVo?) {
        ivCharacterAvatar?.setDrawable(strokeColor = realmColor)
    }
}