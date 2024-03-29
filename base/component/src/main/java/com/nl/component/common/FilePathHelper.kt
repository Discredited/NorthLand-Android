package com.nl.component.common

import com.blankj.utilcode.util.PathUtils
import java.io.File

object FilePathHelper {

    private const val RESOURCE_DIRECTORY = ".resource"

    // storage/emulated/0/Android/data/com.june.northland
    fun getAppExternalDirectory(): String {
        return PathUtils.getExternalAppDataPath()
    }

    // storage/emulated/0/Android/data/com.june.northland/resource.zip
    fun getResourceZipPath(): String {
        return "${getAppExternalDirectory()}/resource.zip"
    }

    // storage/emulated/0/Android/data/com.june.northland/.resource
    fun getResourceUnZipDir(): String {
        return "${getAppExternalDirectory()}/${RESOURCE_DIRECTORY}"
    }

    private fun getResourceDirectory(): String {
        return "${getAppExternalDirectory()}/${RESOURCE_DIRECTORY}/resource"
    }

    //获取资源配置文件
    // storage/emulated/0/Android/data/com.june.northland/.resource/resource/resourceConfig.txt
    fun getResourceConfigFile(): File? {
        val resConfigPath = "${getResourceDirectory()}/resourceConfig.txt"
        val resConfigFile = File(resConfigPath)
        if (resConfigFile.exists()) {
            return resConfigFile
        }
        return null
    }

    fun getCharacterAvatar(avatar: String): String {
        return "${getResourceDirectory()}/characters/$avatar/"
    }

    fun getEquipmentIcon(icon: String): String {
        return "${getResourceDirectory()}/equipments/${icon}"
    }

    fun getSkillIcon(icon: String): String {
        return "${getResourceDirectory()}/skills/${icon}"
    }
}