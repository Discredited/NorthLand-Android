package com.june.northland.widget.text

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatTextView
import timber.log.Timber

/**
 * 逐字显示TextView
 */
class VerbatimTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    var mContent: String = ""
    var mContentLength: Int = 0
    var mCurrentPosition: Int = 0

    var mVerbatimDuration: Long = 100
    var mValueAnimator: ValueAnimator? = null

    var mVerbatimFinished: Boolean = false

    var mVerbatimListener: VerbatimListener? = null

    fun startTextVerbatim() {
        mVerbatimFinished = false
        mCurrentPosition = 0
        mValueAnimator = ValueAnimator.ofInt(0, mContentLength)
        mValueAnimator?.duration = mVerbatimDuration * mContentLength
        mValueAnimator?.interpolator = LinearInterpolator()
        mValueAnimator?.addUpdateListener {
            val position = it.animatedValue as Int
            if (position != mCurrentPosition) {
                mCurrentPosition = position
                val newContent = mContent.substring(0, position)
                Timber.e("newContent:$newContent")
                Timber.e("position:$position    contentLength:$mContentLength")
                text = newContent
                if (position == mContentLength) {
                    mVerbatimFinished = true
                    mVerbatimListener?.onVerbatimFinish()
                }
            }
        }
        mValueAnimator?.start()
        mVerbatimListener?.onVerbatimBegin()
    }

    fun stopTextVerbatim() {
        mValueAnimator?.end()
    }

    fun setVerbatimListener(listener: VerbatimListener) {
        mVerbatimListener = listener
    }

    fun setVerbatimContent(content: String?, isStartVerbatim: Boolean = true) {
        content?.let {
            mContent = it
            mContentLength = it.length

            if (isStartVerbatim) {
                startTextVerbatim()
            }
        }
    }

    fun isVerbatimFinished() = mVerbatimFinished

    override fun onDetachedFromWindow() {
        stopTextVerbatim()
        super.onDetachedFromWindow()
    }
}