package com.june.northland.feature.character

import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.base.basic.part.BaseDialogFragment
import com.nl.component.ext.click
import com.june.northland.databinding.FragmentDialogAttributExplanationBinding

class AttributeExplanationFragment :
    BaseDialogFragment<FragmentDialogAttributExplanationBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDialogAttributExplanationBinding {
        return FragmentDialogAttributExplanationBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.vLayoutContainer.click { dismiss() }
    }
}