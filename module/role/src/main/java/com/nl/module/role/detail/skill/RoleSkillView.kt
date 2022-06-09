package com.nl.module.role.detail.skill

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadImage
import com.nl.lib.element.skill.SkillEntity
import com.nl.module.role.databinding.WidgetRoleSkillViewBinding

/**
 * 角色技能
 *
 * 2022/6/8
 * @author June
 */
class RoleSkillView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val mBinding = WidgetRoleSkillViewBinding.inflate(LayoutInflater.from(context), this)

    fun setSkill(skill: SkillEntity) {
        mBinding.ivSkillIcon.loadImage(FilePathHelper.getSkillIcon(skill.icon))
        mBinding.tvSkillName.text = "${skill.name} [lv.${skill.level}] [${(skill.triggerProbability * 100).toInt()}%]"
        mBinding.tvSkillDesc.text = skill.desc
    }
}