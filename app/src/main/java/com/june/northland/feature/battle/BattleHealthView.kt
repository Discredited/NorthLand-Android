package com.june.northland.feature.battle

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.june.northland.R

class BattleHealthView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mHealthMax: Int = 100
    private var mHealthValue: Int = 100
    private var mDamageValue: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    private var mHealthGravity: Int = 0
    private var mHealthColor = ContextCompat.getColor(context, R.color.color_red)
    private val mHealthPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPath = Path()
    private val mRectF = RectF()
    private var mHealthHeight: Int = 0

    private var mStatusColor = ContextCompat.getColor(context, R.color.color_bg_alpha_black)
    private val mStatusPath = Path()
    private val mStatusRectF = RectF()

    private var mDamageColor = ContextCompat.getColor(context, R.color.color_red_light)
    private val mDamagePath = Path()
    private val mDamageRectF = RectF()

    private var mStrokeWidth = resources.getDimension(R.dimen.dp_1)  //线框宽度
    private var mStrokeColor = ContextCompat.getColor(context, R.color.color_white)  //线框颜色
    private val mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mRadius = resources.getDimension(R.dimen.dp_5)

    private var mRectRadii: FloatArray

    private var mDamageAnimator: ObjectAnimator? = null

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.BattleHealthView, defStyleAttr, 0)
        try {
            mHealthGravity = array.getInt(R.styleable.BattleHealthView_battle_health_gravity, 0)
            mHealthMax = array.getInt(R.styleable.BattleHealthView_battle_health_max, mHealthMax)
            mHealthValue = array.getInt(R.styleable.BattleHealthView_battle_health_value, mHealthValue)

            mHealthColor = array.getColor(R.styleable.BattleHealthView_battle_health_color, mHealthColor)
            mDamageColor = array.getColor(R.styleable.BattleHealthView_battle_damage_color, mDamageColor)

            mStrokeWidth = array.getDimension(R.styleable.BattleHealthView_battle_stroke_width, mStrokeWidth)
            mStrokeColor = array.getColor(R.styleable.BattleHealthView_battle_stroke_color, mStrokeColor)

            mRadius = array.getDimension(R.styleable.BattleHealthView_battle_radius, mRadius)
        } finally {
            array.recycle()
        }

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
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        mHealthHeight = (mRadius * 2).toInt()
        val rectHeight = (mRadius * 2 + mStrokeWidth * 2).toInt() + paddingTop + paddingBottom
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(specWidth, rectHeight)
        } else {
            if (specHeight >= rectHeight) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            } else {
                setMeasuredDimension(specWidth, rectHeight)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //当需要绘制封闭的圆角图形时，建议使用arcTo!!!
        //mPath.addArc()
        //mPath.arcTo()

        val reactWidth = width - mStrokeWidth * 2 - paddingStart - paddingEnd
        val healthTop = when (mHealthGravity) {
            1 -> {
                //顶部
                paddingTop + mStrokeWidth
            }
            2 -> {
                //底部
                height - mStrokeWidth - mHealthHeight - paddingBottom
            }
            else -> {
                //居中
                (height + mHealthHeight) / 2F
            }
        }

        val radiusPercent = mRadius / reactWidth
        val healthPercent = mHealthValue.toFloat() / mHealthMax

        //生命条和背景框
        if (healthPercent > 0) {
            //绘制生命条线框
            mRectF.left = mStrokeWidth / 2 + paddingStart
            mRectF.top = healthTop - mStrokeWidth / 2
            mRectF.right = width - mStrokeWidth / 2 - paddingEnd
            mRectF.bottom = mRectF.top + mHealthHeight + mStrokeWidth
            canvas.drawRoundRect(mRectF, mRadius, mRadius, mStrokePaint)

            //绘制生命条
            mHealthPaint.color = mHealthColor
            mPath.reset()
            mRectF.left = mStrokeWidth + paddingStart
            mRectF.top = healthTop
            mRectF.right = mRectF.left + reactWidth * healthPercent + mStrokeWidth
            mRectF.bottom = mRectF.top + mHealthHeight

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
            mDamageRectF.left = mStrokeWidth + reactWidth * healthPercent + paddingStart
            mDamageRectF.top = healthTop
            mDamageRectF.right = mDamageRectF.left + reactWidth * damagePercent
            mDamageRectF.bottom = mDamageRectF.top + mHealthHeight

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
            mHealthPaint.color = mHealthColor
            canvas.drawPath(mDamagePath, mHealthPaint)
        }

        //绘制状态
        if (healthPercent < 1F) {
            mStatusPath.reset()

            mStatusRectF.left = 0F
            mStatusRectF.top = 0F
            mStatusRectF.right = width.toFloat()
            mStatusRectF.bottom = height * (1 - healthPercent)

            mRectRadii[0] = mRadius
            mRectRadii[1] = mRadius
            mRectRadii[2] = mRadius
            mRectRadii[3] = mRadius

            if (healthPercent > radiusPercent) {
                mRectRadii[4] = 0F
                mRectRadii[5] = 0F
                mRectRadii[6] = 0F
                mRectRadii[7] = 0F
            } else {
                mRectRadii[4] = mRadius
                mRectRadii[5] = mRadius
                mRectRadii[6] = mRadius
                mRectRadii[7] = mRadius
            }

            mHealthPaint.color = mStatusColor
            mStatusPath.addRoundRect(mStatusRectF, mRectRadii, Path.Direction.CW)
            canvas.drawPath(mStatusPath, mHealthPaint)

            if (healthPercent <= 0F) {
                mHealthPaint.textSize = height / 2F
                mHealthPaint.color = Color.WHITE
                val textWidth = mHealthPaint.measureText("K.O")
                val textX = (width - textWidth) / 2F
                val textY =
                    (height + mHealthPaint.descent() - mHealthPaint.ascent()) / 2F - mHealthPaint.fontMetrics.ascent + mHealthPaint.fontMetrics.top
                canvas.drawText("K.O", textX, textY, mHealthPaint)
            }
        }
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