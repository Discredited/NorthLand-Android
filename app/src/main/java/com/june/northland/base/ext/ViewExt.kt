package com.june.northland.base.ext

import android.graphics.drawable.GradientDrawable
import android.os.SystemClock
import android.view.View
import androidx.core.content.ContextCompat
import com.june.northland.R

inline fun View.click(debounceTime: Long = 500, crossinline block: (View) -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {

        private var lastClickTime: Long = 0

        override fun onClick(v: View) {

            if (debounceTime == 0.toLong()) {
                block(v)
                return
            }

            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else block(v)
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun View.setDrawable(
    bgColor: Int = ContextCompat.getColor(context, R.color.color_transparent),
    strokeColor: Int = ContextCompat.getColor(context, R.color.color_white),
    strokeWidth: Int = resources.getDimensionPixelSize(R.dimen.dp_5),
    cornerRadius: Float = resources.getDimension(R.dimen.dp_5)
) {
    val shapeDrawable = GradientDrawable()
    shapeDrawable.setColor(bgColor)
    shapeDrawable.setStroke(strokeWidth, strokeColor)
    shapeDrawable.cornerRadius = cornerRadius
    background = shapeDrawable
}