package com.june.northland.feature.store

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import kotlinx.android.synthetic.main.activity_recruit_result.*
import me.samlss.bloom.Bloom
import me.samlss.bloom.effector.BloomEffector

class RecruitResultActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_recruit_result

    override fun initView() {
    }

    override fun loadData() {
        tvRecruitSlogan.text = "沙罗铁树，只为自己盛开"

        tvRecruitSlogan.postDelayed({
            Bloom.with(this)
                .setParticleRadius(5F)
                .setEffector(
                    BloomEffector.Builder()
                        .setDuration(800)
                        .setAnchor(tvRecruitSlogan.width / 2F, tvRecruitSlogan.height / 2F)
                        .build()
                )
                .boom(tvRecruitSlogan)
        }, 2000)
    }
}