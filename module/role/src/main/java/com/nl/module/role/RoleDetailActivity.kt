package com.nl.module.role

import com.nl.component.NLBaseActivity
import com.nl.module.role.databinding.ActivityRoleDetailBinding


class RoleDetailActivity : NLBaseActivity<ActivityRoleDetailBinding>() {

    override fun viewBinding(): ActivityRoleDetailBinding {
        return ActivityRoleDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
    }

    override fun loadData() {
    }
}