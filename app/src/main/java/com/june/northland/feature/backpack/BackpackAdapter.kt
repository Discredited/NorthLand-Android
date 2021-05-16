package com.june.northland.feature.backpack

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nl.module.equipment.backpack.EquipmentListFragment
import com.june.northland.feature.backpack.goods.GoodsListFragment
import com.june.northland.feature.backpack.magic.MagicListFragment
import com.june.northland.feature.backpack.soul.SoulListFragment

class BackpackAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> com.nl.module.equipment.backpack.EquipmentListFragment.newInstance()
            2 -> MagicListFragment.newInstance()
            3 -> SoulListFragment.newInstance()
            else -> GoodsListFragment.newInstance(0)
        }
    }
}