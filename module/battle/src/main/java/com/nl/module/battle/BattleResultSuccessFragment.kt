package com.nl.module.battle

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.nl.component.NLBaseDialogFragment
import com.nl.module.battle.databinding.FragmentDialogBattleResultSuccessBinding

class BattleResultSuccessFragment : NLBaseDialogFragment<FragmentDialogBattleResultSuccessBinding>() {

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