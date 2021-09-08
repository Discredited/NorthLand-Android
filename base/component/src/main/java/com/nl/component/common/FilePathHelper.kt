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
    fun getResourceDirectory(): String {
        return "${getAppExternalDirectory()}/$RESOURCE_DIRECTORY"
    }

    //获取资源配置文件
    fun getResourceConfigFile(): File? {
        val resConfigPath = "${getResourceDirectory()}/resource/resourceConfig.txt"
        val resConfigFile = File(resConfigPath)
        if (resConfigFile.exists()) {
            return resConfigFile
        }
        return null
    }


    fun getCharacterAvatarDirectory(): String {
        return "${getResourceDirectory()}/resource/characters"
    }

    fun getCharacterAvatar(avatar: String): String {
        return "${getCharacterAvatarDirectory()}/$avatar/"
    }

    fun getEquipmentIcon(icon: String): String {
        return "${getResourceDirectory()}/resource/equipment/${icon}"
    }
}