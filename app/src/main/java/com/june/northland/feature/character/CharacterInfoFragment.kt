package com.june.northland.feature.character

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import com.june.northland.feature.character.magic.MagicVo
import com.june.northland.feature.character.relationship.RelationshipVo
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.fragment_dialog_character_info.*
import kotlinx.android.synthetic.main.view_close_image.*

class CharacterInfoFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_character_info

    override fun initView() {
        vBasicAttribute.initAttributeIcon(
            R.drawable.ic_health,
            R.drawable.ic_speed,
            R.drawable.ic_attack,
            R.drawable.ic_defense,
            getString(R.string.str_basic_attributes)
        )

        vExtraAttribute.initAttributeIcon(
            R.drawable.ic_critical,
            R.drawable.ic_resister,
            R.drawable.ic_hit,
            R.drawable.ic_dodge,
            getString(R.string.str_extra_attributes)
        )

        ivClose.click { dismiss() }
        ivHelper.click {
            AttributeExplanationFragment().show(
                childFragmentManager,
                AttributeExplanationFragment::javaClass.name
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCharacter(CharacterVo())
    }

    private fun setCharacter(character: CharacterVo) {
        val realmColor = ContextCompat.getColor(requireContext(), ColorUtils.getRealmColor(5))
        vCollapsing.setContentScrimColor(realmColor)

        vCharacterDisplay.setCharacterAndWeapon(realmColor, character)

        tvCharacterName.text = character.name
        vCharacterExperience.initExperience(20, 30, 100, 20)

        vBasicAttribute.setAttributeValue("2500", "110", "950", "600")
        vExtraAttribute.setAttributeValue("35", "10", "200", "75")

        vSkillView.setSkill()

        vMagicDisplay.setMagic(
            mutableListOf(
                MagicVo("兵器甲御术", "肢体任意化作攻击武器，造成(攻击力*225%)伤害值", 1, R.drawable.ic_magic_1),
                MagicVo("龙蝶爪", "龙蝶利爪齐齐探出，造成(攻击力*210%*利爪数量)伤害值", 1, R.drawable.ic_magic_2),
                MagicVo("身外化身", "可以化身出另外一个一样的自己，攻击、防御、生命值伤害值增加100%", 1, R.drawable.ic_magic_3)
            )
        )

        vRelationshipDisplay.setRelationship(
            mutableListOf(
                RelationshipVo(
                    "丽人行",
                    true
                ),
                RelationshipVo(
                    "青梅竹马",
                    true
                ),
                RelationshipVo(
                    "道心羁绊",
                    false
                ),
                RelationshipVo(
                    "轮回毒誓",
                    false
                ),
                RelationshipVo(
                    "同为人妖",
                    false
                ),
                RelationshipVo(
                    "七窍雪莲",
                    true
                )
            )
        )
    }
}