package com.june.northland.feature.dungeon.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import com.june.northland.R

/**
 * @author June
 * @description 评价
 * @version
 * @time 2020/7/29 16:48
 */
class EvaluateView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mActiveIconRes = R.drawable.ic_rating_yellow
    private var mNegativeIconRes = R.drawable.ic_rating_gray

    private var mActiveBitmap: Bitmap? = null
    private var mNegativeBitmap: Bitmap? = null

    private var mEvaluateProcess: Int = 0
    private var mEvaluateMax: Int = 3

    private var mEvaluateGap = 10

    init {
        mActiveBitmap = context.getDrawable(mActiveIconRes)?.let {
            it.toBitmap(it.intrinsicWidth, it.intrinsicHeight)
        }
        mNegativeBitmap = context.getDrawable(mNegativeIconRes)?.let {
            it.toBitmap(it.intrinsicWidth, it.intrinsicHeight)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val bitmapWidth = mActiveBitmap?.width ?: 0
        val bitmapHeight = mActiveBitmap?.height ?: 0
        val recommendWidth = (bitmapWidth + mEvaluateGap) * mEvaluateMax - mEvaluateGap + paddingStart + paddingEnd
        val recommendHeight = bitmapHeight + paddingTop + paddingBottom

        setMeasuredDimension(recommendWidth, recommendHeight)
    }

    override fun onDraw(canvas: Canvas) {
        for (index in 0 until 9) {
            val left = (((mActiveBitmap?.width ?: 0) + mEvaluateGap) * index).toFloat()

            val bitmap = if (index < mEvaluateProcess) {
                mActiveBitmap
            } else {
                mNegativeBitmap
            }
            bitmap?.let {
                canvas.drawBitmap(it, left, 0F, null)
            }
        }
    }

    override fun onDetachedFromWindow() {
        mActiveBitmap?.recycle()
        mNegativeBitmap?.recycle()
        super.onDetachedFromWindow()
    }
}