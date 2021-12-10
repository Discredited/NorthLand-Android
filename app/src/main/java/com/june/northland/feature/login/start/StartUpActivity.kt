package com.june.northland.feature.login.start

import android.text.format.DateUtils
import androidx.activity.viewModels
import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseActivity
import com.june.northland.databinding.ActivityStartUpBinding
import com.june.northland.feature.login.start.announcement.AnnouncementFragment
import com.nl.component.ext.commitFragment

/**
 * 启动页面
 */
class StartUpActivity : BaseActivity<ActivityStartUpBinding>() {

    private val mStartUpViewModel by viewModels<StartUpViewModel>()

    override fun viewBinding(): ActivityStartUpBinding {
        return ActivityStartUpBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.tvAnnouncement.click {
            AnnouncementFragment.newInstance().show(supportFragmentManager, "AnnouncementFragment")
        }
    }

    override fun loadData() {
        mStartUpViewModel.mEntranceLive.observe(this, {
            when (it) {
                StartUpViewModel.GRAPH_DATABASE_CHECK -> databaseCheck()
                StartUpViewModel.GRAPH_RESOURCE_UPDATE -> updateResource()
                else -> startEntrance()
            }
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
            databaseCheck()
        }
    }

    //更新游戏资源
    private fun updateResource() {
        val fragment = ResourceUpdateFragment.newInstance("")
        mBinding.fcStartUp.commitFragment(supportFragmentManager, fragment)
    }

    private fun databaseCheck() {
        val fragment = DataBaseCheckFragment.newInstance()
        mBinding.fcStartUp.commitFragment(supportFragmentManager, fragment)
    }

    //进入游戏
    private fun startEntrance() {
        val fragment = StartEntranceFragment.newInstance()
        mBinding.fcStartUp.commitFragment(supportFragmentManager, fragment)
    }
}