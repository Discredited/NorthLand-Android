package com.nl.module.equipment.strengthen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.base.basic.ext.click
import com.nl.component.NLBaseFragment
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.R
import com.nl.module.equipment.databinding.FragmentEquipmentStrengthenBinding
import com.nl.module.equipment.widget.AdditionActiveListener

/**
 * 装备强化
 */
class EquipmentStrengthenFragment : NLBaseFragment<FragmentEquipmentStrengthenBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()
    private var mEquipmentVo: EquipmentVo? = null

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentStrengthenBinding {
        return FragmentEquipmentStrengthenBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        mBinding.vStrengthenAddition.initAdditionActive(object : AdditionActiveListener {
            override fun onAdditionActive(position: Int) {
                additionActive(position)
            }
        })

        mBinding.btStrengthenMin.click {
            //强化一级
            strengthenEquipment(1)
        }
        mBinding.btStrengthenMax.click {
            //强化至最高级
            strengthenEquipment(-1)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mEquipmentViewModel.mEquipmentLive.observe(viewLifecycleOwner, Observer {
            initStrengthen(it)
        })
    }

    private fun initStrengthen(equipment: EquipmentVo) {
        mEquipmentVo = equipment

        mBinding.tvStrengthenLevel.text = "当前强化等级:${equipment.strengthen}"
        mBinding.tvStrengthenValue.text = "当前强化属性:攻击力+${equipment.strengthen * equipment.valueUpgrade}"
        mBinding.tvStrengthenNextValue.text = "下次强化属性:攻击力+${equipment.valueUpgrade}"

        equipment.strengthenAdditions?.let {
            mBinding.vStrengthenAddition.initAddition(it)
        }
    }

    //强化
    private fun strengthenEquipment(level: Int) {
        mEquipmentViewModel.equipmentStrengthen("", level)
        mEquipmentVo?.let {
            val levelStep = if (level == -1) {
                it.strengthenMax - it.strengthen
            } else {
                1
            }

            if (level == -1) {
                it.strengthen = it.strengthenMax
            } else {
                it.strengthen = it.strengthen + 1
            }

            it.value = it.value + it.valueUpgrade * levelStep

            if (!it.enableStrength()) {
                mBinding.btStrengthenMin.isEnabled = false
                mBinding.btStrengthenMax.isEnabled = false
            }

            mEquipmentViewModel.mEquipmentLive.value = it
        }
    }

    //激活强化加成激活
    private fun additionActive(position: Int) {
        mEquipmentVo?.strengthenAdditions?.let {
            val addition = it[position]
            addition.status = 1
            addition.statusString = getString(R.string.str_activated)
            addition.statusEnable = false
            mBinding.vStrengthenAddition.additionChanged(position)
        }
    }

    companion object {
        fun newInstance(): EquipmentStrengthenFragment {
            return EquipmentStrengthenFragment()
        }
    }
}