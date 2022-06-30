package com.june.northland.feature.login.start.debug

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.june.base.basic.ext.setLinearManager
import com.june.base.basic.part.BaseDialogFragment
import com.june.northland.databinding.FragmentDialogDebugListBinding
import com.nl.component.ext.click
import com.nl.component.ext.itemClick
import com.nl.module.characters.list.CharacterListActivity
import com.nl.module.role.RoleActivity
import com.nl.module.skill.list.SkillListActivity
import com.nl.module.store.StoreActivity
import com.nl.room.excel.ExcelAnalyze
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

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
                0 -> analyzeExcel()
                1 -> startActivity(Intent(requireActivity(), RoleActivity::class.java))
                2 -> startActivity(Intent(requireActivity(), SkillListActivity::class.java))
                3 -> startActivity(Intent(requireActivity(), StoreActivity::class.java))
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
                    name = "xlsx解析",
                    url = "//////"
                ),
                DebugVo(
                    name = "人物列表",
                    url = "/////"
                ),
                DebugVo(
                    name = "角色列表",
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

    private fun analyzeExcel() {
        viewLifecycleOwner.lifecycleScope.launch {

            withContext(Dispatchers.IO) {
                val inputStream = resources.assets.open("RoleTable.xlsx")
                // 获取对应的excel
                ExcelAnalyze.analyzeExcel(inputStream) {
                    Timber.e("获取到了最后的列表")
                }
            }
        }
    }

    companion object {
        fun newInstance(): DebugListDialogFragment {
            return DebugListDialogFragment()
        }
    }
}