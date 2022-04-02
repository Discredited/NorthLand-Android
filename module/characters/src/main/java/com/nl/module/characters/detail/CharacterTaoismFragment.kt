package com.nl.module.characters.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nl.component.NLBaseFragment
import com.nl.module.characters.databinding.FragmentCharacterTaoismBinding

/**
 * 道心
 */
class CharacterTaoismFragment : NLBaseFragment<FragmentCharacterTaoismBinding>() {

    override fun initView() {
    }

    companion object {
        fun newInstance(): CharacterTaoismFragment {
            return CharacterTaoismFragment()
        }
    }
}