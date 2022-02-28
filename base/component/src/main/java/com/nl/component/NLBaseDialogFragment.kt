package com.nl.component

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.june.base.basic.part.BaseDialogFragment

abstract class NLBaseDialogFragment<V : ViewBinding> : BaseDialogFragment<V>() {

    private val mDelegate: NLDelegate? by lazy { NLDelegate(requireActivity() as AppCompatActivity) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
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