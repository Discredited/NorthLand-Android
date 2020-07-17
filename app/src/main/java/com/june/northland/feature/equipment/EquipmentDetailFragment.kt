package com.june.northland.feature.equipment

import android.os.Bundle
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_equipment_detail.*

class EquipmentDetailFragment : BaseDialogFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dialog_equipment_detail

    override fun initView() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestEquipment()
    }

    private fun requestEquipment() {
        ivEquipmentIcon.setImageResource(R.drawable.ic_attack)
        tvEquipmentName.text = "螭枪"
        tvBasic.text = "攻击力增加10%"
        tvExtra.text = "攻击力增加10%\n暴击增加5%"
        tvDescContent.text = "比电更快，比雷更烈。北境第一攻击魂器，可以破开时空的极限之枪，是林飞自灵宝天取得"
    }

    companion object {
        fun newInstance(id: String): EquipmentDetailFragment {
            val fragment = EquipmentDetailFragment()
            val arguments = Bundle()
            arguments.putString("ID", id)
            fragment.arguments = arguments
            return fragment
        }
    }
}