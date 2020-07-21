package com.june.northland.feature.store

import android.view.View
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import kotlinx.android.synthetic.main.activity_recruit_result.*
import me.samlss.bloom.Bloom
import me.samlss.bloom.effector.BloomEffector
import me.samlss.bloom.listener.BloomListener

class RecruitResultActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_recruit_result

    override fun initView() {
    }

    override fun loadData() {
        requestRecruit()
    }

    private fun requestRecruit() {
        ivRecruitAvatar.setImageResource(R.drawable.ic_avatar_jiu_dan_mei)
        tvRecruitName.text = "鸠丹媚"
        boom()
    }

    private fun boom() {
        tvRecruitSlogan.text = "沙罗铁树，只为自己盛开"
        tvRecruitSlogan.visibility = View.VISIBLE
        tvRecruitSlogan.postDelayed({
            Bloom.with(this)
                .setParticleRadius(5F)
                .setEffector(
                    BloomEffector.Builder()
                        .setDuration(800)
                        .setAnchor(tvRecruitSlogan.width / 2F, tvRecruitSlogan.height / 2F)
                        .build()
                )
                .setBloomListener(object : BloomListener {
                    override fun onBegin() {
                    }

                    override fun onEnd() {
                        tvRecruitSlogan.visibility = View.GONE
                        llRecruitContainer.visibility = View.VISIBLE
                    }
                })
                .boom(tvRecruitSlogan)
        }, 1000)
    }
}