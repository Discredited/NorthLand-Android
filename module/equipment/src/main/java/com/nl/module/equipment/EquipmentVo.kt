package com.nl.module.equipment

import android.os.Parcel
import android.os.Parcelable
import com.nl.lib.element.enum.PropertyEnum
import com.nl.lib.element.equipment.EquipmentEnum
import com.nl.module.equipment.strengthen.StrengthAdditionVo

data class EquipmentVo(
    val id: String = "111111",
    val name: String = "一点黛眉刀",
    val icon: String = "",
    val part: Int = EquipmentEnum.PART_ALL,  // 部位
    val quality: Int = 0,  // 品质
    val property: Int = PropertyEnum.PRO_ATTACK,  // 属性
    val basicDesc: String = "",
    val extraDesc: CharSequence = "",
    var value: Int = 100,
    val valueGrowth: Int = 100,  // 增长属性
    var strengthen: Int = 0,
    val strengthenGrowth: Int = 100,
    val forging: Int = 0,
    val forgingGrowth: Double = 0.0,
    val strengthenAdditions: MutableList<StrengthAdditionVo>? = mutableListOf()
) : Parcelable {

    fun enableStrength(): Boolean = strengthen < 100

    fun isQualityMax() = quality >= EquipmentEnum.QUALITY_PEERLESS

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        arrayListOf<StrengthAdditionVo>().apply {
            parcel.readArrayList(StrengthAdditionVo::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(icon)
        parcel.writeInt(part)
        parcel.writeInt(quality)
        parcel.writeInt(property)
        parcel.writeInt(value)
        parcel.writeInt(valueGrowth)
        parcel.writeString(basicDesc)
        parcel.writeString(extraDesc.toString())
        parcel.writeInt(strengthen)
        parcel.writeInt(strengthenGrowth)
        parcel.writeInt(forging)
        parcel.writeDouble(forgingGrowth)
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