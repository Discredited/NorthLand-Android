package com.june.northland.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.june.northland.R

class ShadowTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        setShadowLayer(10F, 5F, 5F, ContextCompat.getColor(context, R.color.color_black))
    }
}