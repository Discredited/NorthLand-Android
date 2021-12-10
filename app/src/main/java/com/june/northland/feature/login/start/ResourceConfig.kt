package com.june.northland.feature.login.start

data class ResourceConfig(
    val version: Int = 0,
    val name: String = "",
    val timestamp: Long = 0,
    val date: String = ""
) {

    fun needUpdate(config: ResourceConfig): Boolean {
        return this.version < config.version
    }
}