package com.nl.module.role.detail.attr

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.june.base.basic.decoration.GridItemDecoration
import com.june.base.basic.ext.setGridManager
import com.june.base.basic.part.BaseDialogFragment
import com.nl.module.role.R
import com.nl.module.role.RoleViewModel
import com.nl.module.role.databinding.FragmentDialogRoleAttrBinding
import com.nl.module.role.detail.RoleDetailAdapter

/**
 * 角色属性
 *
 * 2022/4/6
 * @author June
 */
class RoleAttrFragment : BaseDialogFragment<FragmentDialogRoleAttrBinding>() {

    private val viewModel by activityViewModels<RoleViewModel>()

    private val mAdapter by lazy {
        val color = ContextCompat.getColor(requireContext(), R.color.color_yellow)
        val colorLight = ContextCompat.getColor(requireContext(), R.color.color_yellow_light)
        RoleDetailAdapter(color, colorLight)
    }

    override fun initView() {
        mBinding.rvRoleDetail.apply {
            setGridManager(2)
            adapter = mAdapter
            addItemDecoration(GridItemDecoration(2))
            setHasFixedSize(true)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.roleDetail.value?.let { role ->
            val roleList = viewModel.loadRoleDetail(role.role)
            mAdapter.setNewInstance(roleList)
        }
    }
}