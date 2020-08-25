package com.june.network.download

interface ProgressListener {

    fun onProgress(progress: Long, max: Long, percent: Float)
}