package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.june.northland.R

class BattleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_battle_view, this)
    }
}