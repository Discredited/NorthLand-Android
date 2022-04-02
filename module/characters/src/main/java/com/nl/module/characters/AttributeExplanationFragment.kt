package com.nl.module.characters

import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseDialogFragment
import com.nl.module.characters.databinding.FragmentDialogAttributeExplanationBinding

class AttributeExplanationFragment : BaseDialogFragment<FragmentDialogAttributeExplanationBinding>() {

    override fun initView() {
        mBinding.vLayoutContainer.click { dismiss() }
    }
}