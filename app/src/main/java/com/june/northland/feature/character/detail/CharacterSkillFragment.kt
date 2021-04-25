package com.june.northland.feature.character.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.northland.base.component.BaseFragment
import com.june.northland.databinding.FragmentCharacterSkillBinding
import kotlinx.android.synthetic.main.fragment_character_skill.*

/**
 * 技能
 */
class CharacterSkillFragment : BaseFragment<FragmentCharacterSkillBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCharacterSkillBinding {
        return FragmentCharacterSkillBinding.inflate(inflater, container, false)
    }

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vSkillPassive.setSkill()
        vSkillInitiative.setSkill()
    }

    companion object {
        fun newInstance(): CharacterSkillFragment {
            return CharacterSkillFragment()
        }
    }
}