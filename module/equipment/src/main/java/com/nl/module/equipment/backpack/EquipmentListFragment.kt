package com.nl.module.equipment.backpack

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseFragment
import com.nl.component.ext.itemClick
import com.nl.module.equipment.*
import com.nl.module.equipment.databinding.FragmentEquipmentListBinding

class EquipmentListFragment : NLBaseFragment<FragmentEquipmentListBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()

    private val mAdapter = EquipmentListAdapter()
    private val mEquipmentList = mutableListOf<EquipmentVo>()

    private var mPart = EquipmentHelper.PART_ALL
    private var mQuality = com.nl.component.common.QualityHelper.QUALITY_ALL
    private var mPartMenu: PopupMenu? = null
    private var mQualityMenu: PopupMenu? = null
    private var mBuildMenu: PopupMenu? = null

    override fun initView() {
        mAdapter.itemClick { _, _, position ->
            val equipment = mEquipmentList[position]
            EquipmentInfoFragment
                .newInstance(equipment.id)
                .show(childFragmentManager, EquipmentInfoFragment::class.java.name)
        }
        mBinding.rvEquipment.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }


        mBinding.tvTypePart.click { showPartMenu(it) }
        mBinding.tvTypeQuality.click { showQualityMenu(it) }
        mBinding.tvBuild.click { showBuildMenu(it) }
        mBinding.tvTypeReset.click {
            mPart = EquipmentHelper.PART_ALL
            mQuality = com.nl.component.common.QualityHelper.QUALITY_ALL
            mBinding.tvTypePart.text = getString(R.string.str_all)
            mBinding.tvTypeQuality.text = getString(R.string.str_all)
            requestEquipment(mPart, mQuality)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mEquipmentViewModel.mEquipmentLive.observe(viewLifecycleOwner) {
            mAdapter.addData(0, it)
        }

        requestEquipment(mPart, mQuality)
    }

    private fun requestEquipment(part: Int = EquipmentHelper.PART_ALL, quality: Int = 0) {
        if (part == EquipmentHelper.PART_ALL) {
            mAdapter.setNewInstance(mEquipmentList)
        } else {
            val list = mEquipmentList.filter { it.part == part }.toMutableList()
            mAdapter.setNewInstance(list)
        }
    }

    private fun showPartMenu(view: View) {
        if (null == mPartMenu) {
            mPartMenu = PopupMenu(requireActivity(), view, Gravity.CENTER)
            mPartMenu?.menuInflater?.inflate(R.menu.menu_equipment_part, mPartMenu?.menu)
            mPartMenu?.setOnMenuItemClickListener {
                mPart = when (it.itemId) {
                    R.id.part_weapon -> EquipmentHelper.PART_WEAPON
                    R.id.part_armor -> EquipmentHelper.PART_CLOTHING
                    R.id.part_shoes -> EquipmentHelper.PART_SHOES
                    R.id.part_jewelry -> EquipmentHelper.PART_RING
                    else -> EquipmentHelper.PART_ALL
                }
                mBinding.tvTypePart.text = it.title
                requestEquipment(mPart, mQuality)
                true
            }
        }
        mPartMenu?.show()
    }

    private fun showQualityMenu(view: View) {
        if (null == mQualityMenu) {
            mQualityMenu = PopupMenu(requireActivity(), view, Gravity.CENTER)
            mQualityMenu?.menuInflater?.inflate(R.menu.menu_quality, mQualityMenu?.menu)
            mQualityMenu?.setOnMenuItemClickListener {
                mQuality = when (it.itemId) {
                    R.id.quality_normal -> 1
                    R.id.quality_advanced -> 2
                    R.id.quality_rare -> 3
                    R.id.quality_artifact -> 4
                    else -> 0
                }
                mBinding.tvTypeQuality.text = it.title
                requestEquipment(mPart, mQuality)
                true
            }
        }
        mQualityMenu?.show()
    }

    private fun showBuildMenu(view: View) {
        if (null == mBuildMenu) {
            mBuildMenu = PopupMenu(requireActivity(), view, Gravity.CENTER)
            mBuildMenu?.menuInflater?.inflate(R.menu.menu_equipment_part, mBuildMenu?.menu)
            mBuildMenu?.setOnMenuItemClickListener {
                val part = when (it.itemId) {
                    R.id.part_weapon -> EquipmentHelper.PART_WEAPON
                    R.id.part_armor -> EquipmentHelper.PART_CLOTHING
                    R.id.part_shoes -> EquipmentHelper.PART_SHOES
                    R.id.part_jewelry -> EquipmentHelper.PART_RING
                    else -> EquipmentHelper.PART_WEAPON
                }
                com.nl.module.equipment.detail.EquipmentBuildFragment.newInstance(part).show(
                    childFragmentManager,
                    com.nl.module.equipment.detail.EquipmentBuildFragment::class.java.name
                )
                true
            }
        }
        mBuildMenu?.show()
    }

    companion object {
        fun newInstance(): EquipmentListFragment {
            return EquipmentListFragment()
        }
    }
}