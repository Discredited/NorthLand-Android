package com.nl.module.characters

import android.text.SpannableStringBuilder
import com.blankj.utilcode.util.SpanUtils
import com.june.base.basic.part.BaseActivity
import com.nl.module.characters.databinding.ActivityCharacterConfigBinding

class CharacterConfigActivity : BaseActivity<ActivityCharacterConfigBinding>() {

    private val mLevelVo = CharacterVo()

    override fun viewBinding(): ActivityCharacterConfigBinding {
        return ActivityCharacterConfigBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.tvSure.setOnClickListener {
            val expString =  mBinding.etExp.text.toString()
            if (expString.isEmpty()) {
                return@setOnClickListener
            }
            addExperience(expString.toLong())
            mBinding.tvInfo.text = levelInfo(mLevelVo)
        }
    }

    override fun loadData() {
    }

    private fun addExperience(exp: Long) {
        mLevelVo.experience += exp
        if (mLevelVo.experience >= mLevelVo.expNextLevel) {
            val targetLevel = targetLevel(
                mLevelVo.experience,
                mLevelVo.expNextLevel,
                mLevelVo.level,
                mLevelVo.expFactor
            )
            mLevelVo.levelUp(targetLevel - mLevelVo.level)
        }
    }

    private fun levelInfo(vo: CharacterVo): SpannableStringBuilder {
        val expLevelBound = vo.expNextLevel - vo.expLevel
        val expLevelCurrent = vo.experience - expLevelBound
        return SpanUtils()
            .append("名称:").append(vo.name)
            .appendLine()
            .append("等级:").append(vo.level.toString())
            .appendLine()
            .append("经验:").append("$expLevelCurrent / ${vo.expLevel}")
            .appendLine()
            .appendLine()
            .append("攻击:").append(vo.attack.toString())
            .appendLine()
            .append("防御:").append(vo.defense.toString())
            .appendLine()
            .append("生命:").append(vo.health.toString())
            .appendLine()
            .appendLine()
            .append("潜力:").append(vo.potential.toString())
            .create()
    }

    private fun targetLevel(exp: Long, expNextLv: Long, lv: Int, factor: Int): Int {
        var expTotal = expNextLv
        var level = lv
        do {
            level++
            expTotal += (factor * level)
        } while (exp > expTotal)
        return level
    }
}