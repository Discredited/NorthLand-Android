package com.june.northland.common

import com.blankj.utilcode.util.PathUtils
import java.io.File

object FilePathHelper {

    private const val RESOURCE_DIRECTORY = ".resource"

    fun getResourceDirectory(): String {
        return "${PathUtils.getExternalAppDataPath()}/${RESOURCE_DIRECTORY}"
    }

    fun getResourceZipPath(): String {
        return "${getAppExternalDirectory()}/resource.zip"
    }

    //获取资源配置文件
    fun getResourceConfigFile(): File? {
        val resConfigPath = "${getResourceDirectory()}/resourceConfig.txt"
        val resConfigFile = File(resConfigPath)
        if (resConfigFile.exists()) {
            return resConfigFile
        }
        return null
    }

    // storage/emulated/0/Android/data/package
    fun getAppExternalDirectory(): String {
        return PathUtils.getExternalAppDataPath()
    }
}