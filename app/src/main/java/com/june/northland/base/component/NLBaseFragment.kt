package com.june.northland.base.component

import androidx.viewbinding.ViewBinding
import com.june.base.basic.part.BaseFragment

abstract class NLBaseFragment<V : ViewBinding> : BaseFragment<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(requireActivity()) }

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