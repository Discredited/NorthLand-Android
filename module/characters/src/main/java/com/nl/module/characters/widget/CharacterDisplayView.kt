package com.nl.module.characters.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.june.base.basic.ext.click
import com.nl.component.common.ColorUtils
import com.nl.component.ext.loadAvatar
import com.nl.component.ext.setDrawable
import com.nl.module.characters.CharacterVo
import com.nl.module.characters.R
import com.nl.module.characters.databinding.WidgetCharacterDisplayLayoutBinding
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentInfoFragment
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.detail.EquipmentBuildFragment

class CharacterDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mBinding: WidgetCharacterDisplayLayoutBinding =
        WidgetCharacterDisplayLayoutBinding.inflate(LayoutInflater.from(context), this)

    private var mCharacter: CharacterVo? = null
    private var mWeapon: EquipmentVo? = null
    private var mTops: EquipmentVo? = null
    private var mBottoms: EquipmentVo? = null
    private var mShoes: EquipmentVo? = null
    private var mRing: EquipmentVo? = null
    private var mNecklace: EquipmentVo? = null

    fun wearEquipment(equipment: EquipmentVo) {
        val view: AppCompatImageView? = when (equipment.part) {
            EquipmentHelper.PART_WEAPON -> {
                mWeapon = equipment
                mBinding.ivCharacterWeapon
            }
            EquipmentHelper.PART_TOPS -> {
                mTops = equipment
                mBinding.ivCharacterTops
            }
            EquipmentHelper.PART_BOTTOMS -> {
                mBottoms = equipment
                mBinding.ivCharacterBottoms
            }
            EquipmentHelper.PART_SHOES -> {
                mShoes = equipment
                mBinding.ivCharacterShoes
            }
            EquipmentHelper.PART_RING -> {
                mRing = equipment
                mBinding.ivCharacterRing
            }
            EquipmentHelper.PART_NECKLACE -> {
                mNecklace = equipment
                mBinding.ivCharacterNecklace
            }
            else -> null
        }
        setEquipment(view, equipment)
    }

    private fun setEquipment(view: AppCompatImageView?, equipment: EquipmentVo?) {
        val qualityDefault = equipment?.quality ?: EquipmentHelper.QUALITY_NORMAL
        val quality = ColorUtils.equipmentQualityColor(qualityDefault)
        val qualityColor = ContextCompat.getColor(context, quality)
        view?.setDrawable(strokeColor = qualityColor)
        equipment?.let { view?.setImageResource(it.coverIcon) }
    }

    fun setCharacterAndEquipment(
        powerColor: Int,
        character: CharacterVo?,
        weapon: EquipmentVo? = null,
        tops: EquipmentVo? = null,
        bottoms: EquipmentVo? = null,
        shoes: EquipmentVo? = null,
        ring: EquipmentVo? = null,
        necklace: EquipmentVo? = null
    ) {
        mCharacter = character
        mBinding.ivCharacterAvatar.setDrawable(strokeColor = powerColor)
        mBinding.ivCharacterAvatar.loadAvatar(
            R.drawable.ic_avatar_gan_ning_zhen,
            resources.getDimensionPixelSize(R.dimen.dp_5)
        )
        mBinding.tvCharacterName.text = character?.name

        mWeapon = weapon
        mTops = tops
        mBottoms = bottoms
        mShoes = shoes
        mRing = ring
        mNecklace = necklace

        setEquipment(mBinding.ivCharacterWeapon, weapon)
        setEquipment(mBinding.ivCharacterTops, tops)
        setEquipment(mBinding.ivCharacterBottoms, bottoms)
        setEquipment(mBinding.ivCharacterShoes, shoes)
        setEquipment(mBinding.ivCharacterRing, ring)
        setEquipment(mBinding.ivCharacterNecklace, necklace)
    }

    fun equipmentClick() {
        if (context is Activity) {
            mBinding.ivCharacterWeapon.click {
                mWeapon?.let { equipmentInfo(it.id) }
                if (null == mWeapon) {
                    equipmentBuild(EquipmentHelper.PART_WEAPON)
                }
            }
            mBinding.ivCharacterTops.click {
                mTops?.let { equipmentInfo(it.id) }
                if (null == mTops) {
                    equipmentBuild(EquipmentHelper.PART_TOPS)
                }
            }
            mBinding.ivCharacterBottoms.click {
                mBottoms?.let { equipmentInfo(it.id) }
                if (null == mBottoms) {
                    equipmentBuild(EquipmentHelper.PART_BOTTOMS)
                }
            }
            mBinding.ivCharacterShoes.click {
                mShoes?.let { equipmentInfo(it.id) }
                if (null == mShoes) {
                    equipmentBuild(EquipmentHelper.PART_SHOES)
                }
            }
            mBinding.ivCharacterRing.click {
                mRing?.let { equipmentInfo(it.id) }
                if (null == mRing) {
                    equipmentBuild(EquipmentHelper.PART_RING)
                }
            }
            mBinding.ivCharacterNecklace.click {
                mNecklace?.let { equipmentInfo(it.id) }
                if (null == mNecklace) {
                    equipmentBuild(EquipmentHelper.PART_NECKLACE)
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