package com.june.northland.feature.equipment

import android.os.Parcelable
import com.june.northland.R
import com.june.northland.common.PropertyHelper
import kotlinx.android.parcel.Parcelize

@Parcelize
class EquipmentVo(
    val coverIcon: Int = R.drawable.ic_attack,
    val name: String = "一点黛眉刀",
    val value: Int = 100,
    val part: Int = EquipmentHelper.PART_ALL,
    val id: String = "111111",
    val quality: Int = 0,
    val level: Int = 10,
    val valueUpgrade: Int = 100,
    val property: Int = PropertyHelper.PRO_ATTACK,
    val basicDesc: String = "",
    val extraDesc: CharSequence = ""
) : Parcelable