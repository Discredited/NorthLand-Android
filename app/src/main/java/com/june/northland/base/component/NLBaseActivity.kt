package com.june.northland.base.component

import androidx.viewbinding.ViewBinding
import com.june.base.basic.part.BaseActivity

abstract class NLBaseActivity<V : ViewBinding> : BaseActivity<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(this) }

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