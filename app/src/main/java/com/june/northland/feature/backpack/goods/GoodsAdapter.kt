package com.june.northland.feature.backpack.goods

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemGoodsBinding

class GoodsAdapter :
    BaseQuickAdapter<GoodsVo, BaseDataBindingHolder<ItemGoodsBinding>>(R.layout.item_goods) {

    override fun convert(holder: BaseDataBindingHolder<ItemGoodsBinding>, item: GoodsVo) {
        holder.dataBinding?.apply {
            ivGoodsAvatar.setImageResource(item.icon)
            tvGoodsName.text = item.name
            tvGoodsCount.text = item.count.toString()
        }
    }
}