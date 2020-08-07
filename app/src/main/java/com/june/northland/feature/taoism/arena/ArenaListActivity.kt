package com.june.northland.feature.taoism.arena

import androidx.recyclerview.widget.RecyclerView
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.activity_arena_list.*
import kotlinx.android.synthetic.main.view_close_image.*

/**
 * @author June
 * @description 竞技场
 * @version 1.0.0
 * @time 2020/8/6 14:47
 */
class ArenaListActivity : BaseActivity() {

    private val mAdapter = ArenaAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_arena_list

    override fun initView() {
        rvArena.adapter = mAdapter
        rvArena.setLinearManager(orientation = RecyclerView.HORIZONTAL)
        rvArena.setHasFixedSize(true)
        rvArena.addLinearItemDecoration(
            size = resources.getDimensionPixelSize(R.dimen.dp_10),
            orientation = RecyclerView.HORIZONTAL
        )

        ivClose.click { finish() }
    }

    override fun loadData() {
        val list = mutableListOf<ArenaVo>()
        for (index in 0 until 40) {
            list.add(ArenaVo())
        }
        mAdapter.setNewInstance(list)

        rvArena.scrollToPosition(20)
    }
}