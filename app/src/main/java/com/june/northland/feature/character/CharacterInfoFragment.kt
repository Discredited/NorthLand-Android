package com.june.northland.feature.character

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.fragment_dialog_character_info.*

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

        ivCharacterWeapon.click {
        }
        ivCharacterArmor.click {
        }
        ivCharacterShoes.click {
        }
        ivCharacterJewelry.click {
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCharacter(CharacterVo())
    }

    private fun setCharacter(character: CharacterVo) {
        val realmColor = ContextCompat.getColor(requireContext(), ColorUtils.getRealmColor(5))
        vCollapsing.setContentScrimColor(realmColor)

        ivCharacterAvatar.setDrawable(strokeColor = realmColor)
        tvCharacterName.text = character.name
        tvCharacterRealm.setTextColor(realmColor)
        tvCharacterRealm.text = "末那"

        vCharacterExperience.max = 100
        vCharacterExperience.progress = 30

        vBasicAttribute.setAttributeValue("2500","110","950","600")
        vExtraAttribute.setAttributeValue("35","10","200","75")

        vSkillView.setSkill()

        rvRelationship.setRelationship(
            mutableListOf(
                RelationshipVo("丽人行", true),
                RelationshipVo("青梅竹马", true),
                RelationshipVo("道心羁绊", false),
                RelationshipVo("轮回毒誓", false),
                RelationshipVo("同为人妖", false),
                RelationshipVo("七窍雪莲", true)
            )
        )
    }
}