package com.june.northland.feature.main.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.main.vo.PlotVo
import kotlinx.android.synthetic.main.item_main_scenes_plot.view.*

class ScenesPlotAdapter : BaseQuickAdapter<PlotVo, BaseViewHolder>(R.layout.item_main_scenes_plot) {

    override fun convert(holder: BaseViewHolder, item: PlotVo) {
        holder.itemView.tvPlotName.text = item.plotName
        holder.itemView.ivPlotImage.setImageResource(item.plotIcon)
    }
}