package com.nl.component.common

import com.blankj.utilcode.util.PathUtils
import java.io.File

object FilePathHelper {

    private const val RESOURCE_DIRECTORY = ".resource"

    fun getResourceDirectory(): String {
        return "${PathUtils.getExternalAppDataPath()}/$RESOURCE_DIRECTORY/resource"
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


    fun getCharacterAvatarDirectory(): String {
        return "${getResourceDirectory()}/characters"
    }

    fun getCharacterAvatar(avatar: String): String {
        return "${getCharacterAvatarDirectory()}/$avatar/"
    }

    fun getEquipmentIcon(icon: String): String {
        return "${getCharacterAvatarDirectory()}/equipment/${icon}"
    }
}