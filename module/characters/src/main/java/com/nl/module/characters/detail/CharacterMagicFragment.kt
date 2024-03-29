package com.nl.module.characters.detail

import android.os.Bundle
import com.nl.component.NLBaseFragment
import com.nl.module.characters.R
import com.nl.module.characters.databinding.FragmentCharacterMagicBinding

/**
 * 秘籍
 */
class CharacterMagicFragment : NLBaseFragment<FragmentCharacterMagicBinding>() {

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.vMagicDisplay.setMagic(
            mutableListOf(
                com.nl.module.magic.MagicVo(
                    "兵器甲御术",
                    "肢体任意化作攻击武器，造成(攻击力*225%)伤害值",
                    1,
                    R.drawable.ic_magic_1
                ),
                com.nl.module.magic.MagicVo(
                    "龙蝶爪",
                    "龙蝶利爪齐齐探出，造成(攻击力*210%*利爪数量)伤害值",
                    1,
                    R.drawable.ic_magic_2
                ),
                com.nl.module.magic.MagicVo(
                    "身外化身",
                    "可以化身出另外一个一样的自己，攻击、防御、生命值伤害值增加100%",
                    1,
                    R.drawable.ic_magic_3
                )
            )
        )
    }

    companion object {
        fun newInstance(): CharacterMagicFragment {
            return CharacterMagicFragment()
        }
    }
}