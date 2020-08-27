package com.june.northland.feature.main.email

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.activity_email_list.*

class EmailListActivity : BaseActivity() {

    private val mAdapter = EmailAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_email_list

    override fun initView() {
        rvEmail.setLinearManager()
        rvEmail.adapter = mAdapter
        rvEmail.setHasFixedSize(true)
        rvEmail.addLinearItemDecoration()
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", ""),
                EmailVo("", "")
            )
        )
    }
}