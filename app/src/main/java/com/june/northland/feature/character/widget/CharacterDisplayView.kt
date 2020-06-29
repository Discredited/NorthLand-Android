package com.june.northland.feature.character.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.june.northland.R
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.character.equipment.EquipmentChooseActivity
import com.june.northland.feature.character.equipment.EquipmentVo
import com.june.northland.utils.Toast
import kotlinx.android.synthetic.main.widget_character_display_layout.view.*

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_character_display_layout, this)
    }

    fun setCharacterAndWeapon(realmColor: Int, character: CharacterVo?) {
        ivCharacterAvatar?.setDrawable(strokeColor = realmColor)
    }

    fun replaceWeaponClick() {
        if (context is Activity) {
            val activity = context as Activity
            ivCharacterWeapon?.click { EquipmentChooseActivity.starter(activity, 1) }
            ivCharacterWeapon?.setOnLongClickListener {
                Toast.toastShort("显示武器属性")
                true
            }
            ivCharacterArmor?.click { EquipmentChooseActivity.starter(activity, 2) }
            ivCharacterArmor?.setOnLongClickListener {
                Toast.toastShort("显示防具属性")
                true
            }
            ivCharacterShoes?.click { EquipmentChooseActivity.starter(activity, 3) }
            ivCharacterShoes?.setOnLongClickListener {
                Toast.toastShort("显示鞋子属性")
                true
            }
            ivCharacterJewelry?.click { EquipmentChooseActivity.starter(activity, 4) }
            ivCharacterJewelry?.setOnLongClickListener {
                Toast.toastShort("显示首饰属性")
                true
            }
        }
    }

    fun wearEquipment(equipment: EquipmentVo) {
        val view: AppCompatImageView? = when (equipment.part) {
            1 -> ivCharacterWeapon
            2 -> ivCharacterArmor
            3 -> ivCharacterShoes
            4 -> ivCharacterJewelry
            else -> null
        }
        view?.setImageResource(equipment.coverIcon)
    }
}