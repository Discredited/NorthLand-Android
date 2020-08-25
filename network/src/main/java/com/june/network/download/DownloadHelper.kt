package com.june.network.download

import okhttp3.OkHttpClient
import okhttp3.Request
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream

class DownloadHelper(private val listener: ProgressListener? = null) {

    private val mClient: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        listener?.let {
            builder.addInterceptor(ProgressInterceptor(listener))
        }
        mClient = builder.build()
    }

    fun startDownload(url: String, filePath: String): String? {

        val file = File(filePath)
        if (!file.exists()) {
            val isCreate = file.createNewFile()
            Timber.w("文件不存在,创建文件:$isCreate")
        }

        val request = Request.Builder().url(url).build()
        val newCall = mClient.newCall(request)
        val response = newCall.execute()
        val inputStream = response.body?.byteStream()
        val outputStream = FileOutputStream(file)

        return inputStream?.use {
            outputStream.use { fileOut ->
                val length = it.copyTo(fileOut)
                if (length > 0) {
                    filePath
                } else {
                    null
                }
            }
        }
    }
}