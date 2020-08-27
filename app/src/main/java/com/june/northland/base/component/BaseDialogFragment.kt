package com.june.northland.base.component

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.june.northland.base.dialog.LoadingDialog

abstract class BaseDialogFragment : DialogFragment() {

    private var mLoadingDialog: LoadingDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        super.onActivityCreated(savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(0x00000000))
        dialog?.window?.setGravity(layoutGravity())
        dialog?.window?.setLayout(
            layoutParamsWidth(),
            layoutParamsHeight()
        )
    }

    override fun onDestroyView() {
        if (mLoadingDialog?.isShowing == true) {
            mLoadingDialog?.dismiss()
        }
        mLoadingDialog = null
        super.onDestroyView()
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

    abstract fun getLayoutResId(): Int

    abstract fun initView()

    open fun layoutParamsWidth() = WindowManager.LayoutParams.MATCH_PARENT

    open fun layoutParamsHeight() = WindowManager.LayoutParams.MATCH_PARENT

    open fun layoutGravity() = Gravity.CENTER
}