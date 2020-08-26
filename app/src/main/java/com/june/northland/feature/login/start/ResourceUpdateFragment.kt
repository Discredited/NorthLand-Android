package com.june.northland.feature.login.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ZipUtils
import com.june.network.download.DownloadHelper
import com.june.network.download.ProgressListener
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.common.FilePathHelper
import kotlinx.android.synthetic.main.fragment_resource_update.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class ResourceUpdateFragment : BaseFragment() {

    private val mStartUpViewModel by activityViewModels<StartUpViewModel>()

    override fun getLayoutResId(): Int = R.layout.fragment_resource_update

    override fun initView() {
        tvProgress.text = getString(R.string.str_download_progress, 0)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val url = arguments?.getString("URL")
        url?.let {
            //开始下载
            startDownload()
        }
        if (null == url) {
            changeRetry()
        }
    }

    private fun startDownload() {
        val downloadHelper = DownloadHelper(object : ProgressListener {
            override fun onProgress(progress: Long, max: Long, percent: Float) {
                viewLifecycleOwner.lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        pbDownload.max = max.toInt()
                        pbDownload.progress = progress.toInt()
                        tvProgress.text = getString(R.string.str_download_progress, (percent * 100).toInt())
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                val url =
                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598440722179&di=a3369a45c6f4d91312c9c78c47911328&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-01-09%2F5a547c0cb840c.jpg"
                val filePath = "${FilePathHelper.getAppExternalDirectory()}/TempImage.jpg"
                downloadHelper.startDownload(url, filePath)
            }
            result?.let {
                unzipFile()
            }
            if (null == result) {
                changeRetry()
            }
        }
    }

    private fun unzipFile() {
        val zipFilePath = FilePathHelper.getResourceZipPath()
        val unzipDirectory = FilePathHelper.getResourceDirectory()
        val zipFile = File(zipFilePath)
        if (!zipFile.exists()) {
            //资源压缩包不存在
            changeRetry()
            return
        }
        val fileList = ZipUtils.unzipFile(zipFilePath, unzipDirectory)
        if (fileList.isNotEmpty()) {
            mStartUpViewModel.mEntranceLive.value = 1
        } else {
            //文件解压失败
            changeRetry()
        }
    }

    private fun changeRetry() {
        pbDownload.visibility = View.GONE
        tvProgress.visibility = View.GONE
        btRetry.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance(url: String): ResourceUpdateFragment {
            val fragment = ResourceUpdateFragment()
            val arguments = Bundle()
            arguments.putString("URL", url)
            fragment.arguments = arguments
            return fragment
        }
    }
}