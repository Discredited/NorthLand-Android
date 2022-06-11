package com.nl.module.store.recruit

import com.nl.component.NLBaseFragment
import com.nl.module.store.databinding.FragmentRecruitNormalBinding

class RecruitActivityFragment : NLBaseFragment<FragmentRecruitNormalBinding>() {

    override fun initView() {
    }

    companion object {
        fun newInstance(): RecruitActivityFragment {
            return RecruitActivityFragment()
        }
    }
}