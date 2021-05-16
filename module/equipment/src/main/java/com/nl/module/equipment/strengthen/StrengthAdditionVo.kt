package com.nl.module.equipment.strengthen

import android.os.Parcel
import android.os.Parcelable

data class StrengthAdditionVo(
    val description: String,
    var status: Int, // -1-未激活 0-激活 1-已激活
    var statusString: String, // -1-未激活 0-激活 1-已激活
    var statusEnable: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeInt(status)
        parcel.writeString(statusString)
        parcel.writeByte(if (statusEnable) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StrengthAdditionVo> {
        override fun createFromParcel(parcel: Parcel): StrengthAdditionVo {
            return StrengthAdditionVo(parcel)
        }

        override fun newArray(size: Int): Array<StrengthAdditionVo?> {
            return arrayOfNulls(size)
        }
    }
}