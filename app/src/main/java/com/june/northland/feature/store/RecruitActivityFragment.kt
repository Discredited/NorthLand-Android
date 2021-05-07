package com.june.northland.feature.store

import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.base.basic.part.BaseFragment
import com.june.northland.databinding.FragmentRecruitNormalBinding

class RecruitActivityFragment : BaseFragment<FragmentRecruitNormalBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRecruitNormalBinding {
        return FragmentRecruitNormalBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
    }

    companion object {
        fun newInstance(): RecruitActivityFragment {
            return RecruitActivityFragment()
        }
    }
}