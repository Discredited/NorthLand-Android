package com.june.northland.feature.character.equipment

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.fragment_equipment_list.*

class EquipmentListFragment : BaseFragment() {

    private val mAdapter = EquipmentChooseAdapter()
    private val mEquipmentList = mutableListOf<EquipmentVo>()

    private var mPart = EquipmentHelper.PART_ALL
    private var mQuality = 0
    private var mPartMenu: PopupMenu? = null
    private var mQualityMenu: PopupMenu? = null

    override fun getLayoutResId(): Int = R.layout.fragment_equipment_list

    override fun initView() {
        rvWeapon.setLinearManager()
        rvWeapon.adapter = mAdapter
        rvWeapon.setHasFixedSize(true)
        rvWeapon.addLinearItemDecoration()

        tvTypePart.click { showPartMenu(it) }
        tvTypeQuality.click { showQualityMenu(it) }
        tvTypeReset.click {
            mPart = EquipmentHelper.PART_ALL
            tvTypePart.text = getString(R.string.str_all)
            mQuality = 0
            tvTypeQuality.text = getString(R.string.str_all)
            requestEquipment(mPart, mQuality)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestEquipment(mPart, mQuality)
    }

    private fun requestEquipment(part: Int = EquipmentHelper.PART_ALL, quality: Int = 0) {
        if (mEquipmentList.isEmpty()) {
            mEquipmentList.addAll(
                mutableListOf(
                    EquipmentVo(R.drawable.ic_attack, "一点黛眉刀", 500, EquipmentHelper.PART_WEAPON),
                    EquipmentVo(R.drawable.ic_attack, "无量刀", 300, EquipmentHelper.PART_WEAPON),
                    EquipmentVo(R.drawable.ic_attack, "劫灰剑", 200, EquipmentHelper.PART_WEAPON),
                    EquipmentVo(R.drawable.ic_attack, "射日弓", 100, EquipmentHelper.PART_WEAPON),
                    EquipmentVo(R.drawable.ic_defense, "恒河沙数盾", 300, EquipmentHelper.PART_ARMOR),
                    EquipmentVo(R.drawable.ic_defense, "锁子甲", 200, EquipmentHelper.PART_ARMOR),
                    EquipmentVo(R.drawable.ic_defense, "荆棘甲", 150, EquipmentHelper.PART_ARMOR),
                    EquipmentVo(R.drawable.ic_defense, "碧落道袍", 100, EquipmentHelper.PART_ARMOR),
                    EquipmentVo(R.drawable.ic_speed, "闪电靴", 200, EquipmentHelper.PART_SHOES),
                    EquipmentVo(R.drawable.ic_speed, "潮生海落", 300, EquipmentHelper.PART_SHOES),
                    EquipmentVo(R.drawable.ic_speed, "屠戮战靴", 10, EquipmentHelper.PART_SHOES),
                    EquipmentVo(R.drawable.ic_speed, "浮光掠影", 500, EquipmentHelper.PART_SHOES),
                    EquipmentVo(R.drawable.ic_menu_practice, "麻痹戒指", 200, EquipmentHelper.PART_JEWELRY),
                    EquipmentVo(R.drawable.ic_menu_practice, "永恒项链", 300, EquipmentHelper.PART_JEWELRY),
                    EquipmentVo(R.drawable.ic_menu_practice, "海上明月吊坠", 10, EquipmentHelper.PART_JEWELRY),
                    EquipmentVo(R.drawable.ic_menu_practice, "勇者徽章", 500, EquipmentHelper.PART_JEWELRY)
                )
            )
        }
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
                    R.id.part_armor -> EquipmentHelper.PART_ARMOR
                    R.id.part_shoes -> EquipmentHelper.PART_SHOES
                    R.id.part_jewelry -> EquipmentHelper.PART_JEWELRY
                    else -> EquipmentHelper.PART_ALL
                }
                tvTypePart.text = it.title
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
                tvTypeQuality.text = it.title
                requestEquipment(mPart, mQuality)
                true
            }
        }
        mQualityMenu?.show()
    }

    companion object {
        fun newInstance(): EquipmentListFragment {
            return EquipmentListFragment()
        }
    }
}