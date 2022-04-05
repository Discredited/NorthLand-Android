package com.nl.module.role.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.june.base.basic.decoration.GridItemDecoration
import com.june.base.basic.ext.setGridManager
import com.nl.component.NLBaseFragment
import com.nl.module.role.R
import com.nl.module.role.RoleViewModel
import com.nl.module.role.databinding.FragmentRoleDetailBinding

/**
 * 角色详情
 * 2022年04月04日12:54:14
 */
class RoleDetailFragment : NLBaseFragment<FragmentRoleDetailBinding>() {

    private val viewModel by activityViewModels<RoleViewModel>()

    private val roleDetailView by lazy {
        RoleDetailView(requireActivity())
    }

    private val mAdapter by lazy {
        val color = ContextCompat.getColor(requireContext(), R.color.color_yellow)
        val colorLight = ContextCompat.getColor(requireContext(), R.color.color_yellow_light)
        RoleDetailAdapter(color, colorLight)
    }

    override fun initView() {
        mAdapter.setHeaderView(roleDetailView, 0)
        mBinding.rvRoleDetail.apply {
            setGridManager(2)
            adapter = mAdapter
            addItemDecoration(GridItemDecoration(2))
            setHasFixedSize(true)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roleId = arguments?.getString("ROLE_ID") ?: return
        viewModel.findRoleById(roleId) { role ->
            role?.let {
                roleDetailView.setRole(it)
            }
            val roleList = viewModel.loadRoleDetail(role)
            mAdapter.setNewInstance(roleList)
        }
    }
}