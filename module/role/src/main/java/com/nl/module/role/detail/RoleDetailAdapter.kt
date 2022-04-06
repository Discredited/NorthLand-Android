package com.nl.module.role.detail

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.ext.setDrawable
import com.nl.module.role.R
import com.nl.module.role.databinding.ItemRoleAttributeBinding
import com.nl.module.role.detail.attr.RoleAttrVo

/**
 * 角色详情适配器
 *
 * 2022/4/5
 * @author June
 */
class RoleDetailAdapter(
    private val bgColor: Int,
    private val bgColorLight: Int
) : BaseQuickAdapter<RoleAttrVo, BaseDataBindingHolder<ItemRoleAttributeBinding>>(R.layout.item_role_attribute) {

    override fun convert(holder: BaseDataBindingHolder<ItemRoleAttributeBinding>, item: RoleAttrVo) {
        val position = holder.layoutPosition
        val color = if (position % 2 == 0) {
            bgColor
        } else {
            bgColorLight
        }
        holder.dataBinding?.apply {
            llAttrContainer.setDrawable(color, cornerRadius = 0F)
            tvAttrName.text = item.getNameColon()
            tvAttrValue.text = item.value
        }
    }
}