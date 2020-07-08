package com.june.northland.base.app

import android.app.Application
import com.june.northland.utils.cache.UserDataCache
import timber.log.Timber

class NorthLandApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        UserDataCache.getInstance().init(this)
    }
}