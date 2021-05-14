package com.june.northland.base.component

import android.app.Activity
import android.view.ViewGroup
import android.widget.FrameLayout
import com.june.northland.R
import com.june.northland.base.ext.click

class NLDelegate(val activity: Activity) {

    private var mLoadingView: LoadingView? = null

    fun showLoading(
        isAllowDismiss: Boolean = false,
        loadingText: String? = null
    ) {
        if (null == mLoadingView) {
            val rootView: FrameLayout? = activity.findViewById(android.R.id.content)
            mLoadingView = rootView?.findViewById(R.id.v_loading)
            if (null == mLoadingView) {
                mLoadingView = LoadingView(activity)
                mLoadingView?.let { loading ->
                    loading.id = R.id.v_loading
                    loading.click {
                        if (isAllowDismiss) {
                            loading.hide()
                        }
                    }
                    rootView?.addView(
                        loading,
                        ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    )
                }
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
        if (mLoadingView?.isShowing() == true) {
            mLoadingView?.hide()
        }
    }
}