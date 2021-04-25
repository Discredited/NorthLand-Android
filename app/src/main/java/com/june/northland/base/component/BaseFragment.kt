package com.june.northland.base.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.june.northland.base.dialog.LoadingDialog
import timber.log.Timber

abstract class BaseFragment<V : ViewBinding> : Fragment() {

    private var _binding: V? = null
    protected val mBinding get() = _binding!!

    private var mLoadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.v("----${javaClass.simpleName}:onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.v("----${javaClass.simpleName}:onCreateView")
        _binding = viewBinding(inflater, container)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.fitsSystemWindows = fitsSystemWindows()
        super.onViewCreated(view, savedInstanceState)
        Timber.v("----${javaClass.simpleName}:onViewCreated")
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.v("----${javaClass.simpleName}:onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.v("----${javaClass.simpleName}:onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.v("----${javaClass.simpleName}:onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.v("----${javaClass.simpleName}:onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.v("----${javaClass.simpleName}:onStop")
    }

    override fun onDestroyView() {
        if (mLoadingDialog?.isShowing == true) {
            mLoadingDialog?.dismiss()
        }
        mLoadingDialog = null
        super.onDestroyView()
        Timber.v("----${javaClass.simpleName}:onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.v("----${javaClass.simpleName}:onDestroy")
    }

    fun showLoading(isCancelable: Boolean = true) {
        if (null == mLoadingDialog) {
            mLoadingDialog = LoadingDialog(requireActivity())
        }
        if (!isCancelable) {
            mLoadingDialog?.setCancelable(isCancelable)
            mLoadingDialog?.setCanceledOnTouchOutside(isCancelable)
        }
        if (mLoadingDialog?.isShowing == true) {
            mLoadingDialog?.dismiss()
        }
        mLoadingDialog?.show()
    }

    fun hideLoading() {
        if (mLoadingDialog?.isShowing == true) {
            mLoadingDialog?.dismiss()
        }
    }

    protected abstract fun viewBinding(inflater: LayoutInflater, container: ViewGroup?): V

    /**
     * 初始化View
     */
    protected abstract fun initView()

    protected open fun fitsSystemWindows(): Boolean = true
}