package com.june.northland.feature.dungeon

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_dungeon.view.*

class DungeonAdapter : BaseQuickAdapter<DungeonVo, BaseViewHolder>(R.layout.item_dungeon) {

    override fun convert(holder: BaseViewHolder, item: DungeonVo) {
        holder.itemView.tvDungeonTitle.text = "${item.subsection}-${item.title}"
        holder.itemView.tvDungeonCast.text = "消耗${item.raidCost}点体力"
        holder.itemView.vDungeonEvaluate
    }
}