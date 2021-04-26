package com.june.northland.feature.main.email

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemEmailBinding

class EmailAdapter :
    BaseQuickAdapter<EmailVo, BaseDataBindingHolder<ItemEmailBinding>>(R.layout.item_email) {

    override fun convert(holder: BaseDataBindingHolder<ItemEmailBinding>, item: EmailVo) {
        holder.dataBinding?.apply {
            tvEmailTitle.text = item.title
            tvEmailContent.text = item.content
        }
    }
}