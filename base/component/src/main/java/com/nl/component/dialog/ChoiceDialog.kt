package com.nl.component.dialog

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseDialog
import com.nl.component.R
import com.nl.component.databinding.DialogChoiceBinding
import timber.log.Timber

class ChoiceDialog(context: Context, theme: Int = 0) :
    BaseDialog<DialogChoiceBinding>(context, theme) {

    private var mTitle: CharSequence? = null
    private var mContent: CharSequence? = null

    private var mSureClickListener: DialogInterface.OnClickListener? = null
    private var mCancelClickListener: DialogInterface.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_choice)

        Timber.w("ChoiceDialog -- onCreate")

        mBinding.btSure.click { mSureClickListener?.onClick(this, it.id) }
        mBinding.btCancel.click {
            mCancelClickListener?.onClick(this, it.id)
            dismiss()
        }
    }

    override fun show() {
        Timber.w("ChoiceDialog -- show before")
        super.show()
        Timber.w("ChoiceDialog -- show after")
        mBinding.tvTitle.text = mTitle
        mBinding.tvContent.text = mContent
    }

    fun setChoiceTitle(title: CharSequence) {
        mTitle = title
    }

    fun setChoiceContent(content: CharSequence) {
        mContent = content
    }

    fun setChoiceSureListener(listener: DialogInterface.OnClickListener) {
        mSureClickListener = listener
    }

    fun setChoiceCancelListener(listener: DialogInterface.OnClickListener) {
        mCancelClickListener = listener
    }
}