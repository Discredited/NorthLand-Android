package com.june.northland.feature.plot

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.main.vo.PlotVo
import kotlinx.android.synthetic.main.item_plot.view.*

class PlotAdapter : BaseQuickAdapter<PlotVo, BaseViewHolder>(R.layout.item_plot) {

    override fun convert(holder: BaseViewHolder, item: PlotVo) {
        holder.itemView.ivPlotCover.setImageResource(item.plotIcon)
        holder.itemView.tvPlotName.text = item.plotName
        holder.itemView.tvPlotProcess.text = item.plotProgress
    }
}