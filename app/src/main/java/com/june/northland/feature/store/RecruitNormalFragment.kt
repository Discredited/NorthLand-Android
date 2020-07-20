package com.june.northland.feature.store

import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.fragment_recruit_normal.*

class RecruitNormalFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_recruit_normal

    override fun initView() {
        btRecruitOnce.click { startActivity(Intent(requireActivity(), RecruitResultActivity::class.java)) }
    }

    companion object {
        fun newInstance(): RecruitNormalFragment {
            return RecruitNormalFragment()
        }
    }
}