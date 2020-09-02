package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.ext.loadImage
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.battle.vo.BattleVo
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.widget_battle_view.view.*

class BattleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_battle_view, this)
    }

    fun setBattleVo(
        battler: BattleVo,
        strokeWidth: Int = resources.getDimensionPixelSize(R.dimen.dp_2),
        radius: Float = resources.getDimension(R.dimen.dp_2)
    ) {
        val powerColor = ContextCompat.getColor(context, ColorUtils.getPowerColor(battler.power))
        ivAvatar.loadImage(battler.avatar)
        vHealthView.initHealth(battler.health, battler.health)
        tvPosition.text = battler.lineupPosition.toString()
        setDrawable(strokeColor = powerColor, strokeWidth = strokeWidth, cornerRadius = radius)
    }

    fun damage(damage: Int, isAnimator: Boolean = true) {
        vHealthView.damage(damage, isAnimator)
    }
}