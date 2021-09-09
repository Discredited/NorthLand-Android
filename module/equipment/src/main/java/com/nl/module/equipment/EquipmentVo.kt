package com.nl.module.equipment

import android.os.Parcel
import android.os.Parcelable
import com.nl.component.common.PropertyHelper
import com.nl.module.equipment.strengthen.StrengthAdditionVo

data class EquipmentVo(
    val name: String = "一点黛眉刀",
    val icon: String = "",
    var value: Int = 100,
    val part: Int = EquipmentHelper.PART_ALL,  // 部位
    val id: String = "111111",
    val quality: Int = 0,  // 品质
    val valueUpgrade: Int = 100,  // 增长属性
    val property: Int = PropertyHelper.PRO_ATTACK,  // 属性
    val basicDesc: String = "",
    val extraDesc: CharSequence = "",
    val strengthenMax: Int = 100,
    var strengthen: Int = 0,
    val strengthenAdditions: MutableList<StrengthAdditionVo>? = mutableListOf()
) : Parcelable {

    fun enableStrength(): Boolean = strengthen < strengthenMax

    fun isQualityMax() = quality >= EquipmentHelper.QUALITY_PEERLESS

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        arrayListOf<StrengthAdditionVo>().apply {
            parcel.readArrayList(StrengthAdditionVo::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(icon)
        parcel.writeInt(value)
        parcel.writeInt(part)
        parcel.writeString(id)
        parcel.writeInt(quality)
        parcel.writeInt(valueUpgrade)
        parcel.writeInt(property)
        parcel.writeString(basicDesc)
        parcel.writeString(extraDesc.toString())
        parcel.writeInt(strengthenMax)
        parcel.writeInt(strengthen)
        parcel.writeList(strengthenAdditions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EquipmentVo> {
        override fun createFromParcel(parcel: Parcel): EquipmentVo {
            return EquipmentVo(parcel)
        }

        override fun newArray(size: Int): Array<EquipmentVo?> {
            return arrayOfNulls(size)
        }
    }
}