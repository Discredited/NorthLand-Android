package com.june.northland.widget.res

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.june.northland.R

/**
 * resourceLayout
 * 各种资源显示
 */
class ResourceLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mDefaultWidth: Int = resources.getDimensionPixelSize(R.dimen.dp_80)
    private val mDefaultMarginEnd: Int = resources.getDimensionPixelSize(R.dimen.dp_10)
    private val mDrawableSize: Int = resources.getDimensionPixelSize(R.dimen.dp_16)

    init {
        val padding = resources.getDimensionPixelSize(R.dimen.dp_10)
        setPadding(padding, 0, padding, 0)
    }

    private fun getDefaultLayoutParams(): LayoutParams {
        val layoutParams = LayoutParams(mDefaultWidth, LayoutParams.WRAP_CONTENT)
        layoutParams.gravity = Gravity.END or Gravity.CENTER_VERTICAL
        layoutParams.marginEnd = childCount * (mDefaultWidth + mDefaultMarginEnd)
        return layoutParams
    }

    private fun getResDrawable(resId: Int): Drawable? {
        val drawable = ContextCompat.getDrawable(context, resId)
        drawable?.setBounds(0, 0, mDrawableSize, mDrawableSize)
        return drawable
    }

    private fun getResourceView(icon: Int, value: Int): AppCompatTextView {
        val resourceTextView = AppCompatTextView(context)
        resourceTextView.gravity = Gravity.CENTER_VERTICAL
        resourceTextView.setLines(1)
        resourceTextView.ellipsize = TextUtils.TruncateAt.END
        getResDrawable(icon)?.let {
            resourceTextView.setCompoundDrawables(it, null, null, null)
        }
        resourceTextView.compoundDrawablePadding = 10
        resourceTextView.setTextColor(ContextCompat.getColor(context, R.color.color_text_title))
        resourceTextView.text = value.toString()
        return resourceTextView
    }

    fun addResource(resourceVo: ResourceVo) {
        val resourceView = getResourceView(resourceVo.icon, resourceVo.value)
        addView(resourceView, getDefaultLayoutParams())
    }
}