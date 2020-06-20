package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.june.northland.R
import kotlinx.android.synthetic.main.widget_battle_view.view.*

class BattleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_battle_view, this)
    }

    fun setPosition(position: Int) {
        tvPosition.text = position.toString()
    }

    fun damage(damage: Int, isAnimator: Boolean = true) {
        vHealthView.damage(damage, isAnimator)
    }
}