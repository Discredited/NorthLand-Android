package com.june.northland.base.component

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.june.northland.R
import com.june.northland.base.ext.click

class NLDelegate(val activity: AppCompatActivity) : LifecycleObserver {

    init {
        activity.lifecycle.addObserver(this)
    }

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

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mLoadingView = null
    }
}