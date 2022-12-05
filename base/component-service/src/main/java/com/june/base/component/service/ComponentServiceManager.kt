package com.june.base.component.service

import android.app.Application
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap

/**
 * 组件通信管理器
 *
 * 2022/12/4
 * @author June
 */
class ComponentServiceManager private constructor() {

    // 使用线程安全的map，避免服务注册异常
    private val mComponentServiceMap: ConcurrentHashMap<Class<*>?, Any?> = ConcurrentHashMap()

    fun init(application: Application) {

    }

    fun registerComponent(api: Class<*>, impl: Any) {
        mComponentServiceMap[api] = impl
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getComponent(apiClass: Class<out T>): T? {
        val impl = mComponentServiceMap[apiClass]
        if (impl == null) {
            Timber.w("service impl not found:${apiClass.simpleName}")
            return null
        }
        return impl as T
    }

    companion object {
        val instance: ComponentServiceManager by lazy {
            ComponentServiceManager()
        }
    }
}