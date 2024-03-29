package com.june.northland.feature.login.start

import android.text.format.DateUtils
import android.view.View
import androidx.activity.viewModels
import com.june.base.basic.ext.click
import com.june.northland.databinding.ActivityStartUpBinding
import com.june.northland.feature.login.start.announcement.AnnouncementFragment
import com.june.northland.feature.login.start.debug.DebugListDialogFragment
import com.nl.component.BuildConfig
import com.nl.component.NLBaseActivity
import com.nl.component.ext.commitFragment
import com.nl.component.ext.simpleName

/**
 * 启动页面
 */
class StartUpActivity : NLBaseActivity<ActivityStartUpBinding>() {

    private val mStartUpViewModel by viewModels<StartUpViewModel>()

    override fun initView() {
        // 调试模式开关
        if (BuildConfig.DEBUG) {
            mBinding.btDebug.visibility = View.VISIBLE
            mBinding.btDebug.click {
                DebugListDialogFragment.newInstance().show(supportFragmentManager, DebugListDialogFragment.simpleName())
            }
        } else {
            mBinding.btDebug.visibility = View.GONE
        }
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

        // 检查更新和配置参数
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

    // 更新游戏资源
    private fun updateResource() {
        val fragment = ResourceUpdateFragment.newInstance("")
        mBinding.fcStartUp.commitFragment(supportFragmentManager, fragment)
    }

    // 数据资源检查
    private fun databaseCheck() {
        val fragment = DataBaseCheckFragment.newInstance()
        mBinding.fcStartUp.commitFragment(supportFragmentManager, fragment)
    }

    // 进入游戏
    private fun startEntrance() {
        val fragment = StartEntranceFragment.newInstance()
        mBinding.fcStartUp.commitFragment(supportFragmentManager, fragment)
    }
}