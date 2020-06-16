package com.june.northland.feature.character.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.june.northland.R

class ExperienceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mExperienceProgress: Long = 30L  //当前经验值
    private var mExperienceMax: Long = 100L  //最大经验值
    private var mExperienceSeparator = "/"  //经验值分割字符

    private var mRectRadius = resources.getDimension(R.dimen.dp_5)  //圆角
    private var mMaxColor = ContextCompat.getColor(context, R.color.color_purple)  //底部颜色
    private var mProgressColor = ContextCompat.getColor(context, R.color.color_pink)  //progress颜色
    private var mRectPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mTextColor: Int = ContextCompat.getColor(context, R.color.color_white)  //经验值文本颜色
    private var mTextSize: Float = resources.getDimension(R.dimen.sp_12)  //经验值文本大小

    private val mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var isStrokeShow = true  //是否显示线框
    private var mStrokeWith = resources.getDimension(R.dimen.dp_2)  //线框宽度
    private var mStrokeColor = ContextCompat.getColor(context, R.color.color_white)  //线框颜色

    init {
        mTextPaint.style = Paint.Style.FILL
        mTextPaint.textSize = mTextSize
        mTextPaint.color = mTextColor

        mStrokePaint.style = Paint.Style.STROKE
        mStrokePaint.strokeWidth = mStrokeWith
        mStrokePaint.color = mStrokeColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val textWith = mTextPaint.measureText(
            "$mExperienceProgress$mExperienceSeparator$mExperienceMax"
        )
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        val recommendWith = specWidth.coerceAtLeast(textWith.toInt()) + paddingStart + paddingEnd
        val recommendHeight =
            specHeight.coerceAtLeast(mTextPaint.textSize.toInt()) + paddingTop + paddingBottom
        setMeasuredDimension(recommendWith, recommendHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var rectWidth = width.toFloat()
        var rectHeight = height.toFloat()
        var rectLeft = 0F
        var rectTop = 0F
        var rectRight = rectWidth
        var rectBottom = rectHeight
        if (isStrokeShow) {
            val strokeGap = mStrokeWith / 2
            val strokeDouble = mStrokeWith * 2

            rectWidth = width.toFloat() - strokeDouble
            rectHeight = height.toFloat() - strokeDouble
            rectLeft = mStrokeWith
            rectTop = mStrokeWith
            rectRight = rectLeft + rectWidth
            rectBottom = rectTop + rectHeight

            //绘制线框
            canvas.drawRoundRect(
                strokeGap,
                strokeGap,
                width.toFloat() - strokeGap,
                height.toFloat() - strokeGap,
                mRectRadius,
                mRectRadius,
                mStrokePaint
            )
        }

        //绘制背景
        mRectPaint.color = mMaxColor
        canvas.drawRoundRect(
            rectLeft,
            rectTop,
            rectRight,
            rectBottom,
            mRectRadius,
            mRectRadius,
            mRectPaint
        )
        //绘制progress
        var percent = (mExperienceProgress.toFloat() / mExperienceMax)
        if (percent > 1F) {
            percent = 1F
        }
        val progressWidth = percent * rectWidth + mStrokeWith
        mRectPaint.color = mProgressColor
        canvas.drawRoundRect(
            rectLeft,
            rectTop,
            progressWidth,
            rectBottom,
            mRectRadius,
            mRectRadius,
            mRectPaint
        )

        //绘制文本
        val text = "$mExperienceProgress$mExperienceSeparator$mExperienceMax"
        val textWidth = mTextPaint.measureText(text)
        val textX = if (progressWidth - textWidth >= 20) {
            progressWidth - textWidth - 10
        } else {
            rectLeft + 10

        }
        val textY =
            (height + (mTextPaint.descent() - mTextPaint.ascent())) / 2F - (mTextPaint.fontMetrics.ascent - mTextPaint.fontMetrics.top)
        canvas.drawText(text, textX, textY, mTextPaint)
    }

    fun getProgress(): Long = mExperienceProgress

    fun setProgress(progress: Long, max: Long = mExperienceMax) {
        mExperienceProgress = if (progress < 0L) {
            0L
        } else {
            progress
        }

        mExperienceMax = max
        invalidate()
    }
}