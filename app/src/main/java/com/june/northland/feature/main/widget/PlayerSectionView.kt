package com.june.northland.feature.main.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.june.northland.R
import kotlinx.android.synthetic.main.widget_player_section_layout.view.*

class PlayerSectionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_player_section_layout, this)
    }

    fun getAvatarView(): View? = ivAvatar

    fun setPlayerInfo() {
        ivAvatar.setImageResource(R.drawable.ic_avatar_gan_ning_zhen)
        tvName.text = "生命的长河是多迂回"
        tvLevel.text = "Lv.25"
        vExperience.max = 100
        vExperience.progress = 66

        tvHerb.text = "999999"
        tvGold.text = "888888"
    }
}