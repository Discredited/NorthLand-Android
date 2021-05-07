package com.june.northland.feature.dungeon.plot

import android.content.Intent
import android.view.View
import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseActivity
import com.june.northland.R
import com.june.northland.databinding.ActivityPlotDisplayBinding
import com.june.northland.feature.dungeon.DungeonBattleActivity
import com.june.northland.widget.text.VerbatimListener

/**
 * @author June
 * @description 剧情展示
 * @version 1.0.0
 * @time 2020/7/28 15:48
 */
class PlotDisplayActivity : BaseActivity<ActivityPlotDisplayBinding>() {

    private var mStoryIndex: Int = 0
    private val mStoryList = mutableListOf<PlotVo>()

    override fun viewBinding(): ActivityPlotDisplayBinding {
        return ActivityPlotDisplayBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.tvVerbatim.setVerbatimListener(object : VerbatimListener {
            override fun onVerbatimBegin() {
            }

            override fun onVerbatimFinish() {
                mStoryIndex++
            }
        })
        mBinding.tvVerbatim.click {
            if (mBinding.tvVerbatim.isVerbatimFinished()) {
                if (mStoryIndex < mStoryList.size) {
                    displayStory(mStoryList[mStoryIndex])
                } else {
                    //剧情结束
                    startActivity(Intent(this, DungeonBattleActivity::class.java))
                    finish()
                }
            } else {
                mBinding.tvVerbatim.stopTextVerbatim()
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
            mBinding.ivRoleLeft.visibility = View.GONE
            mBinding.ivRoleRight.visibility = View.VISIBLE
            mBinding.ivRoleRight.setImageResource(plot.roleAvatar)
        } else {
            mBinding.ivRoleRight.visibility = View.GONE
            mBinding.ivRoleLeft.visibility = View.VISIBLE
            mBinding.ivRoleLeft.setImageResource(plot.roleAvatar)
        }
        mBinding.tvVerbatim.setVerbatimContent("${plot.roleName}:${plot.content}")
    }
}