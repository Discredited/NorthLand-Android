package com.nl.component.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class SquareFrameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        const val FIX_TYPE_NONE = 0
        const val FIX_TYPE_SQUARE = 1
        const val FIX_MODE_WIDTH = 0
        const val FIX_MODE_HEIGHT = 1
    }

    //修饰类型
    //FIX_TYPE_NONE 不修饰
    //FIX_TYPE_SQUARE 正方形修饰
    private var fixType = FIX_TYPE_SQUARE

    //修饰模式
    //FIX_MODE_WIDTH  以宽定高
    //FIX_MODE_HEIGHT  已高定宽
    private var fixMode = FIX_MODE_WIDTH

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (fixType == FIX_TYPE_NONE) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        } else {
            if (fixMode == FIX_MODE_HEIGHT) {
                super.onMeasure(heightMeasureSpec, heightMeasureSpec)
            } else {
                super.onMeasure(widthMeasureSpec, widthMeasureSpec)
            }
        }
    }
}