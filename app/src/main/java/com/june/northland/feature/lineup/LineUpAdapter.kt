package com.june.northland.feature.lineup

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_line_up.view.*

class LineUpAdapter : BaseQuickAdapter<LineUpVo, BaseViewHolder>(R.layout.item_line_up) {

    override fun convert(holder: BaseViewHolder, item: LineUpVo) {
        if (item.isActive) {
            holder.itemView.ivLineUpCover.setImageResource(item.coverRes)
        } else {
            val color = ContextCompat.getColor(holder.itemView.context, R.color.color_gray)
            holder.itemView.ivLineUpCover.setBackgroundColor(color)
        }
    }
}