package com.june.northland.feature.login.start

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.june.base.basic.part.BaseFragment
import com.june.network.download.DownloadHelper
import com.june.network.download.ProgressListener
import com.june.northland.R
import com.june.northland.databinding.FragmentResourceUpdateBinding
import com.nl.component.common.FilePathHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    @SuppressLint("MissingSuperCall")
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
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    mBinding.pbDownload.max = max.toInt()
                    mBinding.pbDownload.progress = progress.toInt()
                    mBinding.tvProgress.text = getString(R.string.str_download_progress, (percent * 100).toInt())
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                val url =
                    "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%BE%8E%E5%A5%B3%E5%9B%BE%E7%89%87&step_word=&hs=2&pn=4&spn=0&di=2310&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1198515731%2C2858437893&os=309350109%2C2001896382&simid=4280844156%2C825302080&adpicid=0&lpn=0&ln=2524&fr=&fmq=1619447873696_R&fm=&ic=undefined&s=undefined&hd=1&latest=0&copyright=0&se=&sme=&tab=0&width=1920&height=1080&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201303%2F09%2F013421i9un6uj4f3m3f9ii.jpg%26refer%3Dhttp%3A%2F%2Fattach.bbs.miui.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1622039908%26t%3Db37d3b14372057862c1db026c4885c3f&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B4t7t_z%26e3Bv54AzdH3Fpi6jw1-8an9c8l-8-llc_z%26e3Bip4s&gsm=5&rpstart=0&rpnum=0&islist=&querylist=&force=undefined"
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