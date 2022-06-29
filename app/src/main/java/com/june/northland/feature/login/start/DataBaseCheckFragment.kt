package com.june.northland.feature.login.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.june.northland.R
import com.june.northland.databinding.FragmentDatabaseCheckBinding
import com.nl.component.NLBaseFragment
import com.nl.room.RoomHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 数据资源检查
 * 2021年12月21日20:53:30
 */
class DataBaseCheckFragment : NLBaseFragment<FragmentDatabaseCheckBinding>() {

    private val mStartUpViewModel by activityViewModels<StartUpViewModel>()

    override fun initView() {
        mBinding.tvProgress.text = getString(R.string.str_loading_progress, 30)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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