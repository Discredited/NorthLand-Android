package com.nl.component

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.june.base.basic.part.BaseFragment

abstract class NLBaseFragment<V : ViewBinding> : BaseFragment<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(requireActivity() as AppCompatActivity) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    abstract fun initView()

    override fun onResume() {
        super.onResume()
        initImmersionBar()
    }

    private fun initImmersionBar() {
        ImmersionBar.with(this)
            .transparentNavigationBar()      //透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
            .fullScreen(true)     //有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
            .hideBar(BarHide.FLAG_HIDE_BAR)  //隐藏状态栏或导航栏或两者，不写默认不隐藏
            .init()
    }

    fun showLoading(
        isAllowDismiss: Boolean = false,
        loadingText: String? = null
    ) {
        mDelegate?.showLoading(isAllowDismiss, loadingText)
    }

    fun hideLoading() {
        mDelegate?.hideLoading()
    }
}