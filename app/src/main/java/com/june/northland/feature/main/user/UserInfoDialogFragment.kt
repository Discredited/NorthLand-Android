package com.june.northland.feature.main.user

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import com.june.northland.databinding.FragmentDialogUserInfoBinding
import com.nl.component.NLBaseDialogFragment
import com.nl.component.ext.click

class UserInfoDialogFragment : NLBaseDialogFragment<FragmentDialogUserInfoBinding>() {

    override fun initView() {
        mBinding.tvLogout.click { dismiss() }
    }

    override fun viewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDialogUserInfoBinding {
        return FragmentDialogUserInfoBinding.inflate(inflater, container, false)
    }

    override fun layoutParamsWidth(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutGravity(): Int = Gravity.CENTER

    companion object {
        fun newInstance(): UserInfoDialogFragment {
            return UserInfoDialogFragment()
        }
    }
}