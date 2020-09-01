package com.june.northland.feature.equipment.detail

import com.june.northland.R
import com.june.northland.base.component.BaseFragment

/**
 * 符篆(zhuan)
 */
class EquipmentSpellFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_equipment_spell

    override fun initView() {
    }

    companion object {
        fun newInstance(): EquipmentSpellFragment {
            return EquipmentSpellFragment()
        }
    }
}