package com.june.northland.feature.main.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.dungeon.DungeonVo
import kotlinx.android.synthetic.main.item_main_scenes_plot.view.*

class ScenesPlotAdapter : BaseQuickAdapter<DungeonVo, BaseViewHolder>(R.layout.item_main_scenes_plot) {

    override fun convert(holder: BaseViewHolder, item: DungeonVo) {
        holder.itemView.tvPlotName.text = item.dungeonName
        holder.itemView.ivPlotImage.setImageResource(item.dungeonIcon)
    }
}