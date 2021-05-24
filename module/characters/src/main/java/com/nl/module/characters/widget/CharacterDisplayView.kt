package com.nl.module.characters.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.june.base.basic.ext.click
import com.nl.component.ext.setDrawable
import com.nl.module.characters.CharacterVo
import com.nl.module.characters.R
import com.nl.module.characters.databinding.WidgetCharacterDisplayLayoutBinding

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mBinding: WidgetCharacterDisplayLayoutBinding =
        WidgetCharacterDisplayLayoutBinding.inflate(LayoutInflater.from(context), this)

    private var mCharacter: CharacterVo? = null
    private var mWeapon: com.nl.module.equipment.EquipmentVo? = null
    private var mArmor: com.nl.module.equipment.EquipmentVo? = null
    private var mShoes: com.nl.module.equipment.EquipmentVo? = null
    private var mJewelry: com.nl.module.equipment.EquipmentVo? = null

    init {
        View.inflate(context, R.layout.widget_character_display_layout, this)
    }

    fun wearEquipment(equipment: com.nl.module.equipment.EquipmentVo) {
        val view: AppCompatImageView? = when (equipment.part) {
            1 -> {
                mWeapon = equipment
                mBinding.ivCharacterWeapon
            }
            2 -> {
                mArmor = equipment
                mBinding.ivCharacterArmor
            }
            3 -> {
                mShoes = equipment
                mBinding.ivCharacterShoes
            }
            4 -> {
                mJewelry = equipment
                mBinding.ivCharacterJewelry
            }
            else -> null
        }
        setEquipment(view, equipment)
    }

    private fun setEquipment(view: AppCompatImageView?, equipment: com.nl.module.equipment.EquipmentVo?) {
        val quality =
            com.nl.component.common.ColorUtils.equipmentQualityColor(equipment?.quality ?: com.nl.module.equipment.EquipmentHelper.QUALITY_NORMAL)
        val qualityColor = ContextCompat.getColor(context, quality)
        view?.setDrawable(strokeColor = qualityColor)
        equipment?.let {
            view?.setImageResource(it.coverIcon)
        }
    }

    fun setCharacterAndEquipment(
        powerColor: Int,
        character: CharacterVo?,
        weapon: com.nl.module.equipment.EquipmentVo? = null,
        armor: com.nl.module.equipment.EquipmentVo? = null,
        shoes: com.nl.module.equipment.EquipmentVo? = null,
        jewelry: com.nl.module.equipment.EquipmentVo? = null
    ) {
        mCharacter = character
        mBinding.ivCharacterAvatar.setDrawable(strokeColor = powerColor)

        mWeapon = weapon
        mArmor = armor
        mShoes = shoes
        mJewelry = jewelry

        setEquipment(mBinding.ivCharacterWeapon, weapon)
        setEquipment(mBinding.ivCharacterArmor, armor)
        setEquipment(mBinding.ivCharacterShoes, shoes)
        setEquipment(mBinding.ivCharacterJewelry, jewelry)
    }

    fun equipmentClick() {
        if (context is Activity) {
            mBinding.ivCharacterWeapon.click {
                mWeapon?.let {
                    equipmentInfo(it.id)
                }
                if (null == mWeapon) {
                    equipmentBuild(com.nl.module.equipment.EquipmentHelper.PART_WEAPON)
                }
            }
            mBinding.ivCharacterArmor.click {
                mArmor?.let {
                    equipmentInfo(it.id)
                }
                if (null == mArmor) {
                    equipmentBuild(com.nl.module.equipment.EquipmentHelper.PART_ARMOR)
                }
            }
            mBinding.ivCharacterShoes.click {
                mShoes?.let {
                    equipmentInfo(it.id)
                }
                if (null == mShoes) {
                    equipmentBuild(com.nl.module.equipment.EquipmentHelper.PART_SHOES)
                }
            }
            mBinding.ivCharacterJewelry.click {
                mJewelry?.let {
                    equipmentInfo(it.id)
                }
                if (null == mJewelry) {
                    equipmentBuild(com.nl.module.equipment.EquipmentHelper.PART_JEWELRY)
                }
            }
        }
    }

    private fun equipmentInfo(id: String) {
        if (context is AppCompatActivity) {
            com.nl.module.equipment.EquipmentInfoFragment.newInstance(id).show(
                (context as AppCompatActivity).supportFragmentManager,
                com.nl.module.equipment.EquipmentInfoFragment::class.java.name
            )
        }
    }

    private fun equipmentBuild(part: Int) {
        if (context is AppCompatActivity) {
            com.nl.module.equipment.detail.EquipmentBuildFragment.newInstance(part).show(
                (context as AppCompatActivity).supportFragmentManager,
                com.nl.module.equipment.detail.EquipmentBuildFragment::class.java.name
            )
        }
    }
}