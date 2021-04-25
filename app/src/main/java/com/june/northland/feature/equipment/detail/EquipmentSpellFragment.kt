package com.june.northland.feature.equipment.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.northland.base.component.BaseFragment
import com.june.northland.databinding.FragmentEquipmentSpellBinding

/**
 * 符篆(zhuan)
 */
class EquipmentSpellFragment : BaseFragment<FragmentEquipmentSpellBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentSpellBinding {
        return FragmentEquipmentSpellBinding.inflate(inflater, container, false)
    }

    override fun initView() {
    }

    companion object {
        fun newInstance(): EquipmentSpellFragment {
            return EquipmentSpellFragment()
        }
    }
}