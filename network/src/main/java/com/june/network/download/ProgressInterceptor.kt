package com.june.network.download

import okhttp3.Interceptor
import okhttp3.Response

class ProgressInterceptor(private val listener: ProgressListener) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val body = response.body ?: return response
        val progressBody = ProgressResponseBody(body, listener)
        return response.newBuilder().body(progressBody).build()
    }
}