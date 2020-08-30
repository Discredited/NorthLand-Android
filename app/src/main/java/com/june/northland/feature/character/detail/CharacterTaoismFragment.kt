package com.june.northland.feature.character.detail

import com.june.northland.base.component.BaseFragment

/**
 * 道心
 */
class CharacterTaoismFragment : BaseFragment() {
    override fun getLayoutResId(): Int = 0

    override fun initView() {
    }

    companion object {
        fun newInstance(): CharacterTaoismFragment {
            return CharacterTaoismFragment()
        }
    }
}