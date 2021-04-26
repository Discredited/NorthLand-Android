package com.june.northland.feature.login.start.announcement

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemAnnouncementBinding

class AnnouncementAdapter :
    BaseQuickAdapter<AnnouncementVo, BaseDataBindingHolder<ItemAnnouncementBinding>>(R.layout.item_announcement) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemAnnouncementBinding>,
        item: AnnouncementVo
    ) {
        holder.dataBinding?.apply {
            tvAnnounceTitle.text = item.title
            tvAnnounceContent.text = item.content
        }
    }
}