package com.june.northland

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.june.northland.utils.cache.UserDataCache
import com.nl.room.RoomHelper
import timber.log.Timber

class NorthLandApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        UserDataCache.getInstance().init(this)
        RoomHelper.getInstance().initialize(applicationContext,"NorthLand")
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}