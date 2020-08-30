package com.june.northland.feature.character.detail

import android.os.Bundle
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.feature.relationship.RelationshipVo
import kotlinx.android.synthetic.main.fragment_character_info.*

/**
 * 基本信息
 */
class CharacterInfoFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_character_info

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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvCharacterPower.setRealm(8, "末那")
        tvCharacterRealm.setRealm(5, "空")
        vCharacterExperience.initExperience(20, 30, 100, 20)

        vBasicAttribute.setAttributeValue("2500", "110", "950", "600")
        vExtraAttribute.setAttributeValue("35", "10", "200", "75")

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

    companion object {
        fun newInstance(): CharacterInfoFragment {
            return CharacterInfoFragment()
        }
    }
}