package com.june.northland.feature.store

import android.view.View
import com.june.base.basic.part.BaseActivity
import com.june.northland.R
import com.june.northland.databinding.ActivityRecruitResultBinding
import me.samlss.bloom.Bloom
import me.samlss.bloom.effector.BloomEffector
import me.samlss.bloom.listener.BloomListener

class RecruitResultActivity : BaseActivity<ActivityRecruitResultBinding>() {

    override fun viewBinding(): ActivityRecruitResultBinding {
        return ActivityRecruitResultBinding.inflate(layoutInflater)
    }

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
        mBinding.tvRecruitSlogan.postDelayed({
            Bloom.with(this)
                .setParticleRadius(5F)
                .setEffector(
                    BloomEffector.Builder()
                        .setDuration(800)
                        .setAnchor(
                            mBinding.tvRecruitSlogan.width / 2F,
                            mBinding.tvRecruitSlogan.height / 2F
                        )
                        .build()
                )
                .setBloomListener(object : BloomListener {
                    override fun onBegin() {
                        mBinding.llRecruitContainer.postDelayed({
                            mBinding.llRecruitContainer.visibility = View.VISIBLE
                        }, 300)
                    }

                    override fun onEnd() {
                    }
                })
                .boom(mBinding.tvRecruitSlogan)
            mBinding.tvRecruitSlogan.visibility = View.GONE
        }, 1000)
    }
}