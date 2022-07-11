package com.nl.module.characters.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.nl.component.common.ColorUtils
import com.nl.module.characters.R

/**
 * realm View
 */
class RealmDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mActiveIconRes = R.drawable.svg_ordinary
    private var mNegativeIconRes = R.drawable.svg_primary
    private var mActiveBitmap: Bitmap? = null
    private var mNegativeBitmap: Bitmap? = null

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mTextSize = resources.getDimension(R.dimen.sp_20)
    private var mTextGap = resources.getDimension(R.dimen.dp_15)
    private var mIconGap = resources.getDimension(R.dimen.dp_5)

    private var mRealm: Int = 5
    private var mRealmName: String = ""

    init {
        val array = context.obtainStyledAttributes(
            attrs,
            R.styleable.RealmDisplayView, defStyleAttr,
            0
        )
        try {
            mRealm = array.getInt(R.styleable.RealmDisplayView_realm_count, 5)
            mRealmName = array.getString(R.styleable.RealmDisplayView_realm_text) ?: ""
            mTextSize = array.getDimension(R.styleable.RealmDisplayView_realm_text_size, mTextSize)

            mActiveIconRes = array.getResourceId(
                R.styleable.RealmDisplayView_realm_active_icon,
                mActiveIconRes
            )
            mNegativeIconRes = array.getResourceId(
                R.styleable.RealmDisplayView_realm_negative_icon,
                mNegativeIconRes
            )

            mTextGap = array.getDimension(
                R.styleable.RealmDisplayView_realm_text_gap,
                mTextGap
            )

            mIconGap = array.getDimension(
                R.styleable.RealmDisplayView_realm_icon_gap,
                mIconGap
            )
        } finally {
            array.recycle()
        }

        mActiveBitmap = ContextCompat.getDrawable(context, mActiveIconRes)?.let {
            it.toBitmap(it.intrinsicWidth, it.intrinsicHeight)
        }
        mNegativeBitmap = ContextCompat.getDrawable(context, mNegativeIconRes)?.let {
            it.toBitmap(it.intrinsicWidth, it.intrinsicHeight)
        }

        textPaint.color = Color.parseColor("#FF7700")
        textPaint.textSize = mTextSize
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val textWidth = textPaint.measureText(mRealmName).toInt()
        val textHeight = (textPaint.descent() - textPaint.ascent()).toInt()
        val bitmapWidth = mActiveBitmap?.width ?: textHeight
        val bitmapHeight = mActiveBitmap?.height ?: textHeight

        val recommendWidth = if (textWidth == 0) {
            (bitmapWidth * 9) + (mIconGap * 8).toInt()
        } else {
            (textWidth + mTextGap + (bitmapWidth * 9) + (mIconGap * 8)).toInt()
        }
        val recommendHeight = textHeight.coerceAtLeast(bitmapHeight)

        setMeasuredDimension(recommendWidth, recommendHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //文字绘制
        val textWidth = textPaint.measureText(mRealmName)
        val textX = 0F
        val textY = (height - (textPaint.descent() + textPaint.ascent())) / 2F
        canvas.drawText(mRealmName, textX, textY, textPaint)
        //图标绘制
        val iconStart = if (textWidth == 0F) {
            0F
        } else {
            textWidth + mTextGap
        }
        val top = (height - (mActiveBitmap?.height ?: 0)) / 2F

        for (index in 0 until 9) {
            val left = iconStart + ((mActiveBitmap?.width ?: 0) + mIconGap) * index

            val bitmap = if (index < mRealm) {
                mActiveBitmap
            } else {
                mNegativeBitmap
            }
            bitmap?.let {
                canvas.drawBitmap(it, left, top, null)
            }
        }
    }

    override fun onDetachedFromWindow() {
        mActiveBitmap = null
        mNegativeBitmap = null
        super.onDetachedFromWindow()
    }

    fun setRealm(realm: Int, realmName: String) {
        mRealm = realm
        mRealmName = realmName
        val realmColor = ColorUtils.getPowerColor(realm)
        textPaint.color = ContextCompat.getColor(context, realmColor)
        invalidate()
    }
}