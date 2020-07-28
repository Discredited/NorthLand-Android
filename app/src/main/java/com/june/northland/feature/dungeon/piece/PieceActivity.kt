package com.june.northland.feature.dungeon.piece

import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import com.june.northland.feature.dungeon.DungeonVo
import com.june.northland.feature.dungeon.PlotDisplayActivity
import kotlinx.android.synthetic.main.activity_piece.*

/**
 * @author June
 * @description 副本篇章目录
 * 红尘篇-(龙蝶洞府，如意城，龙鲸，大千城...)
 * 魔刹篇-(香草峡、沉沙河、花田、葬花渊、血戮林、冰海...)
 * 罗生篇-(南天门、一线峡、蝴蝶岭、迷空岛、艳阳峰...)
 * @version
 * @time 2020/7/28 15:56
 */
class PieceActivity : BaseActivity() {

    private val mAdapter = PieceAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_piece

    override fun initView() {
        mAdapter.itemClick { _, _, _ ->
            startActivity(Intent(this, PlotDisplayActivity::class.java))
        }

        rvPiece.setLinearManager()
        rvPiece.adapter = mAdapter
        rvPiece.setHasFixedSize(true)
        rvPiece.addLinearItemDecoration()
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                DungeonVo(
                    "初入红尘",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    "30 / 900"
                ),
                DungeonVo(
                    "大闹魔刹",
                    "- 魔刹天 -",
                    R.drawable.img_practice_1,
                    "0 / 900"
                ),
                DungeonVo(
                    "名贵风流",
                    "- 罗生天 -",
                    R.drawable.img_practice_2,
                    "0 / 900"
                ),
                DungeonVo(
                    "阶下囚",
                    "- 清虚天 -",
                    R.drawable.img_practice_3,
                    "0 / 900"
                ),
                DungeonVo(
                    "莲华会",
                    "- 吉祥天 -",
                    R.drawable.img_practice_0,
                    "0 / 900"
                )
            )
        )
    }
}