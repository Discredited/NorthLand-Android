package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.june.northland.R
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.character.weapon.WeaponChooseActivity
import com.june.northland.utils.Toast
import kotlinx.android.synthetic.main.widget_character_display_layout.view.*

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_character_display_layout, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        ivCharacterWeapon?.click { WeaponChooseActivity.starter(context,0) }
        ivCharacterWeapon?.setOnLongClickListener {
            Toast.toastShort("显示武器属性")
            true
        }
        ivCharacterArmor?.click { WeaponChooseActivity.starter(context,1) }
        ivCharacterArmor?.setOnLongClickListener {
            Toast.toastShort("显示防具属性")
            true
        }
        ivCharacterShoes?.click { WeaponChooseActivity.starter(context,2) }
        ivCharacterShoes?.setOnLongClickListener {
            Toast.toastShort("显示鞋子属性")
            true
        }
        ivCharacterJewelry?.click { WeaponChooseActivity.starter(context,3) }
        ivCharacterJewelry?.setOnLongClickListener {
            Toast.toastShort("显示首饰属性")
            true
        }
    }

    fun setCharacterAndWeapon(realmColor: Int, character: CharacterVo?) {
        ivCharacterAvatar?.setDrawable(strokeColor = realmColor)
    }
}