package com.nl.module.skill.list

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseActivity
import com.nl.module.skill.SkillViewModel
import com.nl.module.skill.databinding.ActivitySkillListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * 技能列表
 *
 * 2022/4/23
 * @author June
 */
class SkillListActivity : NLBaseActivity<ActivitySkillListBinding>() {

    private val mViewModel by viewModels<SkillViewModel>()
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
        lifecycleScope.launch(Dispatchers.Main) {
            mViewModel.skillListFlow.collect { skills ->
                mAdapter.setNewInstance(skills)
            }
        }
    }
}