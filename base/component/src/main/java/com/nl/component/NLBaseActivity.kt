package com.nl.component

import android.annotation.SuppressLint
import android.os.Bundle
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