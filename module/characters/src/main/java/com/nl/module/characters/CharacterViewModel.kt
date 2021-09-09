package com.nl.module.characters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * 上阵
     */
    fun characterOnline(): Flow<MutableList<CharacterVo>> {
        return flow {
            emit(ConstantUtils.randomCharacterList(6))
        }
    }

    fun characterList(): Flow<MutableList<CharacterVo>> {
        return flow {
            emit(ConstantUtils.characterList())
        }
    }
}