package com.june.northland.feature.backpack.goods

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_goods.view.*

class GoodsAdapter : BaseQuickAdapter<GoodsVo, BaseViewHolder>(R.layout.item_goods) {
    override fun convert(holder: BaseViewHolder, item: GoodsVo) {
        holder.itemView.ivGoodsAvatar.setImageResource(item.icon)
        holder.itemView.tvGoodsName.text = item.name
        holder.itemView.tvGoodsCount.text = item.count.toString()
    }
}