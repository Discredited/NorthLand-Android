package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.june.northland.R
import kotlinx.android.synthetic.main.widget_attribute_display_layout.view.*

class AttributeDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

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
        tvAttributeTitle.visibility = isShowTitle
        tvAttributeTitle.text = titleName

        initDrawable(tvAttributeOne, oneResId)
        initDrawable(tvAttributeTwo, twoResId)
        initDrawable(tvAttributeThree, threeResId)
        initDrawable(tvAttributeFour, fourResId)
    }

    fun setAttributeValue(first: String, second: String, third: String, four: String) {
        tvAttributeOne.text = first
        tvAttributeTwo.text = second
        tvAttributeThree.text = third
        tvAttributeFour.text = four
    }
}