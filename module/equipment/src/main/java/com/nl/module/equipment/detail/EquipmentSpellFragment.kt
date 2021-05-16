package com.nl.module.equipment.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.base.basic.part.BaseFragment
import com.nl.module.equipment.databinding.FragmentEquipmentSpellBinding

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