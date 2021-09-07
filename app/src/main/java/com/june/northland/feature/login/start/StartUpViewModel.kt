package com.june.northland.feature.login.start

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.ZipUtils
import com.nl.component.common.FilePathHelper
import java.io.File
import java.io.FileInputStream

class StartUpViewModel(application: Application) : com.nl.component.AppViewModel(application) {

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

    /**
     * 解压资源
     */
    fun unzipResource(): Int {
        val zipFilePath = FilePathHelper.getResourceZipPath()
        val unzipDirectory = FilePathHelper.getResourceDirectory()
        val zipFile = File(zipFilePath)
        if (!zipFile.exists()) {
            //资源压缩包不存在
            return UNZIP_FILE_NOT_EXIST
        }
        val fileList = ZipUtils.unzipFile(zipFilePath, unzipDirectory)
        //解压完成删除zip文件
        zipFile.delete()
        return if (fileList.isNotEmpty()) {
            UNZIP_FILE_SUCCESS
        } else {
            //文件解压失败
            UNZIP_FILE_ERROR
        }
    }

    //获取公告
    fun announcement() {

    }

    companion object {
        const val UNZIP_FILE_NOT_EXIST = -1
        const val UNZIP_FILE_ERROR = -2
        const val UNZIP_FILE_SUCCESS = 0
    }
}