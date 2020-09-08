package com.june.northland.feature.equipment.increase

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.equipment.IncreaseVo
import kotlinx.android.synthetic.main.item_equipment_increase.view.*

class EquipmentIncreaseAdapter : BaseQuickAdapter<IncreaseVo, BaseViewHolder>(R.layout.item_equipment_increase) {

    override fun convert(holder: BaseViewHolder, item: IncreaseVo) {
        holder.itemView.tvIncrease.text = item.description
        holder.itemView.setDrawable(strokeColor = item.color)
    }
}