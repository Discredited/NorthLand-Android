package com.nl.module.characters.detail

import android.annotation.SuppressLint
import android.os.Bundle
import com.nl.component.NLBaseFragment
import com.nl.module.characters.R
import com.nl.module.characters.databinding.FragmentCharacterInfoBinding

/**
 * 基本信息
 */
class CharacterInfoFragment : NLBaseFragment<FragmentCharacterInfoBinding>() {

    override fun initView() {

        mBinding.vBasicAttribute.initAttributeIcon(
            R.drawable.ic_health,
            R.drawable.ic_speed,
            R.drawable.ic_attack,
            R.drawable.ic_defense,
            "基本属性"
        )

        mBinding.vExtraAttribute.initAttributeIcon(
            R.drawable.ic_critical,
            R.drawable.ic_resister,
            R.drawable.ic_hit,
            R.drawable.ic_dodge,
            "额外属性"
        )
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.tvCharacterPower.setRealm(8, "末那")
        mBinding.tvCharacterRealm.setRealm(5, "空")
        mBinding.vCharacterExperience.initExperience(20, 30, 100, 20)

        mBinding.vBasicAttribute.setAttributeValue("2500", "110", "950", "600")
        mBinding.vExtraAttribute.setAttributeValue("35", "10", "200", "75")

        mBinding.vRelationshipDisplay.setRelationships(
            mutableListOf(
                com.nl.module.relationship.RelationshipVo(
                    "丽人行",
                    true
                ),
                com.nl.module.relationship.RelationshipVo(
                    "青梅竹马",
                    true
                ),
                com.nl.module.relationship.RelationshipVo(
                    "道心羁绊",
                    false
                ),
                com.nl.module.relationship.RelationshipVo(
                    "轮回毒誓",
                    false
                ),
                com.nl.module.relationship.RelationshipVo(
                    "同为人妖",
                    false
                ),
                com.nl.module.relationship.RelationshipVo(
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