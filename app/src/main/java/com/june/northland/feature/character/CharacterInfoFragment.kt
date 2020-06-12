package com.june.northland.feature.character

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.ext.setDrawable
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.fragment_dialog_character_info.*

class CharacterInfoFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_character_info

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCharacter(CharacterVo())
    }

    private fun setCharacter(character: CharacterVo) {
        val realmColor = ColorUtils.getRealmColor(8)
        ivCharacterAvatar.setDrawable(strokeColor = realmColor)
        tvCharacterName.text = character.name
        tvCharacterRealm.setTextColor(ContextCompat.getColor(requireContext(), realmColor))
        tvCharacterRealm.text = "末那"
        tvCharacterRace.text = "人族"
        tvCharacterFaction.text = "清虚天"

        tvCharacterHealth.text = "2500"
        tvCharacterSpeed.text = "110"
        tvCharacterAttack.text = "950"
        tvCharacterDefense.text = "600"
    }
}