package com.nl.component

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding
import com.june.base.basic.part.BaseActivity

abstract class NLBaseActivity<V : ViewBinding> : BaseActivity<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(this) }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        loadData()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        systemUiFlag()
    }

    /**
     * 全屏模式标记设置
     */
    private fun systemUiFlag() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
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