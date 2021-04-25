package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.databinding.WidgetAttributeDisplayLayoutBinding

class AttributeDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mBinding: WidgetAttributeDisplayLayoutBinding =
        WidgetAttributeDisplayLayoutBinding.inflate(LayoutInflater.from(context), this)

    init {
        View.inflate(context, R.layout.widget_attribute_display_layout, this)
    }

    private fun initDrawable(textView: AppCompatTextView, resourceId: Int) {
        val drawable = ContextCompat.getDrawable(context, resourceId)
        drawable?.let {
            it.setBounds(0, 0, it.intrinsicWidth, it.intrinsicHeight)
            textView.setCompoundDrawables(it, null, null, null)
        }
    }

    fun initAttributeIcon(
        oneResId: Int,
        twoResId: Int,
        threeResId: Int,
        fourResId: Int,
        titleName: String = "",
        isShowTitle: Int = View.VISIBLE
    ) {
        mBinding.tvAttributeTitle.visibility = isShowTitle
        mBinding.tvAttributeTitle.text = titleName

        initDrawable(mBinding.tvAttributeOne, oneResId)
        initDrawable(mBinding.tvAttributeTwo, twoResId)
        initDrawable(mBinding.tvAttributeThree, threeResId)
        initDrawable(mBinding.tvAttributeFour, fourResId)
    }

    fun setAttributeValue(first: String, second: String, third: String, four: String) {
        mBinding.tvAttributeOne.text = first
        mBinding.tvAttributeTwo.text = second
        mBinding.tvAttributeThree.text = third
        mBinding.tvAttributeFour.text = four
    }
}