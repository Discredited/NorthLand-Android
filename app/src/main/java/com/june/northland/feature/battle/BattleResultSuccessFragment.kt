package com.june.northland.feature.battle

import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_battle_result_success.*

class BattleResultSuccessFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_battle_result_success

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvResult.text = "战斗成功"
    }

    override fun layoutParamsWidth() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutGravity(): Int = Gravity.CENTER
}