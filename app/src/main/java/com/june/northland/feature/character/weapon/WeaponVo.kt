package com.june.northland.feature.character.weapon

import android.os.Parcelable
import com.june.northland.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class WeaponVo(
    val coverIcon: Int = R.drawable.ic_attack,
    val name: String = "一点黛眉刀",
    val attribute: Int = 100,
    val part: Int = 0
) : Parcelable