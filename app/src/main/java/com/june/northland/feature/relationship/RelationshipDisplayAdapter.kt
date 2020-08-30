package com.june.northland.feature.relationship

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import kotlinx.android.synthetic.main.item_relationship_display.view.*

class RelationshipDisplayAdapter :
    BaseQuickAdapter<RelationshipVo, BaseViewHolder>(R.layout.item_relationship_display) {
    override fun convert(holder: BaseViewHolder, item: RelationshipVo) {
        holder.itemView.relationshipName.text = item.name
        holder.itemView.relationshipName.isSelected = item.isActive
    }
}