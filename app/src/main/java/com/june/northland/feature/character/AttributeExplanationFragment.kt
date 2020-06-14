package com.june.northland.feature.character

import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.fragment_dialog_attribut_explanation.*

class AttributeExplanationFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_attribut_explanation

    override fun initView() {
        vLayoutContainer.click { dismiss() }
    }
}