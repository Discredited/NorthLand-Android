package com.nl.module.characters.detail

import android.os.Bundle
import com.nl.component.NLBaseFragment
import com.nl.module.characters.databinding.FragmentCharacterSkillBinding

/**
 * 技能
 */
class CharacterSkillFragment : NLBaseFragment<FragmentCharacterSkillBinding>() {

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.vSkillPassive.setSkill()
        mBinding.vSkillInitiative.setSkill()
    }

    companion object {
        fun newInstance(): CharacterSkillFragment {
            return CharacterSkillFragment()
        }
    }
}