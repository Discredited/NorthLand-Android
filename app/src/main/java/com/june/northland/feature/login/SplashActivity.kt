package com.june.northland.feature.login

import android.content.Intent
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.SpanUtils
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.feature.main.MainActivity
import com.june.northland.utils.cache.UserDataCache
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private var mUserLogin: Boolean = false

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun initView() {
        btGoIn.click {
            if (mUserLogin) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }
    }

    override fun loadData() {
        mUserLogin = UserDataCache.getInstance().isUserLogin()
        if (mUserLogin) {
            tvUserAccount.text = getUserAccount(UserDataCache.getInstance().userName())
            tvUserAccount.movementMethod = LinkMovementMethod.getInstance()
            btGoIn.text = getString(R.string.prompt_go_in_north_land)
        } else {
            btGoIn.text = getString(R.string.str_login)
        }
    }

    override fun onBackPressed() {
        //拦截返回事件
    }

    private fun getUserAccount(account: String): SpannableStringBuilder {
        return SpanUtils().append("欢迎您，")
            .append(account).setBold()
            .append("    ")
            .append("切换账号")
            .setForegroundColor(ContextCompat.getColor(this, R.color.color_green))
            .setBold()
            .setClickSpan(object : ClickableSpan() {
                override fun updateDrawState(ds: TextPaint) {
                    ds.color = ds.linkColor
                }

                override fun onClick(widget: View) {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                }
            })
            .create()
    }
}