package com.june.northland.feature.character.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.equipment.choose.EquipmentChooseActivity
import com.june.northland.feature.equipment.EquipmentInfoFragment
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentVo
import kotlinx.android.synthetic.main.widget_character_display_layout.view.*

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.widget_character_display_layout, this)
    }

    fun setCharacterAndWeapon(realmColor: Int, character: CharacterVo?) {
        ivCharacterAvatar?.setDrawable(strokeColor = realmColor)
        ivCharacterWeapon?.setDrawable(ContextCompat.getColor(context, R.color.color_quality_advanced))
        ivCharacterArmor?.setDrawable(ContextCompat.getColor(context, R.color.color_quality_artifact))
        ivCharacterShoes?.setDrawable(ContextCompat.getColor(context, R.color.color_quality_artifact))
        ivCharacterJewelry?.setDrawable(ContextCompat.getColor(context, R.color.color_quality_epic))
    }

    fun equipmentClick() {
        if (context is Activity) {
            val activity = context as Activity
            ivCharacterWeapon?.click { EquipmentChooseActivity.starter(activity, EquipmentHelper.PART_WEAPON) }
            ivCharacterWeapon?.setOnLongClickListener {
                equipmentInfo("1")
                true
            }
            ivCharacterArmor?.click { EquipmentChooseActivity.starter(activity, EquipmentHelper.PART_ARMOR) }
            ivCharacterArmor?.setOnLongClickListener {
                equipmentInfo("2")
                true
            }
            ivCharacterShoes?.click { EquipmentChooseActivity.starter(activity, EquipmentHelper.PART_SHOES) }
            ivCharacterShoes?.setOnLongClickListener {
                equipmentInfo("3")
                true
            }
            ivCharacterJewelry?.click { EquipmentChooseActivity.starter(activity, EquipmentHelper.PART_JEWELRY) }
            ivCharacterJewelry?.setOnLongClickListener {
                equipmentInfo("4")
                true
            }
        }
    }

    private fun equipmentInfo(id: String) {
        if (context is AppCompatActivity) {
            EquipmentInfoFragment.newInstance(id).show(
                (context as AppCompatActivity).supportFragmentManager,
                EquipmentInfoFragment::class.java.name
            )
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