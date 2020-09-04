package com.june.northland.feature.login

import android.animation.ObjectAnimator
import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.feature.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private var mAdviceAnimator: ObjectAnimator? = null

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun initView() {
    }

    override fun loadData() {
        mAdviceAnimator = ObjectAnimator.ofFloat(tvHealthGame, "alpha", 0F, 1F)
        mAdviceAnimator?.let {
            it.duration = 500
            it.start()
        }
        tvHealthGame.postDelayed({
            //startActivity(Intent(this, StartUpActivity::class.java))
            startActivity(Intent(this, MainActivity::class.java))
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