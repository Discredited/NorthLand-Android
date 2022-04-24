package com.nl.module.skill.list

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.module.skill.R
import com.nl.module.skill.SkillVo
import com.nl.module.skill.databinding.ItemSkillBinding

/**
 * 技能列表适配器
 *
 * 2022/4/23
 * @author June
 */
class SkillListAdapter : BaseQuickAdapter<SkillVo, BaseDataBindingHolder<ItemSkillBinding>>(R.layout.item_skill) {

    override fun convert(holder: BaseDataBindingHolder<ItemSkillBinding>, item: SkillVo) {
        holder.dataBinding?.apply {
            vSkillDisplay.setSkill(item)
        }
    }
}