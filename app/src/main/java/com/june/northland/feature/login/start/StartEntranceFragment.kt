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
import com.june.base.basic.ext.click
import com.june.northland.R
import com.june.northland.databinding.FragmentStartEntranceBinding
import com.june.northland.feature.login.signup.LoginActivity
import com.june.northland.feature.login.start.announcement.AnnouncementFragment
import com.june.northland.feature.main.MainActivity
import com.june.northland.utils.cache.UserDataCache
import com.nl.component.NLBaseFragment

class StartEntranceFragment : NLBaseFragment<FragmentStartEntranceBinding>() {

    private var mUserLogin: Boolean = false

    override fun initView() {
        mBinding.btGoIn.click {
            if (mUserLogin) {
                requestEntrance()
            } else {
                LoginActivity.starter(this)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //判断用户是否登录
        mUserLogin = UserDataCache.getInstance().isUserLogin()
        if (mUserLogin) {
            mBinding.tvUserAccount.text = getUserAccount(UserDataCache.getInstance().userName())
            mBinding.tvUserAccount.movementMethod = LinkMovementMethod.getInstance()
            mBinding.btGoIn.text = getString(R.string.prompt_go_in_north_land)
        } else {
            mBinding.btGoIn.text = getString(R.string.str_login)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == LoginActivity.REQUEST_LOGIN) {
            val account = data?.getStringExtra(LoginActivity.RESPONSE_NAME) ?: ""
            mBinding.tvUserAccount.text = getUserAccount(account)
            mUserLogin = true
        }

        requestAnnouncement()
    }

    //获取公告
    private fun requestAnnouncement() {
        AnnouncementFragment.newInstance().show(childFragmentManager, "AnnouncementFragment")
    }

    private fun requestEntrance() {
        showLoading(false)
        mBinding.btGoIn.postDelayed({
            hideLoading()
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            activity?.finish()
        }, 2000)
    }

    private fun getUserAccount(account: String): SpannableStringBuilder {
        return SpanUtils().append("欢迎回来，")
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