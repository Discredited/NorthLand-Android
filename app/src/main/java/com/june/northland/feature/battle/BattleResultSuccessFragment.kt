package com.june.northland.feature.battle

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import com.june.base.basic.part.BaseDialogFragment
import com.june.northland.databinding.FragmentDialogBattleResultSuccessBinding

class BattleResultSuccessFragment : BaseDialogFragment<FragmentDialogBattleResultSuccessBinding>() {

    override fun initView() {
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.tvResult.text = "战斗成功"
    }

    override fun layoutParamsWidth() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutGravity(): Int = Gravity.CENTER
}