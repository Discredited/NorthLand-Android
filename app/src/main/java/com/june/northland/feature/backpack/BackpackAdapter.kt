package com.june.northland.feature.backpack

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.june.northland.feature.backpack.goods.GoodsListFragment
import com.nl.module.magic.backpack.MagicListFragment
import com.nl.module.soul.backpack.SoulListFragment
import com.nl.module.equipment.backpack.EquipmentListFragment

class BackpackAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> EquipmentListFragment.newInstance()
            2 -> MagicListFragment.newInstance()
            3 -> com.nl.module.soul.backpack.SoulListFragment.newInstance()
            else -> GoodsListFragment.newInstance(0)
        }
    }
}