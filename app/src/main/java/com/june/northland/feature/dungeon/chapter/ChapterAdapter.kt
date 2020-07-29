package com.june.northland.feature.dungeon.chapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_chapter.view.*

class ChapterAdapter : BaseQuickAdapter<ChapterVo, BaseViewHolder>(R.layout.item_chapter) {

    override fun convert(holder: BaseViewHolder, item: ChapterVo) {
        holder.itemView.ivChapterCover.setImageResource(item.icon)
        holder.itemView.tvChapterName.text = item.title
        holder.itemView.tvChapterSubtitle.text = item.subtitle
        holder.itemView.tvChapterProcess.text = item.progress
        if (item.isUnlock) {
            holder.itemView.tvChapterMask.visibility = View.GONE
        } else {
            holder.itemView.tvChapterMask.visibility = View.VISIBLE
        }
    }
}