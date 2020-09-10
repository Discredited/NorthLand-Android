package com.june.northland.feature.equipment.strengthen

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class StrengthAdditionVo(
    val description: String,
    var status: Int, // -1-未激活 0-激活 1-已激活
    var statusString: String, // -1-未激活 0-激活 1-已激活
    var statusEnable: Boolean
) : Parcelable