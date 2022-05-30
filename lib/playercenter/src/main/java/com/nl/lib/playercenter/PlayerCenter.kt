package com.nl.lib.playercenter

import com.tencent.mmkv.MMKV

/**
 * 控制中心
 */
object PlayerCenter {

    private const val KEY_PLAYER = "PLAYER"

    private val mPlayerMMKV: MMKV by lazy { MMKV.defaultMMKV(1, "PLAYER_CENTER") }

    private var mPlayer: PlayerVo? = null

    fun savePlayer(playerVo: PlayerVo) {
        mPlayerMMKV.encode(KEY_PLAYER, playerVo)
    }

    fun getPlayer(): PlayerVo? {
        if (null == mPlayer) {
            mPlayer = mPlayerMMKV.decodeParcelable(KEY_PLAYER, PlayerVo::class.java)
        }
        return mPlayer
    }

    fun getPlayerId(): String? {
        return getPlayer()?.id
    }

    fun getPlayerToken(): String? {
        return getPlayer()?.token
    }

    fun clear() {
        mPlayerMMKV.clear()
    }
}