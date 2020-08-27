package com.june.northland.feature.main.email

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_email.view.*

class EmailAdapter : BaseQuickAdapter<EmailVo, BaseViewHolder>(R.layout.item_email) {

    override fun convert(holder: BaseViewHolder, item: EmailVo) {
        holder.itemView.tvEmailTitle.text = item.title
        holder.itemView.tvEmailContent.text = item.content
    }
}