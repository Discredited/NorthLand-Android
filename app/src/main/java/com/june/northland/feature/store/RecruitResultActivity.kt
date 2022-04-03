package com.june.northland.feature.store

import android.view.View
import com.june.base.basic.part.BaseActivity
import com.june.northland.R
import com.june.northland.databinding.ActivityRecruitResultBinding
import com.nl.component.NLBaseActivity

class RecruitResultActivity : NLBaseActivity<ActivityRecruitResultBinding>() {

    override fun initView() {
    }

    override fun loadData() {
        requestRecruit()
    }

    private fun requestRecruit() {
        mBinding.ivRecruitAvatar.setImageResource(R.drawable.ic_avatar_jiu_dan_mei)
        mBinding.tvRecruitName.text = "鸠丹媚"
        boom()
    }

    private fun boom() {
        mBinding.tvRecruitSlogan.text = "沙罗铁树，只为自己盛开"
        mBinding.tvRecruitSlogan.visibility = View.VISIBLE
    }
}