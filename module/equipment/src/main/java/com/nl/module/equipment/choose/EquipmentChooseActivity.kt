package com.nl.module.equipment.choose

import android.app.Activity
import android.content.Intent
import androidx.activity.viewModels
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseActivity
import com.nl.component.ext.click
import com.nl.component.ext.itemClick
import com.nl.module.equipment.EquipmentViewModel
import com.nl.module.equipment.databinding.ActivityEquipmentChooseBinding

class EquipmentChooseActivity : NLBaseActivity<ActivityEquipmentChooseBinding>() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()

    private val mAdapter = EquipmentChooseAdapter()

    override fun viewBinding(): ActivityEquipmentChooseBinding {
        return ActivityEquipmentChooseBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mAdapter.itemClick { _, _, i ->
            val weapon = mAdapter.getItem(i)
            val intent = Intent()
            intent.putExtra(RESPONSE_WEAPON_CHOOSE, weapon)
            setResult(RESULT_OK, intent)
            finish()
        }

        mBinding.rvWeaponChoose.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }

        mBinding.iClose.ivClose.click { onBackPressed() }
    }

    override fun loadData() {
        //equipment 部位 1-武器 2-服饰 3-防具 4-鞋子 4-戒指 5-项链
        val part = intent?.getIntExtra("PART", 0) ?: 0
        requestWeaponList(part)
    }

    private fun requestWeaponList(part: Int) {
        mAdapter.setNewInstance(mEquipmentViewModel.equipmentList(part))
    }

    companion object {
        const val REQUEST_WEAPON_CHOOSE = 3001
        const val RESPONSE_WEAPON_CHOOSE = "RESPONSE_WEAPON_CHOOSE"

        fun starter(activity: Activity, part: Int) {
            val intent = Intent(activity, EquipmentChooseActivity::class.java)
            intent.putExtra("PART", part)
            activity.startActivityForResult(
                intent,
                REQUEST_WEAPON_CHOOSE
            )
        }
    }
}