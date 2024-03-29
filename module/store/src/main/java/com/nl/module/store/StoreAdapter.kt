package com.nl.module.store

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nl.module.store.recruit.RecruitActivityFragment
import com.nl.module.store.recruit.RecruitNormalFragment

class StoreAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> RecruitActivityFragment.newInstance()
            else -> RecruitNormalFragment.newInstance()
        }
    }
}