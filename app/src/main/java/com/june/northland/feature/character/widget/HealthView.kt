package com.june.northland.feature.character.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.june.northland.R

class HealthView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mHealthMax: Int = 1000
    private var mHealthValue: Int = 1000

    private var mHealthColor = ContextCompat.getColor(context, R.color.color_red)
    private var mDamageColor = ContextCompat.getColor(context, R.color.color_red_light)
    private val mHealthPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mStrokeWidth = resources.getDimension(R.dimen.dp_2)  //线框宽度
    private var mStrokeColor = ContextCompat.getColor(context, R.color.color_white)  //线框颜色
    private val mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mRadius = resources.getDimension(R.dimen.dp_10)

    private val mRectF = RectF()
    private val mPath = Path()

    init {
        //mHealthPaint.style = Paint.Style.STROKE
        //mHealthPaint.strokeWidth = resources.getDimension(R.dimen.dp_5)
        mHealthPaint.color = mHealthColor

        mStrokePaint.style = Paint.Style.STROKE
        mStrokePaint.strokeWidth = mStrokeWidth
        mStrokePaint.color = mStrokeColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //当需要绘制封闭的圆角图形时，建议使用arcTo!!!
        //mPath.addArc()
        //mPath.arcTo()

        val pathX = mStrokeWidth + mRadius
        val rectX = mStrokeWidth + mRadius * 2
        val pathY = mStrokeWidth
        mPath.moveTo(pathX, pathY)
        mPath.lineTo(width - pathX, pathY)
        mPath.arcTo(
            width - rectX,
            pathY,
            width - mStrokeWidth,
            pathY + mRadius * 2,
            -90F,
            90F,
            false
        )
        mPath.lineTo(width - mStrokeWidth, height - mStrokeWidth - mRadius)
        mPath.arcTo(
            width - mStrokeWidth - mRadius * 2,
            height - mStrokeWidth - mRadius * 2,
            width - mStrokeWidth,
            height - mStrokeWidth,
            0F,
            90F,
            false
        )
        mPath.lineTo(mStrokeWidth + mRadius, height - mStrokeWidth)
        mPath.arcTo(
            mStrokeWidth,
            height - mStrokeWidth - mRadius * 2,
            mStrokeWidth + mRadius * 2,
            height - mStrokeWidth,
            90F,
            90F,
            false
        )
        mPath.lineTo(mStrokeWidth, mStrokeWidth + mRadius)
        mPath.arcTo(
            mStrokeWidth,
            mStrokeWidth,
            mStrokeWidth + mRadius * 2,
            mStrokeWidth + mRadius * 2,
            180F,
            90F,
            false
        )
        //mPath.close()
        canvas.drawPath(mPath, mHealthPaint)

//        mRectF.left = mStrokeWidth / 2
//        mRectF.top = mStrokeWidth / 2
//        mRectF.right = width - mStrokeWidth / 2
//        mRectF.bottom = height - mStrokeWidth / 2
//        canvas.drawRoundRect(mRectF, mRadius, mRadius, mStrokePaint)
    }
}