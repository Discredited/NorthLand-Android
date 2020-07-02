package com.june.northland.feature.store

import com.june.northland.R
import com.june.northland.base.component.BaseFragment

class RecruitActivityFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_recruit_normal

    override fun initView() {
    }

    companion object {
        fun newInstance(): RecruitActivityFragment {
            return RecruitActivityFragment()
        }
    }
}