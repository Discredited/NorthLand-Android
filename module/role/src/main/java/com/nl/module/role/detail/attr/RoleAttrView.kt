package com.nl.module.role.detail.attr

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.nl.module.role.RoleVo
import com.nl.module.role.databinding.WidgetRoleAttributeViewBinding

/**
 * 角色属性View
 *
 * 2022/4/6
 * @author June
 */
class RoleAttrView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val mBinding = WidgetRoleAttributeViewBinding.inflate(LayoutInflater.from(context), this)

    fun setAttrs(roleVo: RoleVo) {
        val role = roleVo.role
        mBinding.tvAttack.text = role.attackInit.toString()
        mBinding.tvDefense.text = role.defenseInit.toString()
        mBinding.tvHealth.text = role.healthInit.toString()
        mBinding.tvSpeed.text = role.speedInit.toString()
        mBinding.tvPotential.text = role.potential.toString()
    }
}