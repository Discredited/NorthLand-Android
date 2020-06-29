package com.june.northland.feature.character.equipment

import android.app.Activity
import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.activity_weapon_choose.*
import kotlinx.android.synthetic.main.view_close_image.*
import timber.log.Timber

class EquipmentChooseActivity : BaseActivity() {

    private val mAdapter = EquipmentChooseAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_weapon_choose

    override fun initView() {
        mAdapter.itemClick { _, _, i ->
            val weapon = mAdapter.getItem(i)
            val intent = Intent()
            Timber.e("weapon:${weapon.name}    ${weapon.attribute}")
            intent.putExtra(RESPONSE_WEAPON_CHOOSE, weapon)
            setResult(RESULT_OK, intent)
            finish()
        }

        rvWeaponChoose.setLinearManager()
        rvWeaponChoose.adapter = mAdapter
        rvWeaponChoose.setHasFixedSize(true)
        rvWeaponChoose.addLinearItemDecoration()

        ivClose.click { onBackPressed() }
    }

    override fun loadData() {
        //equipment 部位 1-武器  2-防具  3-鞋子  4-首饰
        val part = intent?.getIntExtra("PART", 0) ?: 0
        requestWeaponList(part)
    }

    private fun requestWeaponList(part: Int) {
        when (part) {
            1 -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(R.drawable.ic_attack, "一点黛眉刀", 500, 1),
                        EquipmentVo(R.drawable.ic_attack, "无量刀", 300, 1),
                        EquipmentVo(R.drawable.ic_attack, "劫灰剑", 200, 1),
                        EquipmentVo(R.drawable.ic_attack, "射日弓", 100, 1)
                    )
                )
            }
            2 -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(R.drawable.ic_defense, "恒河沙数盾", 300, 2),
                        EquipmentVo(R.drawable.ic_defense, "锁子甲", 200, 2),
                        EquipmentVo(R.drawable.ic_defense, "荆棘甲", 150, 2),
                        EquipmentVo(R.drawable.ic_defense, "碧落道袍", 100, 2)
                    )
                )
            }
            3 -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(R.drawable.ic_speed, "闪电靴", 200, 3),
                        EquipmentVo(R.drawable.ic_speed, "潮生海落", 300, 3),
                        EquipmentVo(R.drawable.ic_speed, "屠戮战靴", 10, 3),
                        EquipmentVo(R.drawable.ic_speed, "浮光掠影", 500, 3)
                    )
                )
            }
            4 -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(R.drawable.ic_menu_practice, "麻痹戒指", 200, 4),
                        EquipmentVo(R.drawable.ic_menu_practice, "永恒项链", 300, 4),
                        EquipmentVo(R.drawable.ic_menu_practice, "海上明月吊坠", 10, 4),
                        EquipmentVo(R.drawable.ic_menu_practice, "勇者徽章", 500, 4)
                    )
                )
            }
            else -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(R.drawable.ic_attack, "一点黛眉刀", 500, 1),
                        EquipmentVo(R.drawable.ic_attack, "无量刀", 300, 1),
                        EquipmentVo(R.drawable.ic_attack, "劫灰剑", 200, 1),
                        EquipmentVo(R.drawable.ic_attack, "射日弓", 100, 1),
                        EquipmentVo(R.drawable.ic_defense, "恒河沙数盾", 300, 2),
                        EquipmentVo(R.drawable.ic_defense, "锁子甲", 200, 2),
                        EquipmentVo(R.drawable.ic_defense, "荆棘甲", 150, 2),
                        EquipmentVo(R.drawable.ic_defense, "碧落道袍", 100, 2),
                        EquipmentVo(R.drawable.ic_speed, "闪电靴", 200, 3),
                        EquipmentVo(R.drawable.ic_speed, "潮生海落", 300, 3),
                        EquipmentVo(R.drawable.ic_speed, "屠戮战靴", 10, 3),
                        EquipmentVo(R.drawable.ic_speed, "浮光掠影", 500, 3),
                        EquipmentVo(R.drawable.ic_menu_practice, "麻痹戒指", 200, 4),
                        EquipmentVo(R.drawable.ic_menu_practice, "永恒项链", 300, 4),
                        EquipmentVo(R.drawable.ic_menu_practice, "海上明月吊坠", 10, 4),
                        EquipmentVo(R.drawable.ic_menu_practice, "勇者徽章", 500, 4)
                    )
                )
            }
        }
    }

    companion object {
        const val REQUEST_WEAPON_CHOOSE = 3001
        const val RESPONSE_WEAPON_CHOOSE = "RESPONSE_WEAPON_CHOOSE"

        fun starter(activity: Activity, part: Int) {
            val intent = Intent(activity, EquipmentChooseActivity::class.java)
            intent.putExtra("PART", part)
            activity.startActivityForResult(intent, REQUEST_WEAPON_CHOOSE)
        }
    }
}