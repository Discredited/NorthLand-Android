package com.june.northland.feature.equipment.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class EquipmentDetailAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> EquipmentForgingFragment.newInstance()
            2 -> EquipmentIncreaseFragment.newInstance()
            3 -> EquipmentSpellFragment.newInstance()
            else -> EquipmentStrengthenFragment.newInstance()
        }
    }
}
