package com.nl.module.characters.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CharacterDetailAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> CharacterSkillFragment.newInstance()
            2 -> CharacterMagicFragment.newInstance()
            3 -> CharacterTaoismFragment.newInstance()
            else -> CharacterInfoFragment.newInstance()
        }
    }
}