package com.june.northland.feature.equipment.strengthen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import com.june.northland.databinding.FragmentEquipmentStrengthenBinding
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.EquipmentVo
import com.june.northland.feature.equipment.widget.AdditionActiveListener
import kotlinx.android.synthetic.main.fragment_equipment_strengthen.*

/**
 * 装备强化
 */
class EquipmentStrengthenFragment : BaseFragment<FragmentEquipmentStrengthenBinding>() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()
    private var mEquipmentVo: EquipmentVo? = null

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEquipmentStrengthenBinding {
        return FragmentEquipmentStrengthenBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        vStrengthenAddition.initAdditionActive(object : AdditionActiveListener {
            override fun onAdditionActive(position: Int) {
                additionActive(position)
            }
        })

        btStrengthenMin.click {
            //强化一级
            strengthenEquipment(1)
        }
        btStrengthenMax.click {
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

        tvStrengthenLevel.text = "当前强化等级:${equipment.strengthen}"
        tvStrengthenValue.text = "当前强化属性:攻击力+${equipment.strengthen * equipment.valueUpgrade}"
        tvStrengthenNextValue.text = "下次强化属性:攻击力+${equipment.valueUpgrade}"

        vStrengthenAddition.initAddition(equipment.strengthenAdditions)
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
                btStrengthenMin.isEnabled = false
                btStrengthenMax.isEnabled = false
            }

            mEquipmentViewModel.mEquipmentLive.value = it
        }
    }

    //激活强化加成激活
    private fun additionActive(position: Int) {
        mEquipmentVo?.let {
            val addition = it.strengthenAdditions[position]
            addition.status = 1
            addition.statusString = getString(R.string.str_activated)
            addition.statusEnable = false
            vStrengthenAddition.additionChanged(position)
        }
    }

    companion object {
        fun newInstance(): EquipmentStrengthenFragment {
            return EquipmentStrengthenFragment()
        }
    }
}