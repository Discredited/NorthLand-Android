package com.june.northland.feature.login.start.announcement

import android.os.Bundle
import android.view.WindowManager
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.fragment_dialog_announcement.*

class AnnouncementFragment : BaseDialogFragment() {

    private val mAdapter = AnnouncementAdapter()

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_announcement

    override fun initView() {
        rvAnnouncement.setLinearManager()
        rvAnnouncement.adapter = mAdapter
        rvAnnouncement.setHasFixedSize(true)
        rvAnnouncement.addLinearItemDecoration()

        btSure.click { dismiss() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAdapter.setNewInstance(
            mutableListOf(
                AnnouncementVo(
                    "* 每周免费英雄",
                    "什么是每周免费英雄呢?就算你没有买英雄，在游戏中也有数个免费英雄可以使用。免费英雄会在每周五轮换，这样大家不用 花钱也能体验到不同英雄带来的乐趣。为了提升游戏体验，并让玩家体验到更多的游戏内容，每周轮换的周免英雄数量调整为游戏整体英雄数量的10%(四舍五入)，因此周免英雄数量增加到了14个，当我们推出第145个英雄时，周免英雄数量将会增加至15个。"
                ),
                AnnouncementVo(
                    "* 永久免费",
                    "在中国的服务器中，我们额外增加了四个永久免费使用的英雄——迅捷斥候 提莫、寒冰射手 艾希、德玛西亚之力 盖伦和符文法师 瑞兹 。"
                )
            )
        )
    }

    companion object {
        fun newInstance(): AnnouncementFragment {
            return AnnouncementFragment()
        }
    }

    override fun layoutParamsWidth(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight(): Int = WindowManager.LayoutParams.WRAP_CONTENT

}