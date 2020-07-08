package com.june.northland.utils.cache

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

class UserDataCache private constructor() {

    private var mSharedPreferences: SharedPreferences? = null

    fun init(context: Context) {
        mSharedPreferences = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
    }

    fun saveUserId(userId: String) {
        //commit为同步执行
        //apply为异步执行
        mSharedPreferences?.edit()?.putString("USER_ID", userId)?.apply()
    }

    fun userId(): String = mSharedPreferences?.getString("USER_ID", "") ?: ""

    fun saveToken(token: String) {
        mSharedPreferences?.edit()?.putString("USER_TOKEN", token)?.apply()
    }

    fun userToken(): String = mSharedPreferences?.getString("USER_TOKEN", "") ?: ""

    fun saveUserName(name: String) {
        mSharedPreferences?.edit()?.putString("USER_NAME", name)?.apply()
    }

    fun userName(): String = mSharedPreferences?.getString("USER_NAME", "") ?: ""

    fun isUserLogin(): Boolean = !TextUtils.isEmpty(userName())

    companion object {
        private val mInstance: UserDataCache by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            UserDataCache()
        }

        fun getInstance(): UserDataCache = mInstance
    }
}