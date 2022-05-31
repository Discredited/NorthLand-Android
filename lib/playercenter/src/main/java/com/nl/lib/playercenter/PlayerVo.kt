package com.nl.lib.playercenter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 玩家
 *
 * 2022/5/30
 * @author June
 */
@Parcelize
data class PlayerVo(
    val id: String,
    val playerId: String,
    val account: String,
    val password: String,
    val nickname: String,
    val gender: Int,
    val realName: String?,
    val realID: String?,
    val token: String?
) : Parcelable