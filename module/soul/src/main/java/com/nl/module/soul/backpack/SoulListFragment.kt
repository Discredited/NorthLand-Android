package com.nl.module.soul.backpack

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.june.base.basic.part.BaseFragment
import com.nl.component.NLBaseFragment
import com.nl.component.common.AttributeHelper
import com.nl.component.common.QualityHelper
import com.nl.module.soul.R
import com.nl.module.soul.databinding.FragmentSoulListBinding

class SoulListFragment : NLBaseFragment<FragmentSoulListBinding>() {

    private val mAdapter = SoulAdapter()
    private val mSoulList = mutableListOf<com.nl.module.soul.SoulVo>()

    private var mAttribute = AttributeHelper.ATTRIBUTE_ALL
    private var mQuality = QualityHelper.QUALITY_ALL
    private var mAttributeMenu: PopupMenu? = null
    private var mQualityMenu: PopupMenu? = null

    override fun initView() {
        mBinding.rvSoul.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }

        mBinding.tvTypeAttribute.click { showActionMenu(it) }
        mBinding.tvTypeQuality.click { showQualityMenu(it) }
        mBinding.tvTypeReset.click {
            mAttribute = AttributeHelper.ATTRIBUTE_ALL
            mQuality = QualityHelper.QUALITY_ALL
            mBinding.tvTypeAttribute.text = getString(R.string.str_all)
            mBinding.tvTypeQuality.text = getString(R.string.str_all)
            requestSoul(mAttribute, mQuality)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestSoul(mAttribute, mQuality)
    }

    private fun requestSoul(attribute: Int, quality: Int) {
        if (mSoulList.isEmpty()) {
            mSoulList.addAll(
                mutableListOf(
                    com.nl.module.soul.SoulVo(
                        "一点黛眉刀",
                        "????",
                        0,
                        R.drawable.ic_attack,
                        AttributeHelper.ATTRIBUTE_ATTACK
                    ),
                    com.nl.module.soul.SoulVo(
                        "恒河沙数盾",
                        "????",
                        0,
                        R.drawable.ic_defense,
                        AttributeHelper.ATTRIBUTE_DEFENSE
                    ),
                    com.nl.module.soul.SoulVo(
                        "补天石",
                        "????",
                        0,
                        R.drawable.ic_health,
                        AttributeHelper.ATTRIBUTE_HEALTH
                    ),
                    com.nl.module.soul.SoulVo(
                        "黄泉扇",
                        "????",
                        0,
                        R.drawable.ic_speed,
                        AttributeHelper.ATTRIBUTE_SPEED
                    ),
                    com.nl.module.soul.SoulVo(
                        "劫灰剑",
                        "????",
                        0,
                        R.drawable.ic_critical,
                        AttributeHelper.ATTRIBUTE_CRITICAL
                    ),
                    com.nl.module.soul.SoulVo(
                        "鬼牙",
                        "????",
                        0,
                        R.drawable.ic_resister,
                        AttributeHelper.ATTRIBUTE_RESISTER
                    ),
                    com.nl.module.soul.SoulVo(
                        "囚牛",
                        "????",
                        0,
                        R.drawable.ic_hit,
                        AttributeHelper.ATTRIBUTE_HIT
                    ),
                    com.nl.module.soul.SoulVo(
                        "蒲牢",
                        "????",
                        0,
                        R.drawable.ic_dodge,
                        AttributeHelper.ATTRIBUTE_DODGE
                    ),
                    com.nl.module.soul.SoulVo(
                        "狻猊",
                        "????",
                        0,
                        R.drawable.ic_defense,
                        AttributeHelper.ATTRIBUTE_DEFENSE
                    ),
                    com.nl.module.soul.SoulVo(
                        "螭吻",
                        "????",
                        0,
                        R.drawable.ic_attack,
                        AttributeHelper.ATTRIBUTE_ATTACK
                    ),
                    com.nl.module.soul.SoulVo(
                        "射日弓",
                        "????",
                        0,
                        R.drawable.ic_critical,
                        AttributeHelper.ATTRIBUTE_CRITICAL
                    ),
                    com.nl.module.soul.SoulVo(
                        "海上明月刀",
                        "????",
                        0,
                        R.drawable.ic_speed,
                        AttributeHelper.ATTRIBUTE_SPEED
                    ),
                    com.nl.module.soul.SoulVo(
                        "无量刀",
                        "????",
                        0,
                        R.drawable.ic_attack,
                        AttributeHelper.ATTRIBUTE_ATTACK
                    ),
                    com.nl.module.soul.SoulVo(
                        "神罗天征",
                        "????",
                        0,
                        R.drawable.ic_dodge,
                        AttributeHelper.ATTRIBUTE_DODGE
                    ),
                    com.nl.module.soul.SoulVo(
                        "月魂",
                        "????",
                        0,
                        R.drawable.ic_resister,
                        AttributeHelper.ATTRIBUTE_RESISTER
                    )
                )
            )
        }
        if (mAttribute == AttributeHelper.ATTRIBUTE_ALL) {
            mAdapter.setNewInstance(mSoulList)
        } else {
            val list = mSoulList.filter { it.attribute == attribute }.toMutableList()
            mAdapter.setNewInstance(list)
        }
    }

    private fun showActionMenu(view: View) {
        if (null == mAttributeMenu) {
            mAttributeMenu = PopupMenu(requireActivity(), view, Gravity.CENTER)
            mAttributeMenu?.menuInflater?.inflate(R.menu.menu_attribute, mAttributeMenu?.menu)
            mAttributeMenu?.setOnMenuItemClickListener {
                mAttribute = when (it.itemId) {
                    R.id.attribute_attack -> AttributeHelper.ATTRIBUTE_ATTACK
                    R.id.attribute_defense -> AttributeHelper.ATTRIBUTE_DEFENSE
                    R.id.attribute_health -> AttributeHelper.ATTRIBUTE_HEALTH
                    R.id.attribute_speed -> AttributeHelper.ATTRIBUTE_SPEED
                    R.id.attribute_critical -> AttributeHelper.ATTRIBUTE_CRITICAL
                    R.id.attribute_resister -> AttributeHelper.ATTRIBUTE_RESISTER
                    R.id.attribute_hit -> AttributeHelper.ATTRIBUTE_HIT
                    R.id.attribute_dodge -> AttributeHelper.ATTRIBUTE_DODGE
                    else -> AttributeHelper.ATTRIBUTE_ALL
                }
                mBinding.tvTypeAttribute.text = it.title
                requestSoul(mAttribute, mQuality)
                true
            }
        }
        mAttributeMenu?.show()
    }

    private fun showQualityMenu(view: View) {
        if (null == mQualityMenu) {
            mQualityMenu = PopupMenu(requireActivity(), view, Gravity.CENTER)
            mQualityMenu?.menuInflater?.inflate(R.menu.menu_quality, mQualityMenu?.menu)
            mQualityMenu?.setOnMenuItemClickListener {
                mQuality = when (it.itemId) {
                    R.id.quality_normal -> QualityHelper.QUALITY_NORMAL
                    R.id.quality_advanced -> QualityHelper.QUALITY_ADVANCED
                    R.id.quality_rare -> QualityHelper.QUALITY_RARE
                    R.id.quality_artifact -> QualityHelper.QUALITY_ARTIFACT
                    else -> 0
                }
                mBinding.tvTypeQuality.text = it.title
                requestSoul(mAttribute, mQuality)
                true
            }
        }
        mQualityMenu?.show()
    }

    companion object {
        fun newInstance(): SoulListFragment {
            return SoulListFragment()
        }
    }
}