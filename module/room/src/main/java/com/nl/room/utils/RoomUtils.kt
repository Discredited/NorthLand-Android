package com.nl.room.utils

import java.util.*

/**
 * 数据库工具类
 *
 * 2022/5/31
 * @author June
 */
object RoomUtils {

    fun randomId(): String {
        return UUID.randomUUID().toString()
    }
}