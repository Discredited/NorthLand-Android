package com.june.northland.feature.dungeon.chapter

import android.content.Intent
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.june.base.basic.part.BaseActivity
import com.june.northland.R
import com.nl.component.ext.itemClick
import com.june.northland.databinding.ActivityChapterListBinding
import com.june.northland.feature.dungeon.DungeonListActivity
import com.june.northland.utils.Toast

/**
 * @author June
 * @description 副本章节
 * @version 1.0.0
 * @time 2020/7/29 11:30
 */
class ChapterListActivity : BaseActivity<ActivityChapterListBinding>() {

    private val mAdapter = ChapterAdapter()

    override fun viewBinding(): ActivityChapterListBinding {
        return ActivityChapterListBinding.inflate(layoutInflater)
    }

    override fun initView() {

        mAdapter.itemClick { _, _, position ->
            val chapter = mAdapter.data[position]
            if (chapter.isUnlock) {
                startActivity(Intent(this, DungeonListActivity::class.java))
            } else {
                Toast.toastShort(getString(R.string.prompt_chapter_unlock))
            }
        }

        mBinding.rvChapter.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                ChapterVo(
                    "龙蝶洞府",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    3,
                    15
                ),
                ChapterVo(
                    "如意城",
                    "- 红尘天 -",
                    R.drawable.img_practice_1,
                    0,
                    30,
                    false
                ),
                ChapterVo(
                    "丽人行",
                    "- 红尘天 -",
                    R.drawable.img_practice_2,
                    3,
                    30,
                    false
                ),
                ChapterVo(
                    "海市蜃楼",
                    "- 红尘天 -",
                    R.drawable.img_practice_3,
                    3,
                    30,
                    false
                ),
                ChapterVo(
                    "龙鲸之旅",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    3,
                    30,
                    false
                ),
                ChapterVo(
                    "大千城",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    3,
                    30,
                    false
                ),
                ChapterVo(
                    "橘子洲",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    3,
                    30,
                    false
                ),
                ChapterVo(
                    "飘香盛会",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    3,
                    30,
                    false
                ),
                ChapterVo(
                    "一刹那的绚烂",
                    "- 红尘天 -",
                    R.drawable.img_practice_0,
                    3,
                    30,
                    false
                )
            )
        )
    }
}