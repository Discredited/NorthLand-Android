package com.nl.module.role.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.june.base.basic.ext.click
import com.nl.component.NLBaseFragment
import com.nl.module.role.RoleViewModel
import com.nl.module.role.databinding.FragmentRoleDetailBinding

/**
 * 角色详情
 * 2022年04月04日12:54:14
 */
class RoleDetailFragment : NLBaseFragment<FragmentRoleDetailBinding>() {

    private val viewModel by activityViewModels<RoleViewModel>()

    override fun initView() {
        mBinding.iClose.ivClose.click { findNavController().popBackStack() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roleId = arguments?.getString("ROLE_ID") ?: return
        viewModel.findRoleById(roleId) { role ->
            role?.let {
                mBinding.vRoleDetail.setRole(it.role)
                mBinding.vRoleAttr.setAttrs(role)
            }
        }
    }
}