package com.june.northland.feature.login.start.debug

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemDebugListBinding

/**
 * DebugListAdapter
 *
 * 2022/4/3
 * @author June
 */
class DebugListAdapter :
    BaseQuickAdapter<DebugVo, BaseDataBindingHolder<ItemDebugListBinding>>(R.layout.item_debug_list) {

    override fun convert(holder: BaseDataBindingHolder<ItemDebugListBinding>, item: DebugVo) {
        holder.dataBinding?.apply {
            tvDebugName.text = item.name
        }
    }
}