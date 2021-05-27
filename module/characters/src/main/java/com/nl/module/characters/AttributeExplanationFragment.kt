package com.nl.module.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseDialogFragment
import com.nl.module.characters.databinding.FragmentDialogAttributeExplanationBinding

class AttributeExplanationFragment : BaseDialogFragment<FragmentDialogAttributeExplanationBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDialogAttributeExplanationBinding {
        return FragmentDialogAttributeExplanationBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.vLayoutContainer.click { dismiss() }
    }
}