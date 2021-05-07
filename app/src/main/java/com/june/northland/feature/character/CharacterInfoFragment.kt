package com.june.northland.feature.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.base.basic.part.BaseDialogFragment
import com.june.northland.base.ext.click
import com.june.northland.databinding.FragmentDialogCharacterInfoBinding
import com.june.northland.feature.magic.MagicVo
import com.june.northland.feature.relationship.RelationshipVo
import com.june.northland.utils.ColorUtils

class CharacterInfoFragment : BaseDialogFragment<FragmentDialogCharacterInfoBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDialogCharacterInfoBinding {
        return FragmentDialogCharacterInfoBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mBinding.vBasicAttribute.initAttributeIcon(
            R.drawable.ic_health,
            R.drawable.ic_speed,
            R.drawable.ic_attack,
            R.drawable.ic_defense,
            getString(R.string.str_basic_attributes)
        )

        mBinding.vExtraAttribute.initAttributeIcon(
            R.drawable.ic_critical,
            R.drawable.ic_resister,
            R.drawable.ic_hit,
            R.drawable.ic_dodge,
            getString(R.string.str_extra_attributes)
        )

        mBinding.iClose.ivClose.click { dismiss() }
        mBinding.ivHelper.click {
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
        val realm = arguments?.getInt("REALM", 8) ?: 8
        val realmColor = ContextCompat.getColor(requireContext(), ColorUtils.getPowerColor(realm))
        mBinding.vCollapsing.setContentScrimColor(realmColor)

        mBinding.vCharacterDisplay.setCharacterAndEquipment(realmColor, character)

        mBinding.tvCharacterName.text = character.name
        mBinding.vCharacterExperience.initExperience(20, 30, 100, 20)

        mBinding.vBasicAttribute.setAttributeValue("2500", "110", "950", "600")
        mBinding.vExtraAttribute.setAttributeValue("35", "10", "200", "75")

        mBinding.vSkillView.setSkill()

        mBinding.vMagicDisplay.setMagic(
            mutableListOf(
                MagicVo("兵器甲御术", "肢体任意化作攻击武器，造成(攻击力*225%)伤害值", 1, R.drawable.ic_magic_1),
                MagicVo("龙蝶爪", "龙蝶利爪齐齐探出，造成(攻击力*210%*利爪数量)伤害值", 1, R.drawable.ic_magic_2),
                MagicVo("身外化身", "可以化身出另外一个一样的自己，攻击、防御、生命值伤害值增加100%", 1, R.drawable.ic_magic_3)
            )
        )

        mBinding.vRelationshipDisplay.setRelationship(
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

    companion object {
        fun newInstance(realm: Int): CharacterInfoFragment {
            val arguments = Bundle()
            arguments.putInt("REALM", realm)
            val fragment = CharacterInfoFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}