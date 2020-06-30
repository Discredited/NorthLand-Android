package com.june.northland.feature.backpack

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.june.northland.feature.backpack.goods.GoodsListFragment
import com.june.northland.feature.character.equipment.EquipmentListFragment

class BackpackAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> EquipmentListFragment.newInstance()
            else -> GoodsListFragment.newInstance(0)
        }
    }
}