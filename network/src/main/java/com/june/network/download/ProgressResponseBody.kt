package com.june.network.download

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*

class ProgressResponseBody(
    private val responseBody: ResponseBody,
    private val progressListener: ProgressListener?
) : ResponseBody() {

    private val bufferedSource: BufferedSource by lazy {
        getWrappedSource(responseBody.source()).buffer()
    }

    override fun contentLength(): Long = responseBody.contentLength()

    override fun contentType(): MediaType? = responseBody.contentType()

    override fun source(): BufferedSource = bufferedSource

    private fun getWrappedSource(source: Source): Source = object : ForwardingSource(source) {
        private var bytesRead = 0L
        private val contentLength by lazy {
            contentLength() //避免重复调用
        }

        override fun read(sink: Buffer, byteCount: Long): Long {
            val bytes = super.read(sink, byteCount)
            if (bytes != -1L) {
                bytesRead += bytes
                //进度监听回调
                val percent = bytesRead * 1F / contentLength
                progressListener?.onProgress(bytesRead, contentLength, percent)
            }
            return bytes
        }
    }
}