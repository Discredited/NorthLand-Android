package com.june.northland.feature.dungeon

import android.content.Intent
import android.view.View
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.widget.text.VerbatimListener
import kotlinx.android.synthetic.main.activity_plot_display.*

/**
 * @author June
 * @description 剧情展示
 * @version 1.0.0
 * @time 2020/7/28 15:48
 */
class PlotDisplayActivity : BaseActivity() {

    private var mStoryIndex: Int = 0
    private val mStoryList = mutableListOf<PlotVo>()

    override fun getLayoutResId(): Int = R.layout.activity_plot_display

    override fun initView() {
        tvVerbatim.setVerbatimListener(object : VerbatimListener {
            override fun onVerbatimBegin() {
            }

            override fun onVerbatimFinish() {
                mStoryIndex++
            }
        })
        tvVerbatim.click {
            if (tvVerbatim.isVerbatimFinished()) {
                if (mStoryIndex < mStoryList.size) {
                    displayStory(mStoryList[mStoryIndex])
                } else {
                    //剧情结束
                    startActivity(Intent(this, DungeonBattleActivity::class.java))
                    finish()
                }
            } else {
                tvVerbatim?.stopTextVerbatim()
            }
        }
    }

    override fun loadData() {
        mStoryList.addAll(
            mutableListOf(
                PlotVo(
                    "如果那一晚，没有大雨和洪水，尾生能等到心爱的女子吗?",
                    "甘柠真",
                    R.drawable.ic_avatar_gan_ning_zhen,
                    0
                ),
                PlotVo(
                    "我是林飞。林木森森的林，一飞冲天的飞",
                    "林飞",
                    R.drawable.ic_avatar_lin_fei,
                    1
                ),
                PlotVo(
                    "为什么没有告诉你，其实，我很喜欢你。",
                    "甘柠真",
                    R.drawable.ic_avatar_gan_ning_zhen,
                    0
                ),
                PlotVo(
                    "这一生，我从不等别人来将我唤醒！",
                    "林飞",
                    R.drawable.ic_avatar_lin_fei,
                    1
                )
            )
        )

        displayStory(mStoryList[mStoryIndex])
    }

    private fun displayStory(plot: PlotVo) {
        if (plot.rolePosition == 1) {
            ivRoleLeft.visibility = View.GONE
            ivRoleRight.visibility = View.VISIBLE
            ivRoleRight.setImageResource(plot.roleAvatar)
        } else {
            ivRoleRight.visibility = View.GONE
            ivRoleLeft.visibility = View.VISIBLE
            ivRoleLeft.setImageResource(plot.roleAvatar)
        }
        tvVerbatim.setVerbatimContent("${plot.roleName}:${plot.content}")
    }
}