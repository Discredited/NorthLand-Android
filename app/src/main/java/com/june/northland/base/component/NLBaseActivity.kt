package com.june.northland.base.component

import androidx.viewbinding.ViewBinding
import com.june.base.basic.part.BaseActivity
import com.june.northland.R

abstract class NLBaseActivity<V : ViewBinding> : BaseActivity<V>() {

    private var mLoadingView: LoadingView? = null

    fun showLoading(loadingText: String? = null) {
        if (null == mLoadingView) {
            mLoadingView = mBinding.root.findViewById(R.id.v_loading)
            if (null == mLoadingView) {
                mLoadingView = LoadingView(this)
                mLoadingView!!.id = R.id.v_loading
            }
        }
        mLoadingView?.apply {
            setLoadingText(loadingText)
            if (!isShowing()) {
                show()
            }
        }
    }

    fun hideLoading() {

    }
}