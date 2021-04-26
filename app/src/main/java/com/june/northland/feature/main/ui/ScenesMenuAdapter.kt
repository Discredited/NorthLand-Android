package com.june.northland.feature.main.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemMainScenesMenuBinding
import com.june.northland.feature.main.vo.MenuVo

class ScenesMenuAdapter :
    BaseQuickAdapter<MenuVo, BaseDataBindingHolder<ItemMainScenesMenuBinding>>(R.layout.item_main_scenes_menu) {

    override fun convert(holder: BaseDataBindingHolder<ItemMainScenesMenuBinding>, item: MenuVo) {
        holder.dataBinding?.apply {
            tvMenuName.text = item.menuName
            ivMenuIcon.setImageResource(item.menuIcon)
        }
    }
}