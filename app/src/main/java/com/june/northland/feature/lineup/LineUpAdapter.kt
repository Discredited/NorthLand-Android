package com.june.northland.feature.lineup

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemLineUpBinding

class LineUpAdapter :
    BaseQuickAdapter<LineUpVo, BaseDataBindingHolder<ItemLineUpBinding>>(R.layout.item_line_up) {

    override fun convert(holder: BaseDataBindingHolder<ItemLineUpBinding>, item: LineUpVo) {
        holder.dataBinding?.apply {
            tvLineUpPosition.text = holder.layoutPosition.toString()
            if (item.isActive) {
                ivLineUpCover.setImageResource(item.coverRes)
                val color =
                    ContextCompat.getColor(holder.itemView.context, R.color.color_transparent)
                ivLineUpCover.setBackgroundColor(color)
            } else {
                ivLineUpCover.setImageResource(0)
                val color = ContextCompat.getColor(holder.itemView.context, R.color.color_gray)
                ivLineUpCover.setBackgroundColor(color)
            }
        }
    }
}