package com.june.northland.feature.login.start.announcement

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_announcement.view.*

class AnnouncementAdapter : BaseQuickAdapter<AnnouncementVo, BaseViewHolder>(R.layout.item_announcement) {

    override fun convert(holder: BaseViewHolder, item: AnnouncementVo) {
        holder.itemView.tvAnnounceTitle.text = item.title
        holder.itemView.tvAnnounceContent.text = item.content
    }
}