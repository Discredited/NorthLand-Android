package com.june.northland.feature.main.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.june.northland.R
import com.june.northland.base.ext.loadAvatar
import com.june.northland.common.FilePathHelper
import com.june.northland.utils.cache.UserDataCache
import kotlinx.android.synthetic.main.widget_player_section_layout.view.*

class PlayerSectionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_player_section_layout, this)
    }

    fun getAvatarView(): View? = ivAvatar

    fun setPlayerInfo() {
        ivAvatar.loadAvatar(FilePathHelper.getCharacterAvatar("gan_ning_zhen.png"))
        tvName.text = UserDataCache.getInstance().userName()
        tvCombatPower.text = "战力:1200万"
        tvFatigue.text = "体力:500"
        tvStamina.text = "战意:200"
        tvHerb.text = "999999"
        tvGold.text = "888888"
        vExperience.initExperience(5, 30, 100, 20)
    }
}