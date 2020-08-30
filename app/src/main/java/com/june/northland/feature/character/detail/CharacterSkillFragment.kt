package com.june.northland.feature.character.detail

import android.os.Bundle
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import kotlinx.android.synthetic.main.fragment_character_skill.*

/**
 * 技能
 */
class CharacterSkillFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_character_skill

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