package com.nl.module.role.list

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadImage
import com.nl.component.ext.setDrawable
import com.nl.lib.element.enum.QualityEnum
import com.nl.lib.element.role.RoleEntity
import com.nl.module.role.R
import com.nl.module.role.databinding.ItemRoleBinding

/**
 * 角色列表Adapter
 *
 * 2022/4/4
 * @author June
 */
class RoleListAdapter : BaseQuickAdapter<RoleEntity, BaseDataBindingHolder<ItemRoleBinding>>(R.layout.item_role) {

    override fun convert(holder: BaseDataBindingHolder<ItemRoleBinding>, item: RoleEntity) {
        holder.dataBinding?.apply {
            val color = ContextCompat.getColor(holder.itemView.context, QualityEnum.getQualityColor(item.quality))
            ivAvatar.loadImage(FilePathHelper.getCharacterAvatar(item.avatar))
            ivPower.setDrawable(bgColor = color)
            tvName.text = item.name
        }
    }
}