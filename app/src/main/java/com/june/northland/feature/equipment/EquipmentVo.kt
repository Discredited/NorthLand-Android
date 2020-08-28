package com.june.northland.feature.equipment

import android.os.Parcelable
import com.june.northland.R
import com.june.northland.feature.equipment.EquipmentHelper
import kotlinx.android.parcel.Parcelize

@Parcelize
class EquipmentVo(
    val coverIcon: Int = R.drawable.ic_attack,
    val name: String = "一点黛眉刀",
    val attribute: Int = 100,
    val part: Int = EquipmentHelper.PART_ALL,
    val id: String = "111111"
) : Parcelable