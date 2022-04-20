package com.nl.module.skill

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.nl.module.skill.databinding.WidgetSkillDisplayLayoutBinding

class SkillDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mBinding: WidgetSkillDisplayLayoutBinding =
        WidgetSkillDisplayLayoutBinding.inflate(LayoutInflater.from(context), this)

    init {
        View.inflate(context, R.layout.widget_skill_display_layout, this)
    }

    fun setSkill() {
        mBinding.ivSkillIcon.setImageResource(R.drawable.ic_default_skill)
        mBinding.tvSkillName.text = context.getString(R.string.str_skill_name_and_level, "弱水三千", "1")
        mBinding.tvSkillDesc.text = "三千弱水剑化作三千弱水，攻击伤害值增加10%"
    }
}