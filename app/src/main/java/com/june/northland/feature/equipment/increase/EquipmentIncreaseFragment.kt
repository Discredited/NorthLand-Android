package com.june.northland.feature.equipment.increase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import com.june.northland.databinding.FragmentEquipmentIncreaseBinding
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.IncreaseVo

class EquipmentIncreaseFragment : BaseFragment<FragmentEquipmentIncreaseBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()
    private val mAdapter = EquipmentIncreaseAdapter()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentIncreaseBinding {
        return FragmentEquipmentIncreaseBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mAdapter.addChildLongClickViewIds(R.id.btIncreaseRefine, R.id.btIncreasePromote)
        mAdapter.itemClick { _, view, i ->
            if (view.id == R.id.btIncreaseRefine) {
                //洗练
                val increase = mAdapter.data[i]
            } else {
                //增幅
            }
        }

        mBinding.rvEquipmentIncrease.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mEquipmentViewModel.mEquipmentLive.observe(viewLifecycleOwner, Observer {
            initIncrease(it.quality)
        })
    }

    private fun initIncrease(quality: Int) {
        val list: MutableList<IncreaseVo> = mutableListOf()
        if (quality > 0) {
            list.add(
                IncreaseVo(
                    "",
                    "攻击+5%",
                    ContextCompat.getColor(requireContext(), R.color.color_equipment_refine)
                )
            )
        }
        if (quality > 1) {
            list.add(
                IncreaseVo(
                    "",
                    "暴击+5%",
                    ContextCompat.getColor(requireContext(), R.color.color_equipment_flawless)
                )
            )
        }
        if (quality > 2) {
            list.add(
                IncreaseVo(
                    "",
                    "生命+20%",
                    ContextCompat.getColor(requireContext(), R.color.color_equipment_extraordinary)
                )
            )

        }
        if (quality > 3) {
            list.add(
                IncreaseVo(
                    "",
                    "防御+30%",
                    ContextCompat.getColor(requireContext(), R.color.color_equipment_extreme)
                )
            )
        }
        if (quality > 4) {
            list.add(
                IncreaseVo(
                    "",
                    "攻击+50%",
                    ContextCompat.getColor(requireContext(), R.color.color_equipment_peerless)
                )
            )
        }
        if (list.isNotEmpty()) {
            mAdapter.setNewInstance(list)
        }
    }

    //洗练
    private fun refine() {
        mEquipmentViewModel.increaseRefine()
    }

    //增幅
    private fun increase() {
        mEquipmentViewModel.equipmentIncrease()
    }

    companion object {
        fun newInstance(): EquipmentIncreaseFragment {
            return EquipmentIncreaseFragment()
        }
    }
}