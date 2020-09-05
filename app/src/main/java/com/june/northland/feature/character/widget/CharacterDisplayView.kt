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
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentInfoFragment
import com.june.northland.feature.equipment.EquipmentVo
import com.june.northland.feature.equipment.detail.EquipmentBuildFragment
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.widget_character_display_layout.view.*

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mCharacter: CharacterVo? = null
    private var mWeapon: EquipmentVo? = null
    private var mArmor: EquipmentVo? = null
    private var mShoes: EquipmentVo? = null
    private var mJewelry: EquipmentVo? = null

    init {
        View.inflate(context, R.layout.widget_character_display_layout, this)
    }

    fun wearEquipment(equipment: EquipmentVo) {
        val view: AppCompatImageView? = when (equipment.part) {
            1 -> {
                mWeapon = equipment
                ivCharacterWeapon
            }
            2 -> {
                mArmor = equipment
                ivCharacterArmor
            }
            3 -> {
                mShoes = equipment
                ivCharacterShoes
            }
            4 -> {
                mJewelry = equipment
                ivCharacterJewelry
            }
            else -> null
        }
        setEquipment(view, equipment)
    }

    private fun setEquipment(view: AppCompatImageView?, equipment: EquipmentVo?) {
        val quality = ColorUtils.equipmentQualityColor(equipment?.quality ?: EquipmentHelper.QUALITY_NORMAL)
        val qualityColor = ContextCompat.getColor(context, quality)
        view?.setDrawable(strokeColor = qualityColor)
        equipment?.let {
            view?.setImageResource(it.coverIcon)
        }
    }

    fun setCharacterAndEquipment(
        powerColor: Int,
        character: CharacterVo?,
        weapon: EquipmentVo? = null,
        armor: EquipmentVo? = null,
        shoes: EquipmentVo? = null,
        jewelry: EquipmentVo? = null
    ) {
        mCharacter = character
        ivCharacterAvatar?.setDrawable(strokeColor = powerColor)

        mWeapon = weapon
        mArmor = armor
        mShoes = shoes
        mJewelry = jewelry

        setEquipment(ivCharacterWeapon, weapon)
        setEquipment(ivCharacterArmor, armor)
        setEquipment(ivCharacterShoes, shoes)
        setEquipment(ivCharacterJewelry, jewelry)
    }

    fun equipmentClick() {
        if (context is Activity) {
            ivCharacterWeapon?.click {
                mWeapon?.let {
                    equipmentInfo(it.id)
                }
                if (null == mWeapon) {
                    equipmentBuild(EquipmentHelper.PART_WEAPON)
                }
            }
            ivCharacterArmor?.click {
                mArmor?.let {
                    equipmentInfo(it.id)
                }
                if (null == mArmor) {
                    equipmentBuild(EquipmentHelper.PART_ARMOR)
                }
            }
            ivCharacterShoes?.click {
                mShoes?.let {
                    equipmentInfo(it.id)
                }
                if (null == mShoes) {
                    equipmentBuild(EquipmentHelper.PART_SHOES)
                }
            }
            ivCharacterJewelry?.click {
                mJewelry?.let {
                    equipmentInfo(it.id)
                }
                if (null == mJewelry) {
                    equipmentBuild(EquipmentHelper.PART_JEWELRY)
                }
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

    private fun equipmentBuild(part: Int) {
        if (context is AppCompatActivity) {
            EquipmentBuildFragment.newInstance(part).show(
                (context as AppCompatActivity).supportFragmentManager,
                EquipmentBuildFragment::class.java.name
            )
        }
    }
}