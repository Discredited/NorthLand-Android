package com.june.northland.feature.main.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemMainScenesPlotBinding
import com.june.northland.feature.dungeon.DungeonVo

class ScenesPlotAdapter :
    BaseQuickAdapter<DungeonVo, BaseDataBindingHolder<ItemMainScenesPlotBinding>>(R.layout.item_main_scenes_plot) {
    override fun convert(
        holder: BaseDataBindingHolder<ItemMainScenesPlotBinding>,
        item: DungeonVo
    ) {
        holder.dataBinding?.apply {
            tvPlotName.text = item.title
            ivPlotImage.setImageResource(item.icon)
        }
    }
}