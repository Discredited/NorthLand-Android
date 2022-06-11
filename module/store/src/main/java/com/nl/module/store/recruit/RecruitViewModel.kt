package com.nl.module.store.recruit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.june.network.api.ApiResponse
import com.nl.lib.element.role.PlayerRoleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 招募ViewModel
 *
 * 2022/6/10
 * @author June
 */
class RecruitViewModel : ViewModel() {

    val mRecruitRoleFlow: MutableSharedFlow<PlayerRoleEntity?> = MutableSharedFlow()
    val mErrorFlow: MutableSharedFlow<String> = MutableSharedFlow()

    private val mRecruitRep = RecruitRepository()

    /**
     * 招募角色
     */
    fun recruitRole(playerId: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                mRecruitRep.recruitRole(playerId)
            }
            if (response is ApiResponse.Success) {
                mRecruitRoleFlow.emit(response.data)
            } else {
                val error = response as ApiResponse.Error
                mErrorFlow.emit(error.error ?: "网络请求错误")
            }
        }
    }
}