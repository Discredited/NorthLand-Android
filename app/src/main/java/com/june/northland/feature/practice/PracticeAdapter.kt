package com.june.northland.feature.practice

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_practice.view.*

class PracticeAdapter : BaseQuickAdapter<PracticeVo, BaseViewHolder>(R.layout.item_practice) {
    override fun convert(holder: BaseViewHolder, item: PracticeVo) {
        holder.itemView.ivPracticeCover.setImageResource(item.icon)
        holder.itemView.tvPracticeName.text = item.name
    }
}