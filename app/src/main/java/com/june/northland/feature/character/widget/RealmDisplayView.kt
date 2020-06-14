package com.june.northland.feature.character.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import com.june.northland.R

class RealmDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mActiveDrawable: Bitmap? = null
    private var mNegativeDrawable: Bitmap? = null
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mRealm: Int = 8
    private var mRealmName: String = "身态"


    private val mRect = Rect()

    init {
        mActiveDrawable = context.getDrawable(R.drawable.ic_rating_yellow)?.let {
            it.toBitmap(it.intrinsicWidth, it.intrinsicHeight)
        }
        mNegativeDrawable = context.getDrawable(R.drawable.ic_rating_gray)?.let {
            it.toBitmap(it.intrinsicWidth, it.intrinsicHeight)
        }

        textPaint.color = Color.parseColor("#FF7700")
        textPaint.textSize = resources.getDimension(R.dimen.sp_20)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //文字绘制
        val textWidth = textPaint.measureText(mRealmName)
        val textX = 0F
        val textY =
            (height + textPaint.descent() - textPaint.ascent()) / 2F
        canvas.drawText(mRealmName, textX, textY, textPaint)
        //图标绘制
        var left = textWidth
        val top = (height - (mActiveDrawable?.height ?: 0)) / 2F

        for (index in 0 until 9) {
            left += (mActiveDrawable?.width ?: 0) + 20F

            val bitmap = if (index < mRealm) {
                mActiveDrawable
            } else {
                mNegativeDrawable
            }
            bitmap?.let {
                canvas.drawBitmap(it, left, top, null)
            }
        }
    }

    override fun onDetachedFromWindow() {
        mActiveDrawable = null
        mNegativeDrawable = null
        super.onDetachedFromWindow()
    }
}