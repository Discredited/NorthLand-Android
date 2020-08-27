package com.june.northland.base.dialog

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.june.northland.R

class LoadingDialog(context: Context, theme: Int = R.style.LoadingDialog) : AppCompatDialog(context, theme) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }
}