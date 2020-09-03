package com.june.northland.feature.battle

import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_battle_result_fail.*

class BattleResultFailFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_battle_result_fail

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvResult.text = "战斗失败"
        tvPromoteCharacters.text= "提升人物等级\n培养人物属性"
        tvPromoteEquipment.text= "提升装备等级\n培养装备属性"
        tvPromotePractice.text= "提升妖力\n提升道境"
        tvPromoteOther.text= "提升其他属性\n提升其他技能"
    }

    override fun layoutParamsWidth() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutGravity(): Int = Gravity.CENTER
}