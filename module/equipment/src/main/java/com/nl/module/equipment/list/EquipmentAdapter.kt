package com.nl.module.equipment.list

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadImage
import com.nl.component.ext.setDrawableWithStroke
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.ItemEquipmentBinding

class EquipmentAdapter :
    BaseQuickAdapter<EquipmentVo, BaseDataBindingHolder<ItemEquipmentBinding>>(R.layout.item_equipment) {

    override fun convert(holder: BaseDataBindingHolder<ItemEquipmentBinding>, item: EquipmentVo) {
        holder.dataBinding?.apply {
            val qualityColor = EquipmentHelper.equipmentQualityColor(item.quality)
            ivEquipmentIconBg.setDrawableWithStroke(strokeColor = qualityColor,)
            ivEquipmentIcon.loadImage(FilePathHelper.getEquipmentIcon(item.icon))
            tvEquipmentName.text = item.name
            tvEquipmentAttr.text = "${holder.layoutPosition * 3}"
            tvEquipmentAttrExtra.text = "攻击力+${item.value}"
        }
    }
}