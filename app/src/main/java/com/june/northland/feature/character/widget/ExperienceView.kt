package com.june.northland.feature.character.widget

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.core.content.ContextCompat
import com.june.northland.R


class ExperienceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mExperienceProgress: Int = 0  //当前经验值
        set(value) {
            field = value
            invalidate()
        }
    private var mExperienceMax: Int = 100  //最大经验值
    private var mExperienceSeparator = "/"  //经验值分割字符
    private var mExperienceOverflow: Int = 0 //溢出的经验值
    private var mExperienceFactor: Int = 0

    private var mExperiencePercent: Float = 1F
    private var mExperienceHeight: Float = resources.getDimension(R.dimen.dp_30)
    private var mExperienceGravity: Int = 0  //0-center 1-top 2-bottom

    private var mLevelTag = "Lv."
    private var mLevel = 0

    private var mLevelGap = resources.getDimension(R.dimen.dp_10)
    private var mExpGap = resources.getDimension(R.dimen.dp_5)

    private var mMaxColor = ContextCompat.getColor(context, R.color.color_purple)  //底部颜色
    private var mProgressColor = ContextCompat.getColor(context, R.color.color_pink)  //progress颜色
    private var mRectPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mLevelTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mLevelTextColor: Int = ContextCompat.getColor(context, R.color.color_white)
    private var mLevelTextSize: Float = resources.getDimension(R.dimen.sp_20)
    private val mExpTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mExpTextColor: Int = ContextCompat.getColor(context, R.color.color_white)  //经验值文本颜色
    private var mExpTextSize: Float = resources.getDimension(R.dimen.sp_12)  //经验值文本大小

    private var isStrokeShow = true  //是否显示线框
    private var mStrokeWidth = resources.getDimension(R.dimen.dp_2)  //线框宽度
    private var mStrokeColor = ContextCompat.getColor(context, R.color.color_white)  //线框颜色
    private val mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mRectF = RectF()
    private var mRectRadius = resources.getDimension(R.dimen.dp_5)  //圆角

    private var mAnimatorDuration: Int = 1000

    init {
        val attribute =
            context.obtainStyledAttributes(attrs, R.styleable.ExperienceView, defStyleAttr, 0)
        try {
            mExperienceProgress = attribute.getInt(R.styleable.ExperienceView_exp_progress, 0)
            mExperienceMax = attribute.getInt(R.styleable.ExperienceView_exp_max, mExperienceMax)

            mProgressColor =
                attribute.getColor(R.styleable.ExperienceView_exp_progress_color, mProgressColor)
            mMaxColor = attribute.getColor(R.styleable.ExperienceView_exp_max_color, mMaxColor)
            mLevelTextColor =
                attribute.getColor(R.styleable.ExperienceView_exp_level_color, mLevelTextColor)
            mExpTextColor =
                attribute.getColor(R.styleable.ExperienceView_exp_text_color, mExpTextColor)
            mStrokeColor =
                attribute.getColor(R.styleable.ExperienceView_exp_stroke_color, mStrokeColor)

            mExperienceSeparator =
                attribute.getString(R.styleable.ExperienceView_exp_separator) ?: "/"
            mLevelTag = attribute.getString(R.styleable.ExperienceView_exp_level_tag) ?: "Lv."

            mLevelGap = attribute.getDimension(R.styleable.ExperienceView_exp_level_gap, mLevelGap)
            mExpGap = attribute.getDimension(R.styleable.ExperienceView_exp_gap, mExpGap)
            mLevelTextSize =
                attribute.getDimension(R.styleable.ExperienceView_exp_level_size, mLevelTextSize)
            mExpTextSize =
                attribute.getDimension(R.styleable.ExperienceView_exp_text_size, mExpTextSize)
            mStrokeWidth =
                attribute.getDimension(R.styleable.ExperienceView_exp_stroke_width, mStrokeWidth)

            mExperiencePercent =
                attribute.getFloat(R.styleable.ExperienceView_exp_rect_percent, mExperiencePercent)
            mExperienceGravity =
                attribute.getInt(R.styleable.ExperienceView_exp_rect_gravity, mExperienceGravity)
            isStrokeShow =
                attribute.getBoolean(R.styleable.ExperienceView_exp_stroke_show, isStrokeShow)
            mRectRadius = attribute.getDimension(R.styleable.ExperienceView_exp_radius, mRectRadius)

            mAnimatorDuration = attribute.getInt(
                R.styleable.ExperienceView_exp_animator_duration,
                mAnimatorDuration
            )
        } finally {
            attribute.recycle()
        }

        if (mExperiencePercent > 1F || mExperiencePercent <= 0) {
            mExperiencePercent = 1F
        }

        mLevelTextPaint.style = Paint.Style.FILL
        mLevelTextPaint.color = mLevelTextColor
        mLevelTextPaint.textSize = mLevelTextSize

        mExpTextPaint.style = Paint.Style.FILL
        mExpTextPaint.color = mExpTextColor
        mExpTextPaint.textSize = mExpTextSize

        mStrokePaint.style = Paint.Style.STROKE
        mStrokePaint.strokeWidth = mStrokeWidth
        mStrokePaint.color = mStrokeColor
    }

    // 创建 ObjectAnimator 对象
    private var mProgressAnimator: ObjectAnimator? = null

    private fun getRecommendW(widthMeasureSpec: Int): Int {
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val levelTextWidth = mLevelTextPaint.measureText("$mLevelTag$mLevel")
        val expTextWith =
            mExpTextPaint.measureText("$mExperienceProgress$mExperienceSeparator$mExperienceMax")
        val width =
            (levelTextWidth + mLevelGap).toInt() + specWidth.coerceAtLeast(expTextWith.toInt())
        return width + paddingStart + paddingEnd
    }

    private fun getRecommendH(heightMeasureSpec: Int): Int {
        val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        val specMode = MeasureSpec.getMode(heightMeasureSpec)
        val maxTextHeight = mLevelTextPaint.textSize.coerceAtLeast(mExpTextPaint.textSize)
        val maxHeight = mExperienceHeight.coerceAtLeast(maxTextHeight).toInt()
        return if (specMode == MeasureSpec.AT_MOST) {
            maxHeight.coerceAtMost(specHeight) + paddingTop + paddingBottom
        } else {
            maxHeight.coerceAtLeast(specHeight) + paddingTop + paddingBottom
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val recommendWith = getRecommendW(widthMeasureSpec)
        val recommendHeight = getRecommendH(heightMeasureSpec)
        mExperienceHeight = recommendHeight * mExperiencePercent
        setMeasuredDimension(recommendWith, recommendHeight)
    }


    private fun setStrokeRectF(levelTotalWidth: Float) {
        val strokeGap = mStrokeWidth / 2
        val top = when (mExperienceGravity) {
            //顶部
            1 -> strokeGap
            //底部
            2 -> height - mExperienceHeight + strokeGap
            //居中
            else -> (height - mExperienceHeight + mStrokeWidth) / 2
        }
        val bottom = when (mExperienceGravity) {
            //顶部显示
            1 -> mExperienceHeight - strokeGap
            //底部显示
            2 -> height - mStrokeWidth + strokeGap
            //居中显示
            else -> (height + mExperienceHeight - mStrokeWidth) / 2
        }

        mRectF.left = levelTotalWidth + strokeGap
        mRectF.top = top
        mRectF.right = width.toFloat() - strokeGap
        mRectF.bottom = bottom
    }

    private fun setMaxRectF(levelTotalWidth: Float) {
        if (isStrokeShow) {
            val top = when (mExperienceGravity) {
                //顶部
                1 -> mStrokeWidth
                //底部
                2 -> height - mExperienceHeight + mStrokeWidth
                //居中
                else -> (height - mExperienceHeight) / 2 + mStrokeWidth
            }

            mRectF.left = levelTotalWidth + mStrokeWidth * 0.8F
            mRectF.top = top
            mRectF.right = width.toFloat() - mStrokeWidth * 0.8F
            mRectF.bottom = top + mExperienceHeight - mStrokeWidth * 2
        } else {
            val top = when (mExperienceGravity) {
                //顶部
                1 -> 0F
                //底部
                2 -> height - mExperienceHeight
                //居中
                else -> (height - mExperienceHeight) / 2
            }

            mRectF.left = levelTotalWidth
            mRectF.top = top
            mRectF.right = width.toFloat()
            mRectF.bottom = mRectF.top + mExperienceHeight
        }
    }

    private fun setProgressRectF(levelTotalWidth: Float, progressWidth: Float) {
        if (isStrokeShow) {
            val top = when (mExperienceGravity) {
                //顶部
                1 -> mStrokeWidth
                //底部
                2 -> height - mExperienceHeight + mStrokeWidth
                //居中
                else -> (height - mExperienceHeight) / 2 + mStrokeWidth
            }

            mRectF.left = levelTotalWidth + mStrokeWidth * 0.8F
            mRectF.top = top
            mRectF.right = mRectF.left + progressWidth
            mRectF.bottom = top + mExperienceHeight - mStrokeWidth * 2
        } else {
            val top = when (mExperienceGravity) {
                //顶部
                1 -> 0F
                //底部
                2 -> height - mExperienceHeight
                //居中
                else -> (height - mExperienceHeight) / 2
            }

            mRectF.left = levelTotalWidth
            mRectF.top = top
            mRectF.right = levelTotalWidth + progressWidth
            mRectF.bottom = mRectF.top + mExperienceHeight
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val levelText = "$mLevelTag$mLevel"
        val levelTextWidth = mLevelTextPaint.measureText(levelText)
        //等级 + 等级与经验条的间隙
        val levelTotalWidth = levelTextWidth + mLevelGap

        if (isStrokeShow) {
            //绘制线框
            setStrokeRectF(levelTotalWidth)
            //canvas.draw
            canvas.drawRoundRect(
                mRectF,
                mRectRadius,
                mRectRadius,
                mStrokePaint
            )
        }

        //绘制背景
        setMaxRectF(levelTotalWidth)
        mRectPaint.color = mMaxColor
        canvas.drawRoundRect(
            mRectF.left,
            mRectF.top,
            mRectF.right,
            mRectF.bottom,
            mRectRadius,
            mRectRadius,
            mRectPaint
        )
        //绘制progress
        var percent = (mExperienceProgress.toFloat() / mExperienceMax)
        if (percent > 1F) {
            percent = 1F
        }
        val maxWidth = mRectF.right - mRectF.left
        val progressWidth = maxWidth * percent
        setProgressRectF(levelTotalWidth, progressWidth)
        if (progressWidth > 0F) {
            mRectPaint.color = mProgressColor
            canvas.drawRoundRect(
                mRectF.left,
                mRectF.top,
                mRectF.right,
                mRectF.bottom,
                mRectRadius,
                mRectRadius,
                mRectPaint
            )
        }

        //绘制等级文本
        val levelTextX = 0F
        val levelTextY =
            (height + (mLevelTextPaint.descent() - mLevelTextPaint.ascent())) / 2F - (mLevelTextPaint.fontMetrics.ascent - mLevelTextPaint.fontMetrics.top)
        canvas.drawText(levelText, levelTextX, levelTextY, mLevelTextPaint)
        //绘制经验文本
        val expText = "$mExperienceProgress$mExperienceSeparator$mExperienceMax"
        val expTextWidth = mExpTextPaint.measureText(expText)
        val expExpectStart = progressWidth - expTextWidth
        val expTextX = if (expExpectStart >= mExpGap * 2) {
            mRectF.right - expTextWidth - mExpGap
        } else {
            mRectF.left + mExpGap
        }
        val textY =
            ((mRectF.bottom + mRectF.top) + (mExpTextPaint.descent() - mExpTextPaint.ascent())) / 2F - (mExpTextPaint.fontMetrics.ascent - mExpTextPaint.fontMetrics.top)
        canvas.drawText(expText, expTextX, textY, mExpTextPaint)
    }

    //校准Progress
    private fun calibrationProgress(progress: Int): Int {
        return if (progress < 0) {
            0
        } else {
            progress
        }
    }

    fun initExperience(level: Int, progress: Int, max: Int, factor: Int) {
        mLevel = level
        mExperienceMax = max
        mExperienceFactor = factor
        setProgress(progress)
    }

    fun getProgress(): Int = mExperienceProgress

    fun setProgress(progress: Int) {
        if (mProgressAnimator?.isRunning == true) {
            return
        }

        val nextProgress = calibrationProgress(progress)
        var targetProgress = nextProgress
        mExperienceOverflow = if (nextProgress >= mExperienceMax) {
            //溢出经验值
            targetProgress = mExperienceMax
            nextProgress - mExperienceMax
        } else {
            0
        }

        mProgressAnimator = ObjectAnimator.ofInt(
            this,
            "mExperienceProgress",
            mExperienceProgress,
            targetProgress
        )
        mProgressAnimator?.duration = mAnimatorDuration.toLong()
        //差值器 其变化开始速率较快，后面减速
        mProgressAnimator?.interpolator = DecelerateInterpolator()
        mProgressAnimator?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                if (mExperienceOverflow > 0 || mExperienceProgress == mExperienceMax) {
                    mLevel++
                    mExperienceProgress = 0

                    mExperienceMax = mExperienceFactor * mLevel
                    setProgress(mExperienceOverflow)
                } else {
                    mProgressAnimator?.removeAllListeners()
                    mProgressAnimator = null
                }
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        mProgressAnimator?.start()
    }
}