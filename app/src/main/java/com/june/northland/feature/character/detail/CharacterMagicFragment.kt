package com.june.northland.feature.character.detail

import android.os.Bundle
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.feature.magic.MagicVo
import kotlinx.android.synthetic.main.fragment_character_magic.*

/**
 * 秘籍
 */
class CharacterMagicFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_character_magic

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vMagicDisplay.setMagic(
            mutableListOf(
                MagicVo("兵器甲御术", "肢体任意化作攻击武器，造成(攻击力*225%)伤害值", 1, R.drawable.ic_magic_1),
                MagicVo("龙蝶爪", "龙蝶利爪齐齐探出，造成(攻击力*210%*利爪数量)伤害值", 1, R.drawable.ic_magic_2),
                MagicVo("身外化身", "可以化身出另外一个一样的自己，攻击、防御、生命值伤害值增加100%", 1, R.drawable.ic_magic_3)
            )
        )
    }

    companion object {
        fun newInstance(): CharacterMagicFragment {
            return CharacterMagicFragment()
        }
    }
}