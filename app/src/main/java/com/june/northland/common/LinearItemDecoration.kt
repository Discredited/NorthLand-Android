package com.june.northland.common

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class LinearItemDecoration(
    var mDivider: Drawable,
    var mOrientation: Int = RecyclerView.VERTICAL,
    var mMarginStart: Int = 0,
    var mMarginEnd: Int = 0
) : RecyclerView.ItemDecoration() {

    private val mBounds: Rect = Rect()

    constructor(
        color: Int,
        marginStart: Int = 0,
        marginEnd: Int = 0,
        size: Int = 1,
        orientation: Int = RecyclerView.VERTICAL
    ) : this(ShapeDrawable(), orientation, marginStart, marginEnd) {
        if (mDivider is ShapeDrawable) {
            val shapeDrawable = mDivider as ShapeDrawable
            shapeDrawable.paint.color = color
            shapeDrawable.intrinsicWidth = size
            shapeDrawable.intrinsicHeight = size
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.layoutManager == null) {
            return
        }
        if (mOrientation == RecyclerView.VERTICAL) {
            drawVertical(c, parent)
        } else {
            drawHorizontal(c, parent)
        }
    }

    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        canvas.save()
        val left: Int
        val right: Int

        if (parent.clipToPadding) {
            left = parent.paddingLeft + mMarginStart
            right = parent.width - parent.paddingRight - mMarginEnd
            canvas.clipRect(
                left, parent.paddingTop, right,
                parent.height - parent.paddingBottom
            )
        } else {
            left = mMarginStart
            right = parent.width - mMarginEnd
        }

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val childPosition = parent.getChildAdapterPosition(child)
            val itemCount = (parent.adapter?.itemCount ?: 0) - 1
            //最后一条不绘制
            if (itemCount == -1 || childPosition < itemCount) {
                parent.layoutManager?.getDecoratedBoundsWithMargins(child, mBounds)
                val bottom = mBounds.bottom + child.translationY.roundToInt()
                val top = bottom - mDivider.intrinsicHeight
                mDivider.setBounds(left, top, right, bottom)
                mDivider.draw(canvas)
            }
        }
        canvas.restore()
    }

    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        canvas.save()
        val top: Int
        val bottom: Int

        if (parent.clipToPadding) {
            top = parent.paddingTop
            bottom = parent.height - parent.paddingBottom
            canvas.clipRect(
                parent.paddingLeft, top,
                parent.width - parent.paddingRight, bottom
            )
        } else {
            top = 0
            bottom = parent.height
        }

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val childPosition = parent.getChildAdapterPosition(child)
            val itemCount = (parent.adapter?.itemCount ?: 0) - 1
            //最后一条不绘制
            if (itemCount == -1 || childPosition < itemCount) {
                parent.layoutManager?.getDecoratedBoundsWithMargins(child, mBounds)
                val right = mBounds.right + child.translationX.roundToInt()
                val left = right - mDivider.intrinsicWidth
                mDivider.setBounds(left, top, right, bottom)
                mDivider.draw(canvas)
            }
        }
        canvas.restore()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //最后一个位置不绘制
        val childPosition = parent.getChildLayoutPosition(view)
        val itemCount = (parent.adapter?.itemCount ?: 0) - 1
        if (childPosition == itemCount) {
            return
        }

        if (mOrientation == RecyclerView.VERTICAL) {
            //VERTICAL 只绘制高度
            outRect.set(0, 0, 0, mDivider.intrinsicHeight)
        } else {
            //HORIZONTAL top为start  bottom为end
            outRect.set(0, 0, mDivider.intrinsicWidth, 0)
        }
    }
}