package com.june.northland.feature.dungeon

import android.content.Intent
import com.june.base.basic.ext.setLinearManager
import com.june.base.basic.part.BaseActivity
import com.june.northland.R
import com.nl.component.ext.itemChildClick
import com.june.northland.databinding.ActivityDungeonListBinding
import com.june.northland.feature.dungeon.plot.PlotDisplayActivity
import com.nl.component.widget.res.ResourceVo

/**
 * 剧情列表
 */
class DungeonListActivity : BaseActivity<ActivityDungeonListBinding>() {

    private val mAdapter = DungeonAdapter()

    override fun viewBinding(): ActivityDungeonListBinding {
        return ActivityDungeonListBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.vResource.addResource(ResourceVo(R.drawable.ic_herb, 9999))
        mBinding.vResource.addResource(ResourceVo(R.drawable.ic_gold, 150))

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

        mBinding.rvDungeon.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)

        }
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