package com.nl.module.role.detail.attr

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.nl.module.role.R
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
        mBinding.tvAttack.text = context.getString(R.string.str_attack_explain, role.attackInit)
        mBinding.tvDefense.text = context.getString(R.string.str_defense_explain, role.defenseInit)
        mBinding.tvHealth.text = context.getString(R.string.str_health_explain, role.healthInit)
        mBinding.tvSpeed.text = context.getString(R.string.str_speed_explain, role.speedInit)
        mBinding.tvPotential.text = context.getString(R.string.str_potential_explain, role.potential)

        mBinding.tvCritical.text = context.getString(R.string.str_critical_explain, role.critInit)
        mBinding.tvResister.text = context.getString(R.string.str_resister_explain, role.resistInit)
        mBinding.tvHit.text = context.getString(R.string.str_hit_explain, role.hitInit)
        mBinding.tvDodge.text = context.getString(R.string.str_dodge_explain, role.dodgeInit)
    }
}