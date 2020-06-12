package com.june.northland.base.component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        setContentView(getLayoutResId())
        initView()
        loadData()
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