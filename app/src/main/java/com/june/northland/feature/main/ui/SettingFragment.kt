package com.june.northland.feature.main.ui

import com.blankj.utilcode.util.ToastUtils
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import com.june.northland.base.ext.loadAvatar
import kotlinx.android.synthetic.main.fragment_main_setting.*

class SettingFragment : BaseFragment() {
    override fun getLayoutResId(): Int = R.layout.fragment_main_setting

    override fun initView() {
        ivAvatar.loadAvatar(R.drawable.ic_avatar_gan_ning_zhen_1)
        tvLogout.click { ToastUtils.showShort("登出") }
    }
}