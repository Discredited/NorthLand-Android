package com.june.northland.feature.main.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.june.northland.R
import com.june.northland.feature.main.vo.MenuVo
import kotlinx.android.synthetic.main.item_main_scenes_menu.view.*

class ScenesMenuAdapter : BaseQuickAdapter<MenuVo, BaseViewHolder>(R.layout.item_main_scenes_menu) {

    override fun convert(holder: BaseViewHolder, item: MenuVo) {
        holder.itemView.tvMenuName.text = item.menuName
        holder.itemView.ivMenuIcon.setImageResource(item.menuIcon)
    }
}