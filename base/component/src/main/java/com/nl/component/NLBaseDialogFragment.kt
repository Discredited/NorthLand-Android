package com.nl.component

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.june.base.basic.part.BaseDialogFragment

abstract class NLBaseDialogFragment<V : ViewBinding> : BaseDialogFragment<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(requireActivity() as AppCompatActivity) }

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