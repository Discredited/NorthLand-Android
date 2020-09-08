package com.june.northland.feature.equipment.strengthen

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.click
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.EquipmentVo
import kotlinx.android.synthetic.main.fragment_equipment_strengthen.*

/**
 * 装备强化
 */
class EquipmentStrengthenFragment : BaseFragment() {

    private val mEquipmentViewModel by activityViewModels<EquipmentViewModel>()
    private var mEquipmentVo: EquipmentVo? = null

    override fun getLayoutResId(): Int = R.layout.fragment_equipment_strengthen

    override fun initView() {
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

        tvStrengthenLevel.text = "当前强化等级:${equipment.level}"
        tvStrengthenValue.text = "当前强化属性:攻击力+${equipment.level * equipment.valueUpgrade}"
        tvStrengthenNextValue.text = "下次强化属性:攻击力+${equipment.valueUpgrade}"

        tvStrengthenAddOne.text = "攻击+5%"
        tvStrengthenAddTwo.text = "暴击+5%"
    }

    private fun strengthenEquipment(level: Int) {
        mEquipmentVo?.let {
            val strengthen = mEquipmentViewModel.equipmentStrengthen("", level)

        }
    }

    companion object {
        fun newInstance(): EquipmentStrengthenFragment {
            return EquipmentStrengthenFragment()
        }
    }
}