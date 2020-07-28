package com.june.northland.feature.dungeon.piece

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.dungeon.DungeonVo
import kotlinx.android.synthetic.main.item_piece.view.*

class PieceAdapter : BaseQuickAdapter<DungeonVo, BaseViewHolder>(R.layout.item_piece) {

    override fun convert(holder: BaseViewHolder, item: DungeonVo) {
        holder.itemView.ivPieceCover.setImageResource(item.dungeonIcon)
        holder.itemView.tvPieceName.text = item.dungeonName
        holder.itemView.tvPieceSubtitle.text = item.dungeonSubtitle
        holder.itemView.tvPieceProcess.text = item.dungeonProgress
    }
}