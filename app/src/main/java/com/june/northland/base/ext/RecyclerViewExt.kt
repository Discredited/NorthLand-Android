package com.june.northland.base.ext

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.R
import com.june.northland.common.LinearItemDecoration


fun RecyclerView.setLinearManager(
    orientation: Int = RecyclerView.VERTICAL,
    reverse: Boolean = false
) {
    layoutManager = LinearLayoutManager(context, orientation, reverse)
}

fun RecyclerView.setGridManager(
    spanCount: Int = 2,
    orientation: Int = RecyclerView.VERTICAL,
    reverse: Boolean = false
) {
    layoutManager = GridLayoutManager(context, spanCount, orientation, reverse)
}

fun RecyclerView.addLinearItemDecoration(
    color: Int = ContextCompat.getColor(context, R.color.color_transparent),
    marginStart: Int = 0,
    marginEnd: Int = 0,
    size: Int = resources.getDimensionPixelSize(R.dimen.dp_5),
    orientation: Int = RecyclerView.VERTICAL
) {
    addItemDecoration(
        LinearItemDecoration(
            color,
            marginStart,
            marginEnd,
            size,
            orientation
        )
    )
}