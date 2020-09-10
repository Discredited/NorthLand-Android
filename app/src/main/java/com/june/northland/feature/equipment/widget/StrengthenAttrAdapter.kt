package com.june.northland.feature.equipment.widget

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.equipment.strengthen.StrengthAdditionVo
import kotlinx.android.synthetic.main.item_strengthen_addition.view.*

class StrengthenAttrAdapter : BaseQuickAdapter<StrengthAdditionVo, BaseViewHolder>(R.layout.item_strengthen_addition) {
    
    override fun convert(holder: BaseViewHolder, item: StrengthAdditionVo) {
        if (holder.layoutPosition % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_yellow_light))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_transparent))
        }
        holder.itemView.tvAddition.text = item.description
        holder.itemView.btAdditionStatus.text = item.statusString
        holder.itemView.btAdditionStatus.isEnabled = item.statusEnable
    }
}