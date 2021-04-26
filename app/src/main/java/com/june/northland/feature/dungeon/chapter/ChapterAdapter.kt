package com.june.northland.feature.dungeon.chapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemChapterBinding

class ChapterAdapter :
    BaseQuickAdapter<ChapterVo, BaseDataBindingHolder<ItemChapterBinding>>(R.layout.item_chapter) {

    override fun convert(holder: BaseDataBindingHolder<ItemChapterBinding>, item: ChapterVo) {
        holder.dataBinding?.apply {
            ivChapterCover.setImageResource(item.icon)
            tvChapterName.text = item.title
            tvChapterSubtitle.text = item.subtitle
            tvChapterProcess.text = item.progress

            if (item.isUnlock) {
                tvChapterMask.visibility = View.GONE
            } else {
                tvChapterMask.visibility = View.VISIBLE
            }
        }
    }
}