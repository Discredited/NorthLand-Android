package com.june.northland.feature.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.blankj.utilcode.util.ToastUtils
import com.june.northland.R
import com.june.northland.databinding.FragmentMainSettingBinding
import com.nl.component.NLBaseFragment
import com.nl.component.ext.click
import com.nl.component.ext.loadAvatar

class SettingFragment : NLBaseFragment<FragmentMainSettingBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainSettingBinding {
        return FragmentMainSettingBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.ivAvatar.loadAvatar(R.drawable.ic_avatar_gan_ning_zhen_1)
        mBinding.tvLogout.click { ToastUtils.showShort("登出") }
    }
}