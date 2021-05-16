package com.june.northland.feature.main.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.june.northland.R
import com.nl.component.ext.loadAvatar
import com.nl.component.common.FilePathHelper
import com.june.northland.databinding.WidgetPlayerSectionLayoutBinding
import com.june.northland.utils.cache.UserDataCache

class PlayerSectionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mBinding =
        WidgetPlayerSectionLayoutBinding.inflate(LayoutInflater.from(context), this)

    init {
        View.inflate(context, R.layout.widget_player_section_layout, this)
    }

    fun getAvatarView(): View = mBinding.ivAvatar

    fun setPlayerInfo() {
        mBinding.apply {
            ivAvatar.loadAvatar(com.nl.component.common.FilePathHelper.getCharacterAvatar("gan_ning_zhen.png"))
            tvName.text = UserDataCache.getInstance().userName()
            tvCombatPower.text = "战力:1200万"
            tvFatigue.text = "体力:500"
            tvStamina.text = "战意:200"
            tvHerb.text = "999999"
            tvGold.text = "888888"
            vExperience.initExperience(5, 30, 100, 20)
        }
    }
}