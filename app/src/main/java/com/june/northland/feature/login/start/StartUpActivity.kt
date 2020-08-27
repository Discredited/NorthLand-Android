package com.june.northland.feature.login.start

import android.text.format.DateUtils
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.base.ext.commitFragment
import com.june.northland.feature.login.start.announcement.AnnouncementFragment
import kotlinx.android.synthetic.main.activity_start_up.*

/**
 * 启动页面
 */
class StartUpActivity : BaseActivity() {

    private val mStartUpViewModel by viewModels<StartUpViewModel>()

    override fun getLayoutResId(): Int = R.layout.activity_start_up

    override fun initView() {
        tvAnnouncement.click {
            AnnouncementFragment.newInstance().show(supportFragmentManager, "AnnouncementFragment")
        }
    }

    override fun loadData() {
        mStartUpViewModel.mEntranceLive.observe(this, Observer {
            startEntrance()
        })

        //检查更新和配置参数
        requestConfigParams()
    }

    override fun onBackPressed() {
        //拦截返回事件
    }

    private fun requestConfigParams() {
        val timestamp = System.currentTimeMillis()
        val date = DateUtils.formatDateTime(applicationContext, timestamp, DateUtils.FORMAT_SHOW_TIME)
        val remoteConfig = ResourceConfig(0, "0.0.1", timestamp, date)
        val needUpdate = mStartUpViewModel.checkUpdateResource(remoteConfig)
        if (needUpdate) {
            updateResource()
        } else {
            startEntrance()
        }
    }

    //更新游戏资源
    private fun updateResource() {
        val fragment = ResourceUpdateFragment.newInstance("")
        fcStartUp.commitFragment(supportFragmentManager, R.id.fcStartUp, fragment)
    }

    //进入游戏
    private fun startEntrance() {
        val fragment = StartEntranceFragment.newInstance()
        fcStartUp.commitFragment(supportFragmentManager, R.id.fcStartUp, fragment)
        requestAnnouncement()
    }

    //获取公告
    private fun requestAnnouncement() {
        AnnouncementFragment.newInstance().show(supportFragmentManager, "AnnouncementFragment")
    }
}