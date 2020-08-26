package com.june.northland.feature.login.start

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.SpanUtils
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import com.june.northland.feature.login.LoginActivity
import com.june.northland.feature.main.MainActivity
import com.june.northland.utils.cache.UserDataCache
import kotlinx.android.synthetic.main.fragment_start_entrance.*

class StartEntranceFragment : BaseFragment() {

    private var mUserLogin: Boolean = false

    override fun getLayoutResId(): Int = R.layout.fragment_start_entrance

    override fun initView() {
        btGoIn.click {
            if (mUserLogin) {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                activity?.finish()
            } else {
                LoginActivity.starter(this)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //判断用户是否登录
        mUserLogin = UserDataCache.getInstance().isUserLogin()
        if (mUserLogin) {
            tvUserAccount.text = getUserAccount(UserDataCache.getInstance().userName())
            tvUserAccount.movementMethod = LinkMovementMethod.getInstance()
            btGoIn.text = getString(R.string.prompt_go_in_north_land)
        } else {
            btGoIn.text = getString(R.string.str_login)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == LoginActivity.REQUEST_LOGIN) {
            val account = data?.getStringExtra(LoginActivity.RESPONSE_NAME) ?: ""
            tvUserAccount.text = getUserAccount(account)
        }
    }


    private fun getUserAccount(account: String): SpannableStringBuilder {
        return SpanUtils().append("欢迎您，")
            .append(account).setBold()
            .append("    ")
            .append("切换账号")
            .setForegroundColor(ContextCompat.getColor(requireContext(), R.color.color_green))
            .setBold()
            .setClickSpan(object : ClickableSpan() {
                override fun updateDrawState(ds: TextPaint) {
                    ds.color = ds.linkColor
                }

                override fun onClick(widget: View) {
                    LoginActivity.starter(this@StartEntranceFragment)
                }
            })
            .create()
    }

    companion object {
        fun newInstance(): StartEntranceFragment {
            return StartEntranceFragment()
        }
    }
}