package com.nl.module.equipment.choose

import android.app.Activity
import android.content.Intent
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseActivity
import com.nl.component.ext.click
import com.nl.component.ext.itemClick
import com.nl.module.equipment.EquipmentHelper
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.databinding.ActivityEquipmentChooseBinding
import timber.log.Timber

class EquipmentChooseActivity : NLBaseActivity<ActivityEquipmentChooseBinding>() {

    private val mAdapter = EquipmentChooseAdapter()

    override fun viewBinding(): ActivityEquipmentChooseBinding {
        return ActivityEquipmentChooseBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mAdapter.itemClick { _, _, i ->
            val weapon = mAdapter.getItem(i)
            val intent = Intent()
            Timber.e("weapon:${weapon.name}    ${weapon.value}")
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
        //equipment 部位 1-武器  2-防具  3-鞋子  4-首饰
        val part = intent?.getIntExtra("PART", 0) ?: 0
        requestWeaponList(part)
    }

    private fun requestWeaponList(part: Int) {
        when (part) {
            EquipmentHelper.PART_WEAPON -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(
                            "一点黛眉刀",
                            "1_normal/weapon.png",
                            500,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "无量刀",
                            "1_normal/weapon.png",
                            300,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "劫灰剑",
                            "1_normal/weapon.png",
                            200,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "射日弓",
                            "1_normal/weapon.png",
                            100,
                            EquipmentHelper.PART_WEAPON
                        )
                    )
                )
            }
            EquipmentHelper.PART_CLOTHING -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(
                            "恒河沙数盾",
                            "1_normal/armor.png",
                            300,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "锁子甲",
                            "1_normal/armor.png",
                            200,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "荆棘甲",
                            "1_normal/armor.png",
                            150,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "碧落道袍",
                            "1_normal/armor.png",
                            100,
                            EquipmentHelper.PART_CLOTHING
                        )
                    )
                )
            }
            EquipmentHelper.PART_SHOES -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(
                            "闪电靴",
                            "1_normal/shoes.png",
                            200,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "潮生海落",
                            "1_normal/shoes.png",
                            300,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "屠戮战靴",
                            "1_normal/shoes.png",
                            10,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "浮光掠影",
                            "1_normal/shoes.png",
                            500,
                            EquipmentHelper.PART_SHOES
                        )
                    )
                )
            }
            EquipmentHelper.PART_RING -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(
                            "麻痹戒指",
                            "1_normal/ring.png",
                            200,
                            EquipmentHelper.PART_RING
                        ),
                        EquipmentVo(
                            "永恒项链",
                            "1_normal/ring.png",
                            300,
                            EquipmentHelper.PART_RING
                        ),
                        EquipmentVo(
                            "海上明月吊坠",
                            "1_normal/ring.png",
                            10,
                            EquipmentHelper.PART_RING
                        ),
                        EquipmentVo(
                            "勇者徽章",
                            "1_normal/ring.png",
                            500,
                            EquipmentHelper.PART_RING
                        )
                    )
                )
            }
            else -> {
                mAdapter.setNewInstance(
                    mutableListOf(
                        EquipmentVo(
                            "一点黛眉刀",
                            "1_normal/weapon.png",
                            500,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "无量刀",
                            "1_normal/weapon.png",
                            300,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "劫灰剑",
                            "1_normal/weapon.png",
                            200,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "射日弓",
                            "1_normal/weapon.png",
                            100,
                            EquipmentHelper.PART_WEAPON
                        ),
                        EquipmentVo(
                            "恒河沙数盾",
                            "1_normal/weapon.png",
                            300,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "锁子甲",
                            "1_normal/weapon.png",
                            200,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "荆棘甲",
                            "1_normal/weapon.png",
                            150,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "碧落道袍",
                            "1_normal/weapon.png",
                            100,
                            EquipmentHelper.PART_CLOTHING
                        ),
                        EquipmentVo(
                            "闪电靴",
                            "1_normal/weapon.png",
                            200,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "潮生海落",
                            "1_normal/weapon.png",
                            300,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "屠戮战靴",
                            "1_normal/weapon.png",
                            10,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "浮光掠影",
                            "1_normal/weapon.png",
                            500,
                            EquipmentHelper.PART_SHOES
                        ),
                        EquipmentVo(
                            "麻痹戒指",
                            "1_normal/weapon.png",
                            200,
                            EquipmentHelper.PART_RING
                        ),
                        EquipmentVo(
                            "永恒项链",
                            "1_normal/weapon.png",
                            300,
                            EquipmentHelper.PART_RING
                        ),
                        EquipmentVo(
                            "海上明月吊坠",
                            "1_normal/weapon.png",
                            10,
                            EquipmentHelper.PART_RING
                        ),
                        EquipmentVo(
                            "勇者徽章",
                            "1_normal/weapon.png",
                            500,
                            EquipmentHelper.PART_RING
                        )
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
            activity.startActivityForResult(
                intent,
                REQUEST_WEAPON_CHOOSE
            )
        }
    }
}