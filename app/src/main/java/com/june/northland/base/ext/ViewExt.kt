package com.june.northland.base.ext

import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat
import com.june.northland.R

fun View.setDrawable(
    bgColor: Int = R.color.color_bg_alpha_black,
    strokeColor: Int = R.color.color_white,
    strokeWidth: Int = resources.getDimensionPixelSize(R.dimen.dp_5),
    cornerRadius: Float = resources.getDimension(R.dimen.dp_5)
) {
    val shapeDrawable = GradientDrawable()
    shapeDrawable.setColor(ContextCompat.getColor(context, bgColor))
    shapeDrawable.setStroke(
        strokeWidth,
        ContextCompat.getColor(context, strokeColor)
    )
    shapeDrawable.cornerRadius = cornerRadius
    background = shapeDrawable
}