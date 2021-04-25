package com.june.northland.feature.character.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setDrawable
import com.june.northland.databinding.WidgetCharacterDisplayLayoutBinding
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.equipment.EquipmentHelper
import com.june.northland.feature.equipment.EquipmentInfoFragment
import com.june.northland.feature.equipment.EquipmentVo
import com.june.northland.feature.equipment.detail.EquipmentBuildFragment
import com.june.northland.utils.ColorUtils

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mBinding: WidgetCharacterDisplayLayoutBinding =
        WidgetCharacterDisplayLayoutBinding.inflate(LayoutInflater.from(context), this)

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

    private fun setEquipment(view: AppCompatImageView?, equipment: EquipmentVo?) {
        val quality =
            ColorUtils.equipmentQualityColor(equipment?.quality ?: EquipmentHelper.QUALITY_NORMAL)
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
                    equipmentBuild(EquipmentHelper.PART_WEAPON)
                }
            }
            mBinding.ivCharacterArmor.click {
                mArmor?.let {
                    equipmentInfo(it.id)
                }
                if (null == mArmor) {
                    equipmentBuild(EquipmentHelper.PART_ARMOR)
                }
            }
            mBinding.ivCharacterShoes.click {
                mShoes?.let {
                    equipmentInfo(it.id)
                }
                if (null == mShoes) {
                    equipmentBuild(EquipmentHelper.PART_SHOES)
                }
            }
            mBinding.ivCharacterJewelry.click {
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