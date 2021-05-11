package com.june.northland.feature.backpack.magic

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.june.northland.R
import com.june.base.basic.part.BaseFragment
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.common.AttributeHelper
import com.june.northland.common.QualityHelper
import com.june.northland.databinding.FragmentMagicListBinding
import com.june.northland.feature.magic.MagicVo

class MagicListFragment : BaseFragment<FragmentMagicListBinding>() {

    private val mAdapter = MagicAdapter()
    private val mMagicList = mutableListOf<MagicVo>()

    private var mAttribute = AttributeHelper.ATTRIBUTE_ALL
    private var mQuality = QualityHelper.QUALITY_ALL
    private var mAttributeMenu: PopupMenu? = null
    private var mQualityMenu: PopupMenu? = null

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMagicListBinding {
        return FragmentMagicListBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mBinding.rvMagic.apply {
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
            requestMagic(mAttribute, mQuality)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestMagic(mAttribute, mQuality)
    }

    private fun requestMagic(attribute: Int, quality: Int) {
        if (mMagicList.isEmpty()) {
            mMagicList.addAll(
                mutableListOf(
                    MagicVo(
                        "龙虎秘道术",
                        "????",
                        0,
                        R.drawable.ic_magic_1,
                        AttributeHelper.ATTRIBUTE_ATTACK
                    ),
                    MagicVo(
                        "混沌甲御术",
                        "????",
                        0,
                        R.drawable.ic_magic_2,
                        AttributeHelper.ATTRIBUTE_DEFENSE
                    ),
                    MagicVo(
                        "碧落赋道术",
                        "????",
                        0,
                        R.drawable.ic_magic_3,
                        AttributeHelper.ATTRIBUTE_HEALTH
                    ),
                    MagicVo(
                        "隐遁妖典",
                        "????",
                        0,
                        R.drawable.ic_magic_1,
                        AttributeHelper.ATTRIBUTE_SPEED
                    ),
                    MagicVo(
                        "胎化长生妖术",
                        "????",
                        0,
                        R.drawable.ic_magic_2,
                        AttributeHelper.ATTRIBUTE_CRITICAL
                    ),
                    MagicVo(
                        "脉经甲御术",
                        "????",
                        0,
                        R.drawable.ic_magic_3,
                        AttributeHelper.ATTRIBUTE_RESISTER
                    ),
                    MagicVo(
                        "影流甲御术",
                        "????",
                        0,
                        R.drawable.ic_magic_1,
                        AttributeHelper.ATTRIBUTE_HIT
                    ),
                    MagicVo(
                        "镜花水月大法",
                        "????",
                        0,
                        R.drawable.ic_magic_2,
                        AttributeHelper.ATTRIBUTE_DODGE
                    ),
                    MagicVo(
                        "龙象般若拳",
                        "????",
                        0,
                        R.drawable.ic_magic_3,
                        AttributeHelper.ATTRIBUTE_DEFENSE
                    ),
                    MagicVo(
                        "镜像手",
                        "????",
                        0,
                        R.drawable.ic_magic_1,
                        AttributeHelper.ATTRIBUTE_ATTACK
                    ),
                    MagicVo(
                        "悲喜换身大法",
                        "????",
                        0,
                        R.drawable.ic_magic_2,
                        AttributeHelper.ATTRIBUTE_CRITICAL
                    ),
                    MagicVo(
                        "复生秘道术",
                        "????",
                        0,
                        R.drawable.ic_magic_3,
                        AttributeHelper.ATTRIBUTE_SPEED
                    ),
                    MagicVo(
                        "兵器甲御术",
                        "????",
                        0,
                        R.drawable.ic_magic_1,
                        AttributeHelper.ATTRIBUTE_ATTACK
                    ),
                    MagicVo(
                        "镜瞳秘道术",
                        "????",
                        0,
                        R.drawable.ic_magic_2,
                        AttributeHelper.ATTRIBUTE_DODGE
                    ),
                    MagicVo(
                        "地藏妖经",
                        "????",
                        0,
                        R.drawable.ic_magic_3,
                        AttributeHelper.ATTRIBUTE_RESISTER
                    )
                )
            )
        }
        if (mAttribute == AttributeHelper.ATTRIBUTE_ALL) {
            mAdapter.setNewInstance(mMagicList)
        } else {
            val list = mMagicList.filter { it.attribute == attribute }.toMutableList()
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
                requestMagic(mAttribute, mQuality)
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
                requestMagic(mAttribute, mQuality)
                true
            }
        }
        mQualityMenu?.show()
    }

    companion object {
        fun newInstance(): MagicListFragment {
            return MagicListFragment()
        }
    }
}