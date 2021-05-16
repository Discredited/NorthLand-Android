package com.june.northland.feature.relationship

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemRelationshipDisplayBinding
import com.nl.module.relationship.RelationshipVo

class RelationshipDisplayAdapter :
    BaseQuickAdapter<RelationshipVo, BaseDataBindingHolder<ItemRelationshipDisplayBinding>>(R.layout.item_relationship_display) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemRelationshipDisplayBinding>,
        item: RelationshipVo
    ) {
        holder.dataBinding?.apply {
            relationshipName.text = item.name
            relationshipName.isSelected = item.isActive
        }
    }
}