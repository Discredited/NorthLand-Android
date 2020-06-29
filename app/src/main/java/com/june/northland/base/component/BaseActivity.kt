package com.june.northland.base.component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.june.northland.base.dialog.LoadingDialog

abstract class BaseActivity : AppCompatActivity() {

    private var mLoadingDialog: LoadingDialog? = null
    lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        setContentView(getLayoutResId())
        initView()
        loadData()
    }

    override fun onDestroy() {
        if (mLoadingDialog?.isShowing == true) {
            mLoadingDialog?.dismiss()
        }
        mLoadingDialog = null
        super.onDestroy()
    }

    fun showLoading(isCancelable: Boolean = true) {
        if (null == mLoadingDialog) {
            mLoadingDialog = LoadingDialog(this)
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

    /**
     * 获取布局资源文件ID
     *
     * @return
     */
    protected abstract fun getLayoutResId(): Int

    /**
     * 初始化View
     */
    protected abstract fun initView()

    /**
     * 加载数据
     */
    protected abstract fun loadData()
}