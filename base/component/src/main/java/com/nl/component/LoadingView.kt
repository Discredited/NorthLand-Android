package com.nl.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.nl.component.databinding.WidgetLoadingLayoutBinding

class LoadingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mBinding: WidgetLoadingLayoutBinding =
        WidgetLoadingLayoutBinding.inflate(LayoutInflater.from(context), this)

    private var isLoading: Boolean = false

    fun setLoadingText(loadingText: String?) {
        loadingText?.let { }
    }

    fun isShowing(): Boolean = isLoading && visibility == VISIBLE

    fun show() {
        visibility = VISIBLE
        mBinding.vJumpLoading.beginAnimator()
        isLoading = true
    }

    fun hide() {
        mBinding.vJumpLoading.endAnimator()
        isLoading = false
        visibility = GONE
    }
}