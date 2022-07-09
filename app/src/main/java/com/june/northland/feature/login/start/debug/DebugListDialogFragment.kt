package com.june.northland.feature.login.start.debug

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.june.base.basic.ext.setLinearManager
import com.june.base.basic.part.BaseDialogFragment
import com.june.northland.databinding.FragmentDialogDebugListBinding
import com.nl.component.ext.click
import com.nl.component.ext.itemClick
import com.nl.module.characters.list.CharacterListActivity
import com.nl.module.equipment.list.EquipmentDisplayActivity
import com.nl.module.role.RoleActivity
import com.nl.module.skill.list.SkillListActivity
import com.nl.module.store.StoreActivity

/**
 * 调试功能列表
 *
 * 2022/4/3
 * @author June
 */
class DebugListDialogFragment : BaseDialogFragment<FragmentDialogDebugListBinding>() {

    private val mAdapter by lazy { DebugListAdapter() }

    override fun initView() {

        mAdapter.itemClick { _, _, position ->
            when (position) {
                1 -> startActivity(Intent(requireActivity(), RoleActivity::class.java))
                2 -> startActivity(Intent(requireActivity(), EquipmentDisplayActivity::class.java))
                3 -> startActivity(Intent(requireActivity(), SkillListActivity::class.java))
                4 -> startActivity(Intent(requireActivity(), StoreActivity::class.java))
                else -> startActivity(Intent(requireActivity(), CharacterListActivity::class.java))
            }
        }
        mBinding.rvDebugList.apply {
            setLinearManager()
            setHasFixedSize(true)
            adapter = mAdapter
        }
        mBinding.btClose.click { dismiss() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDebugList()
    }

    private fun initDebugList() {
        mAdapter.setNewInstance(
            mutableListOf(
                DebugVo(
                    name = "人物列表",
                    url = "/////"
                ),
                DebugVo(
                    name = "角色列表",
                    url = "/////"
                ),
                DebugVo(
                    name = "装备列表",
                    url = "/////"
                ),
                DebugVo(
                    name = "技能列表",
                    url = "/////"
                ),
                DebugVo(
                    name = "商店",
                    url = "/////"
                )
            )
        )
    }

    companion object {
        fun newInstance(): DebugListDialogFragment {
            return DebugListDialogFragment()
        }
    }
}