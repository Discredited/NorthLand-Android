package com.june.northland.feature.dungeon

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.itemChildClick
import com.june.northland.base.ext.setLinearManager
import com.june.northland.feature.dungeon.plot.PlotDisplayActivity
import com.june.northland.widget.res.ResourceVo
import kotlinx.android.synthetic.main.activity_dungeon_list.*

/**
 * 剧情列表
 */
class DungeonListActivity : BaseActivity() {

    private val mAdapter = DungeonAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_dungeon_list

    override fun initView() {
        vResource.addResource(ResourceVo(R.drawable.ic_herb, 9999))
        vResource.addResource(ResourceVo(R.drawable.ic_gold, 150))

        mAdapter.addChildClickViewIds(R.id.btDungeonFight)
        mAdapter.itemChildClick { _, view, position ->
            val item = mAdapter.data[position]
            if (view.id == R.id.btDungeonFight) {
                if (item.hasPlot()) {
                    startActivity(Intent(this, PlotDisplayActivity::class.java))
                } else {
                    startActivity(Intent(this, DungeonBattleActivity::class.java))
                }
            }
        }

        rvDungeon.adapter = mAdapter
        rvDungeon.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvDungeon.setHasFixedSize(true)
        rvDungeon.setLinearManager()
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                DungeonVo("我和我的前世", "第一章", R.drawable.img_practice_0, 5, 3, 3, 1),
                DungeonVo("三个女人一台戏(上)", "第二章", R.drawable.img_practice_1, 5, 3, 3),
                DungeonVo("三个女人一台戏(下)", "第三章", R.drawable.img_practice_2, 5, 3, 3),
                DungeonVo("哭的时候也要笑", "第四章", R.drawable.img_practice_3, 5, 3, 3),
                DungeonVo("请跟我来", "第五章", R.drawable.img_practice_2, 5, 3, 3, 1)
            )
        )
    }
}