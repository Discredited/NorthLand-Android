package com.nl.module.role.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.june.base.basic.decoration.GridItemDecoration
import com.june.base.basic.ext.setGridManager
import com.nl.component.NLBaseFragment
import com.nl.component.ext.itemClick
import com.nl.lib.element.role.RoleEntity
import com.nl.module.role.R
import com.nl.module.role.RoleViewModel
import com.nl.module.role.RoleVo
import com.nl.module.role.databinding.FragmentRoleListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * 角色列表
 *
 * 2022/4/4
 * @author June
 */
class RoleListFragment : NLBaseFragment<FragmentRoleListBinding>() {

    private val viewModel by activityViewModels<RoleViewModel>()
    private val mAdapter by lazy { RoleListAdapter() }

    override fun initView() {
        mAdapter.itemClick { adapter, _, position ->
            val roleVo = adapter.getItem(position) as RoleVo
            val arguments = Bundle().apply { putString("ROLE_ID", roleVo.role.id) }
            findNavController().navigate(R.id.action_roleList_to_roleDetail, arguments)
        }

        mBinding.rvRole.apply {
            setGridManager(spanCount = 4)
            adapter = mAdapter
            addItemDecoration(GridItemDecoration(4))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.roleListFlow.collectLatest {
                mAdapter.setNewInstance(it)
            }
        }

        viewModel.loadRoleList()
    }
}