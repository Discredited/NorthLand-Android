package com.nl.lib.element.base

import java.util.*

/**
 * 数据库工具类
 *
 * 2022/6/11
 * @author June
 */
object DatabaseUtils {

    fun randomId(): String {
        return UUID.randomUUID()
            .toString()
            .replace("-", "")
            .substring(0, 20)
    }
}