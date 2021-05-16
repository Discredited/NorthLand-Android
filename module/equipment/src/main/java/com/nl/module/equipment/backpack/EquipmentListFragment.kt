package com.nl.module.equipment.backpack

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseFragment
import com.nl.component.ext.itemClick
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.FragmentEquipmentListBinding

class EquipmentListFragment : NLBaseFragment<FragmentEquipmentListBinding>() {

    private val mEquipmentViewModel by activityViewModels<com.nl.module.equipment.EquipmentViewModel>()

    private val mAdapter = EquipmentAdapter()
    private val mEquipmentList = mutableListOf<com.nl.module.equipment.EquipmentVo>()

    private var mPart = com.nl.module.equipment.EquipmentHelper.PART_ALL
    private var mQuality = com.nl.component.common.QualityHelper.QUALITY_ALL
    private var mPartMenu: PopupMenu? = null
    private var mQualityMenu: PopupMenu? = null
    private var mBuildMenu: PopupMenu? = null

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentListBinding {
        return FragmentEquipmentListBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mAdapter.itemClick { _, _, position ->
            val equipment = mEquipmentList[position]
            com.nl.module.equipment.EquipmentInfoFragment
                .newInstance(equipment.id)
                .show(childFragmentManager, com.nl.module.equipment.EquipmentInfoFragment::class.java.name)
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
            mPart = com.nl.module.equipment.EquipmentHelper.PART_ALL
            mQuality = com.nl.component.common.QualityHelper.QUALITY_ALL
            mBinding.tvTypePart.text = getString(R.string.str_all)
            mBinding.tvTypeQuality.text = getString(R.string.str_all)
            requestEquipment(mPart, mQuality)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mEquipmentViewModel.mEquipmentLive.observe(viewLifecycleOwner, Observer {
            mAdapter.addData(0, it)
        })

        requestEquipment(mPart, mQuality)
    }

    private fun requestEquipment(part: Int = com.nl.module.equipment.EquipmentHelper.PART_ALL, quality: Int = 0) {
        if (mEquipmentList.isEmpty()) {
            mEquipmentList.addAll(
                mutableListOf(
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_attack,
                        "一点黛眉刀",
                        500,
                        com.nl.module.equipment.EquipmentHelper.PART_WEAPON
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_attack,
                        "无量刀",
                        300,
                        com.nl.module.equipment.EquipmentHelper.PART_WEAPON
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_attack,
                        "劫灰剑",
                        200,
                        com.nl.module.equipment.EquipmentHelper.PART_WEAPON
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_attack,
                        "射日弓",
                        100,
                        com.nl.module.equipment.EquipmentHelper.PART_WEAPON
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_defense,
                        "恒河沙数盾",
                        300,
                        com.nl.module.equipment.EquipmentHelper.PART_ARMOR
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_defense,
                        "锁子甲",
                        200,
                        com.nl.module.equipment.EquipmentHelper.PART_ARMOR
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_defense,
                        "荆棘甲",
                        150,
                        com.nl.module.equipment.EquipmentHelper.PART_ARMOR
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_defense,
                        "碧落道袍",
                        100,
                        com.nl.module.equipment.EquipmentHelper.PART_ARMOR
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_speed,
                        "闪电靴",
                        200,
                        com.nl.module.equipment.EquipmentHelper.PART_SHOES
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_speed,
                        "潮生海落",
                        300,
                        com.nl.module.equipment.EquipmentHelper.PART_SHOES
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_speed,
                        "屠戮战靴",
                        10,
                        com.nl.module.equipment.EquipmentHelper.PART_SHOES
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_speed,
                        "浮光掠影",
                        500,
                        com.nl.module.equipment.EquipmentHelper.PART_SHOES
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_menu_practice,
                        "麻痹戒指",
                        200,
                        com.nl.module.equipment.EquipmentHelper.PART_JEWELRY
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_menu_practice,
                        "永恒项链",
                        300,
                        com.nl.module.equipment.EquipmentHelper.PART_JEWELRY
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_menu_practice,
                        "海上明月吊坠",
                        10,
                        com.nl.module.equipment.EquipmentHelper.PART_JEWELRY
                    ),
                    com.nl.module.equipment.EquipmentVo(
                        R.drawable.ic_menu_practice,
                        "勇者徽章",
                        500,
                        com.nl.module.equipment.EquipmentHelper.PART_JEWELRY
                    )
                )
            )
        }
        if (part == com.nl.module.equipment.EquipmentHelper.PART_ALL) {
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
                    R.id.part_weapon -> com.nl.module.equipment.EquipmentHelper.PART_WEAPON
                    R.id.part_armor -> com.nl.module.equipment.EquipmentHelper.PART_ARMOR
                    R.id.part_shoes -> com.nl.module.equipment.EquipmentHelper.PART_SHOES
                    R.id.part_jewelry -> com.nl.module.equipment.EquipmentHelper.PART_JEWELRY
                    else -> com.nl.module.equipment.EquipmentHelper.PART_ALL
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
                    R.id.part_weapon -> com.nl.module.equipment.EquipmentHelper.PART_WEAPON
                    R.id.part_armor -> com.nl.module.equipment.EquipmentHelper.PART_ARMOR
                    R.id.part_shoes -> com.nl.module.equipment.EquipmentHelper.PART_SHOES
                    R.id.part_jewelry -> com.nl.module.equipment.EquipmentHelper.PART_JEWELRY
                    else -> com.nl.module.equipment.EquipmentHelper.PART_WEAPON
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