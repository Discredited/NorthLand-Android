package com.june.northland.feature.login.start

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.june.base.basic.part.BaseFragment
import com.june.northland.R
import com.june.northland.databinding.FragmentDatabaseCheckBinding
import com.nl.room.RoomHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataBaseCheckFragment : BaseFragment<FragmentDatabaseCheckBinding>() {

    private val mStartUpViewModel by activityViewModels<StartUpViewModel>()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDatabaseCheckBinding {
        return FragmentDatabaseCheckBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.tvProgress.text = getString(R.string.str_loading_progress, 30)
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkDatabase()
    }

    private fun checkDatabase() {
        lifecycleScope.launch {
            val dataExist = withContext(Dispatchers.IO) { RoomHelper.getInstance().checkDataBase() }
            if (dataExist) {
                mBinding.pbLoading.progress = 100
                mStartUpViewModel.mEntranceLive.value = StartUpViewModel.GRAPH_START_ENTRANCE
            } else {
                mBinding.pbLoading.progress = 50
                withContext(Dispatchers.IO) {
                    RoomHelper.getInstance().mockDataBase()
                }
                mBinding.pbLoading.progress = 100
                mStartUpViewModel.mEntranceLive.value = StartUpViewModel.GRAPH_START_ENTRANCE
            }
        }
    }

    companion object {
        fun newInstance(): DataBaseCheckFragment {
            return DataBaseCheckFragment()
        }
    }
}