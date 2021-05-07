package com.june.northland.feature.character.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.base.basic.part.BaseFragment
import com.june.northland.databinding.FragmentCharacterTaoismBinding

/**
 * 道心
 */
class CharacterTaoismFragment : BaseFragment<FragmentCharacterTaoismBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCharacterTaoismBinding {
        return FragmentCharacterTaoismBinding.inflate(inflater, container, false)
    }

    override fun initView() {
    }

    companion object {
        fun newInstance(): CharacterTaoismFragment {
            return CharacterTaoismFragment()
        }
    }
}