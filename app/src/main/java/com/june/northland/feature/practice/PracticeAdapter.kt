package com.june.northland.feature.practice

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.june.northland.R
import com.june.northland.databinding.ItemPracticeBinding

class PracticeAdapter :
    BaseQuickAdapter<PracticeVo, BaseDataBindingHolder<ItemPracticeBinding>>(R.layout.item_practice) {

    override fun convert(holder: BaseDataBindingHolder<ItemPracticeBinding>, item: PracticeVo) {
        holder.dataBinding?.apply {
            ivPracticeCover.setImageResource(item.icon)
            tvPracticeName.text = item.name
        }
    }
}