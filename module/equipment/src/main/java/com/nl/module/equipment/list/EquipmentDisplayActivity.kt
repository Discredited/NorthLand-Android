package com.nl.module.equipment.list

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.june.base.basic.decoration.GridItemDecoration
import com.june.base.basic.ext.setGridManager
import com.nl.component.NLBaseActivity
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.databinding.ActivityEquipmentDisplayBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * 装备展示页面
 *
 * 2022/5/13
 * @author June
 */
class EquipmentDisplayActivity : NLBaseActivity<ActivityEquipmentDisplayBinding>() {

    private val mViewModel by viewModels<EquipmentViewModel>()
    private val mAdapter = EquipmentDisplayAdapter()

    override fun initView() {
        mBinding.rvEquipment.apply {
            setGridManager(spanCount = 4)
            adapter = mAdapter
            addItemDecoration(GridItemDecoration(column = 4, space = 20))
        }
    }

    override fun loadData() {
        lifecycleScope.launch {
            mViewModel.mEquipmentsFlow.collect {
                mAdapter.setNewInstance(it)
            }
        }

        mViewModel.equipmentList()
    }
}