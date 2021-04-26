package com.june.northland.feature.dungeon

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemDungeonBinding

class DungeonAdapter :
    BaseQuickAdapter<DungeonVo, BaseDataBindingHolder<ItemDungeonBinding>>(R.layout.item_dungeon) {

    override fun convert(holder: BaseDataBindingHolder<ItemDungeonBinding>, item: DungeonVo) {
        holder.dataBinding?.apply {
            tvDungeonTitle.text = "${item.subsection}-${item.title}"
            tvDungeonCast.text = "消耗${item.raidCost}点体力"
            vDungeonEvaluate
        }
    }
}