package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.nl.component.ext.loadImage
import com.nl.component.ext.setDrawable
import com.june.northland.databinding.WidgetBattleViewBinding
import com.june.northland.feature.battle.vo.BattleVo
import com.nl.component.common.ColorUtils

class BattleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mBinding: WidgetBattleViewBinding =
        WidgetBattleViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        View.inflate(context, R.layout.widget_battle_view, this)
    }

    fun setBattleVo(
        battler: BattleVo,
        strokeWidth: Int = resources.getDimensionPixelSize(R.dimen.dp_2),
        radius: Float = resources.getDimension(R.dimen.dp_2)
    ) {
        val powerColor = ContextCompat.getColor(context, com.nl.component.common.ColorUtils.getPowerColor(battler.power))
        mBinding.ivAvatar.loadImage(battler.avatar)
        mBinding.vHealthView.initHealth(battler.health, battler.health)
        mBinding.tvPosition.text = battler.lineupPosition.toString()
        setDrawable(strokeColor = powerColor, strokeWidth = strokeWidth, cornerRadius = radius)
    }

    fun damage(damage: Int, damageType: Int, isAnimator: Boolean = true) {
        mBinding.vHealthView.damage(damage, damageType, isAnimator)
    }
}