package com.june.northland.feature.battle

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import com.june.base.basic.part.BaseDialogFragment
import com.nl.component.ext.click
import com.june.northland.databinding.FragmentDialogBattleResultFailBinding

class BattleResultFailFragment : BaseDialogFragment<FragmentDialogBattleResultFailBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDialogBattleResultFailBinding {
        return FragmentDialogBattleResultFailBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mBinding.btSure.click { dismiss() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.tvResult.text = "战斗失败"
        mBinding.tvPromoteCharacters.text = "提升人物等级\n培养人物属性"
        mBinding.tvPromoteEquipment.text = "提升装备等级\n培养装备属性"
        mBinding.tvPromotePractice.text = "提升妖力\n提升道境"
        mBinding.tvPromoteOther.text = "提升其他属性\n提升其他技能"
    }

    override fun layoutParamsWidth() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight() = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutGravity(): Int = Gravity.CENTER
}