package com.june.northland.feature.login.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ZipUtils
import com.june.network.download.DownloadHelper
import com.june.network.download.ProgressListener
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.common.FilePathHelper
import com.june.northland.databinding.FragmentResourceUpdateBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

class ResourceUpdateFragment : BaseFragment<FragmentResourceUpdateBinding>() {

    private val mStartUpViewModel by activityViewModels<StartUpViewModel>()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentResourceUpdateBinding {
        return FragmentResourceUpdateBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.tvProgress.text = getString(R.string.str_download_progress, 0)
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
                        mBinding.pbDownload.max = max.toInt()
                        mBinding.pbDownload.progress = progress.toInt()
                        mBinding.tvProgress.text =
                            getString(R.string.str_download_progress, (percent * 100).toInt())
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
            mBinding.tvProgress.text = getString(R.string.str_unzip_resource)
            //测试代码  将asset的资源写入本地目录
            withContext(Dispatchers.IO) {
                val inputStream = resources.assets.open("resource.zip")
                val fileOutputStream = FileOutputStream(FilePathHelper.getResourceZipPath())
                inputStream.use {
                    it.copyTo(fileOutputStream)
                }
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
        //解压完成删除zip文件
        zipFile.delete()
        if (fileList.isNotEmpty()) {
            mStartUpViewModel.mEntranceLive.value = 1
        } else {
            //文件解压失败
            changeRetry()
        }
    }

    private fun changeRetry() {
        mBinding.pbDownload.visibility = View.GONE
        mBinding.tvProgress.visibility = View.GONE
        mBinding.btRetry.visibility = View.VISIBLE
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