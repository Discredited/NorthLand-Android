package com.june.northland.feature.login.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.june.network.download.DownloadHelper
import com.june.network.download.ProgressListener
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.common.FilePathHelper
import kotlinx.android.synthetic.main.fragment_resource_update.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                        tvProgress.text = getString(R.string.str_download_progress, percent.toInt())
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                val url =
                    "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1827484078,582503147&fm=26&gp=0.jpg"
                val filePath = "${FilePathHelper.getAppExternalDirectory()}/TempImage.jpg"
                downloadHelper.startDownload(url, filePath)
            }
            result?.let {
                mStartUpViewModel.mEntranceLive.value = 1
            }
            if (null == result) {
                changeRetry()
            }
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