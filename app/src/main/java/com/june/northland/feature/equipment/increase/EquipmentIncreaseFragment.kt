package com.june.northland.feature.equipment.increase

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.setLinearManager
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.IncreaseVo
import kotlinx.android.synthetic.main.fragment_equipment_increase.*

class EquipmentIncreaseFragment : BaseFragment() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()
    private val mAdapter = EquipmentIncreaseAdapter()

    override fun getLayoutResId(): Int = R.layout.fragment_equipment_increase

    override fun initView() {
        rvEquipmentIncrease.setLinearManager()
        rvEquipmentIncrease.adapter = mAdapter
        rvEquipmentIncrease.setHasFixedSize(true)
        rvEquipmentIncrease.addLinearItemDecoration()
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
            list.add(IncreaseVo("", "攻击+5%", ContextCompat.getColor(requireContext(), R.color.color_equipment_refine)))
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

    companion object {
        fun newInstance(): EquipmentIncreaseFragment {
            return EquipmentIncreaseFragment()
        }
    }
}