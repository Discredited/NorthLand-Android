package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.june.northland.R
import kotlinx.android.synthetic.main.widget_skill_display_layout.view.*

class SkillDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_skill_display_layout, this)
    }

    fun setSkill() {
        ivSkillIcon?.setImageResource(R.drawable.ic_default_skill)
        tvSkillName?.text = context.getString(R.string.str_skill_name_and_level, "弱水三千", "1")
        tvSkillDesc?.text = "三千弱水剑化作三千弱水，攻击伤害值增加10%"
    }
}