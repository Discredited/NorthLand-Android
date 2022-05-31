package com.nl.lib.playercenter

import com.nl.lib.element.player.PlayerEntity
import com.nl.room.RoomHelper
import com.tencent.mmkv.MMKV

/**
 * 控制中心
 */
object PlayerCenter {

    private const val KEY_PLAYER = "PLAYER"

    private val mPlayerMMKV: MMKV by lazy { MMKV.defaultMMKV(1, "PLAYER_CENTER") }

    private var mPlayer: PlayerVo? = null

    suspend fun playerLogin(account: String, password: String): PlayerVo? {
        val playerDao = RoomHelper.getInstance().database().playerDao()
        playerDao.findPlayersByAccount(account)?.let {
            return PlayerVo(
                id = it.id,
                playerId = it.playerId,
                account = it.account,
                password = it.password,
                nickname = it.nickname,
                gender = it.gender,
                realName = it.realName,
                realID = it.realID,
                token = it.token
            )
        }

        // 没有当前用户自动注册
        val id = ""
        val playerId = ""
        val nickname = ""
        val gender = 0

        playerDao.insertPlayers(
            PlayerEntity(
                id = id,
                playerId = playerId,
                account = account,
                password = password,
                nickname = nickname,
                gender = gender,
                realName = null,
                realID = null,
                token = null
            )
        )
        return PlayerVo(
            id = id,
            playerId = playerId,
            account = account,
            password = password,
            nickname = nickname,
            gender = gender,
            realName = null,
            realID = null,
            token = null
        )
    }

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