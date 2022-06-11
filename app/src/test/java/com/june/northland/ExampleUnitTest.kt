package com.june.northland

import com.nl.room.utils.RoomUtils
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("生成的ID:${RoomUtils.randomId()}")
    }
}