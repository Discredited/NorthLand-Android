package com.june.northland.feature.login

import android.animation.ObjectAnimator
import android.content.Intent
import com.june.base.basic.part.BaseActivity
import com.june.northland.databinding.ActivitySplashBinding
import com.june.northland.feature.login.start.StartUpActivity
import com.nl.component.NLBaseActivity

class SplashActivity : NLBaseActivity<ActivitySplashBinding>() {

    private var mAdviceAnimator: ObjectAnimator? = null

    override fun initView() {
    }

    override fun loadData() {
        mAdviceAnimator = ObjectAnimator.ofFloat(mBinding.tvHealthGame, "alpha", 0F, 1F)
        mAdviceAnimator?.let {
            it.duration = 500
            it.start()
        }
        mBinding.tvHealthGame.postDelayed({
            startActivity(Intent(this, StartUpActivity::class.java))
            //startActivity(Intent(this, MainActivity::class.java))
            //startActivity(Intent(this, DungeonListActivity::class.java))
            finish()
        }, 1000)
    }

    override fun onDestroy() {
        mAdviceAnimator?.end()
        mAdviceAnimator = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        //隔绝交互事件
    }
}