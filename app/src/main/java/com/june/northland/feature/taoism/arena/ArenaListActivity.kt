package com.june.northland.feature.taoism.arena

import androidx.recyclerview.widget.RecyclerView
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.june.northland.R
import com.june.northland.databinding.ActivityArenaListBinding
import com.nl.component.NLBaseActivity

/**
 * @author June
 * @description 竞技场
 * @version 1.0.0
 * @time 2020/8/6 14:47
 */
class ArenaListActivity : NLBaseActivity<ActivityArenaListBinding>() {

    private val mAdapter = ArenaAdapter()

    override fun initView() {
        mBinding.rvArena.apply {
            adapter = mAdapter
            setLinearManager(orientation = RecyclerView.HORIZONTAL)
            setHasFixedSize(true)
            addLinearItemDecoration(
                size = resources.getDimensionPixelSize(R.dimen.dp_10),
                orientation = RecyclerView.HORIZONTAL
            )
        }

        mBinding.iClose.ivClose.click { finish() }
    }

    override fun loadData() {
        val list = mutableListOf<ArenaVo>()
        for (index in 0 until 40) {
            list.add(ArenaVo())
        }
        mAdapter.setNewInstance(list)

        mBinding.rvArena.scrollToPosition(20)
    }
}