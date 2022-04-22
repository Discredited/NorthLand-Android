package com.june.northland.feature.login.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.june.network.download.DownloadHelper
import com.june.network.download.ProgressListener
import com.june.northland.R
import com.june.northland.databinding.FragmentResourceUpdateBinding
import com.nl.component.NLBaseFragment
import com.nl.component.common.FilePathHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.FileOutputStream

/**
 * 资源更新
 */
class ResourceUpdateFragment : NLBaseFragment<FragmentResourceUpdateBinding>() {

    private val mStartUpViewModel by activityViewModels<StartUpViewModel>()

    override fun initView() {
        mBinding.tvProgress.text = getString(R.string.str_download_progress, 0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    mBinding.pbDownload.max = max.toInt()
                    mBinding.pbDownload.progress = progress.toInt()
                    mBinding.tvProgress.text = getString(R.string.str_download_progress, (percent * 100).toInt())
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                val url = "https://scpic.chinaz.net/files/pic/pic9/202204/apic40323.jpg"
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
        when (mStartUpViewModel.unzipResource()) {
            StartUpViewModel.UNZIP_FILE_ERROR, StartUpViewModel.UNZIP_FILE_NOT_EXIST -> changeRetry()
            else ->  mStartUpViewModel.mEntranceLive.value = StartUpViewModel.GRAPH_DATABASE_CHECK
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