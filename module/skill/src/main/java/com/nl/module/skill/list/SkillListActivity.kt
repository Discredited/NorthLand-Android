package com.nl.module.skill.list

import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseActivity
import com.nl.module.skill.databinding.ActivitySkillListBinding

/**
 * 技能列表
 *
 * 2022/4/23
 * @author June
 */
class SkillListActivity : NLBaseActivity<ActivitySkillListBinding>() {

    private val mAdapter: SkillListAdapter by lazy { SkillListAdapter() }

    override fun initView() {
        mBinding.rvSkill.apply {
            setLinearManager()
            adapter = mAdapter
            addLinearItemDecoration()
            setHasFixedSize(true)
        }
    }

    override fun loadData() {
    }
}