package com.nl.module.pokedex.equipment

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadImage
import com.nl.lib.element.equipment.EquipmentEntity
import com.nl.module.pokedex.R
import com.nl.module.pokedex.databinding.ItemEquipmentPokedexBinding

class EquipmentPokedexAdapter :
    BaseQuickAdapter<EquipmentEntity, BaseDataBindingHolder<ItemEquipmentPokedexBinding>>(R.layout.item_equipment_pokedex) {

    override fun convert(holder: BaseDataBindingHolder<ItemEquipmentPokedexBinding>, item: EquipmentEntity) {
        holder.dataBinding?.apply {
            ivEquipmentIcon.loadImage(FilePathHelper.getEquipmentIcon(item.icon))
        }
    }
}