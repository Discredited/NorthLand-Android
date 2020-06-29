package com.june.northland.base.dialog

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.june.northland.R
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.dialog_choice.*
import timber.log.Timber

class ChoiceDialog(context: Context, theme: Int = 0) : AppCompatDialog(context, theme) {

    private var mTitle: CharSequence? = null
    private var mContent: CharSequence? = null

    private var mSureClickListener: DialogInterface.OnClickListener? = null
    private var mCancelClickListener: DialogInterface.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_choice)

        Timber.w("ChoiceDialog -- onCreate")

        btSure.click { mSureClickListener?.onClick(this, it.id) }
        btCancel.click {
            mCancelClickListener?.onClick(this, it.id)
            dismiss()
        }
    }

    override fun show() {
        Timber.w("ChoiceDialog -- show before")
        super.show()
        Timber.w("ChoiceDialog -- show after")
        tvTitle.text = mTitle
        tvContent.text = mContent
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