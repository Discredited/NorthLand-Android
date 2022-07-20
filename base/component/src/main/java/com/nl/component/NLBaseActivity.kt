package com.nl.component

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.june.base.basic.part.BaseActivity

abstract class NLBaseActivity<V : ViewBinding> : BaseActivity<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(this) }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initImmersionBar()
        initView()
        loadData()
    }

    private fun initImmersionBar() {
        ImmersionBar.with(this)
            .transparentNavigationBar()      //透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
            .fullScreen(true)     //有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
            .hideBar(BarHide.FLAG_HIDE_BAR)  //隐藏状态栏或导航栏或两者，不写默认不隐藏
            .init()
    }

    abstract fun initView()

    abstract fun loadData()

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