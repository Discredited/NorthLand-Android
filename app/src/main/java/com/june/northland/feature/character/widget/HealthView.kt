package com.june.northland.feature.character.widget

import android.animation.ObjectAnimator
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
    private var mHealthValue: Int = 950
    private var mDamageValue: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    private var mHealthColor = ContextCompat.getColor(context, R.color.color_red)
    private var mDamageColor = ContextCompat.getColor(context, R.color.color_red_light)
    private val mHealthPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mStrokeWidth = resources.getDimension(R.dimen.dp_2)  //线框宽度
    private var mStrokeColor = ContextCompat.getColor(context, R.color.color_white)  //线框颜色
    private val mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mRadius = resources.getDimension(R.dimen.dp_10)

    private val mPath = Path()
    private val mRectF = RectF()

    private val mDamagePath = Path()
    private val mDamageRectF = RectF()

    private lateinit var mRectRadii: FloatArray

    private var mDamageAnimator: ObjectAnimator? = null

    init {
        //mHealthPaint.style = Paint.Style.STROKE
        //mHealthPaint.strokeWidth = resources.getDimension(R.dimen.dp_5)
        mHealthPaint.color = mHealthColor

        mStrokePaint.style = Paint.Style.STROKE
        mStrokePaint.strokeWidth = mStrokeWidth
        mStrokePaint.color = mStrokeColor

        mRectRadii = floatArrayOf(
            mRadius, mRadius,
            mRadius, mRadius,
            mRadius, mRadius,
            mRadius, mRadius
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //当需要绘制封闭的圆角图形时，建议使用arcTo!!!
        //mPath.addArc()
        //mPath.arcTo()

        val reactWidth = width - mStrokeWidth * 2

        //绘制生命条
        val radiusPercent = mRadius / reactWidth
        val healthPercent = mHealthValue.toFloat() / mHealthMax
        if (healthPercent > 0) {
            mHealthPaint.color = mHealthColor
            mPath.reset()
            mRectF.left = mStrokeWidth
            mRectF.top = mStrokeWidth
            mRectF.right = mRectF.left + reactWidth * healthPercent
            mRectF.bottom = height - mStrokeWidth

            mRectRadii[0] = mRadius
            mRectRadii[1] = mRadius
            mRectRadii[6] = mRadius
            mRectRadii[7] = mRadius

            if (healthPercent < (1F - radiusPercent)) {
                mRectRadii[2] = 0F
                mRectRadii[3] = 0F
                mRectRadii[4] = 0F
                mRectRadii[5] = 0F
            } else {
                mRectRadii[2] = mRadius
                mRectRadii[3] = mRadius
                mRectRadii[4] = mRadius
                mRectRadii[5] = mRadius
            }
            mPath.addRoundRect(mRectF, mRectRadii, Path.Direction.CW)
            canvas.drawPath(mPath, mHealthPaint)
        }

        //绘制伤害条
        if (mDamageValue > 0) {
            mHealthPaint.color = mDamageColor
            val damagePercent = mDamageValue.toFloat() / mHealthMax
            val totalPercent = damagePercent + healthPercent

            mDamagePath.reset()
            mDamageRectF.left = mStrokeWidth + reactWidth * healthPercent
            mDamageRectF.top = mStrokeWidth
            mDamageRectF.right = mDamageRectF.left + reactWidth * damagePercent
            mDamageRectF.bottom = height - mStrokeWidth

            if (healthPercent > radiusPercent) {
                mRectRadii[0] = 0F
                mRectRadii[1] = 0F
                mRectRadii[6] = 0F
                mRectRadii[7] = 0F
            } else {
                mRectRadii[0] = mRadius
                mRectRadii[1] = mRadius
                mRectRadii[6] = mRadius
                mRectRadii[7] = mRadius
            }

            if (totalPercent < (1F - radiusPercent)) {
                mRectRadii[2] = 0F
                mRectRadii[3] = 0F
                mRectRadii[4] = 0F
                mRectRadii[5] = 0F
            } else {
                mRectRadii[2] = mRadius
                mRectRadii[3] = mRadius
                mRectRadii[4] = mRadius
                mRectRadii[5] = mRadius
            }

            mDamagePath.addRoundRect(mDamageRectF, mRectRadii, Path.Direction.CW)
            canvas.drawPath(mDamagePath, mHealthPaint)
        }

        mRectF.left = mStrokeWidth / 2
        mRectF.top = mStrokeWidth / 2
        mRectF.right = width - mStrokeWidth / 2
        mRectF.bottom = height - mStrokeWidth / 2
        canvas.drawRoundRect(mRectF, mRadius, mRadius, mStrokePaint)
    }

    fun damage(reduceHealth: Int, damageAnimator: Boolean = true) {
        val damagePercent = reduceHealth.toFloat() / mHealthMax
        mDamageValue = if (damageAnimator && damagePercent > 0.3F) {
            reduceHealth
        } else {
            0
        }
        if (mHealthValue > reduceHealth) {
            mHealthValue -= reduceHealth
        } else {
            mDamageValue = mHealthValue
            mHealthValue = 0
        }

        if (mDamageValue > 0) {
            mDamageAnimator = ObjectAnimator.ofInt(
                this,
                "mDamageValue",
                mDamageValue,
                0
            )
            mDamageAnimator?.duration = 1000L
            mDamageAnimator?.start()
        } else {
            invalidate()
        }
    }

    fun restore(addHealth: Int) {
        mHealthValue += addHealth
        if (mHealthValue > mHealthMax) {
            mHealthValue = mHealthMax
        }
        invalidate()
    }
}