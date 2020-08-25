package com.june.northland.feature.login.start

import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.fragment_dialog_announcement.*

class AnnouncementFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_announcement

    override fun initView() {
        btSure.click { dismiss() }
    }

    companion object {
        fun newInstance(): AnnouncementFragment {
            return AnnouncementFragment()
        }
    }
}