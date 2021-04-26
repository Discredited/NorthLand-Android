package com.june.northland.base.component

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<V : ViewBinding>(
    context: Context,
    theme: Int = 0
) : AppCompatDialog(context, theme) {

    private var _binding: V? = null
    protected val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = viewBinding(layoutInflater)
        setContentView(mBinding.root)
    }

    protected abstract fun viewBinding(inflater: LayoutInflater): V
}