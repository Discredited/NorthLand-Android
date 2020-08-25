package com.june.northland.feature.login.start

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.GsonUtils
import com.june.northland.base.component.AppViewModel
import com.june.northland.common.FilePathHelper
import java.io.FileInputStream

class StartUpViewModel(application: Application) : AppViewModel(application) {

    val mEntranceLive: MutableLiveData<Int> = MutableLiveData()

    //检查是否需要更新资源
    fun checkUpdateResource(remoteConfig: ResourceConfig): Boolean {
        val resConfigFile = FilePathHelper.getResourceConfigFile()
        resConfigFile?.let { config ->
            val inputStream = FileInputStream(config)
            val json = inputStream.use {
                String(it.readBytes())
            }
            if (json.isNotEmpty()) {
                val localConfig = GsonUtils.fromJson(json, ResourceConfig::class.java)
                localConfig?.let {
                    return it.needUpdate(remoteConfig)
                }
            }
        }
        return true
    }

    //更新资源
    fun updateResource() {

    }

    //获取公告
    fun announcement() {

    }
}