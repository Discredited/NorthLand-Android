package com.june.northland.feature.store

import android.view.View
import com.june.northland.R
import com.june.northland.databinding.ActivityRecruitResultBinding
import com.june.widget.explosion.ExplosionFieldView
import com.nl.component.NLBaseActivity
import com.nl.component.ext.click

class RecruitResultActivity : NLBaseActivity<ActivityRecruitResultBinding>() {

    private val mExplosionView by lazy { ExplosionFieldView.attach2Window(this) }

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

        mBinding.flRecruitSlogan.click {
            mExplosionView?.explode(it)
        }
    }
}