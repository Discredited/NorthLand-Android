package com.june.northland.feature.character.weapon

import android.content.Context
import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.activity_weapon_choose.*

class WeaponChooseActivity : BaseActivity() {

    private val mAdapter = WeaponChooseAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_weapon_choose

    override fun initView() {
        rvWeaponChoose.setLinearManager()
        rvWeaponChoose.adapter = mAdapter
        rvWeaponChoose.setHasFixedSize(true)
        rvWeaponChoose.addLinearItemDecoration()
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                WeaponVo(R.drawable.ic_attack, "一点黛眉刀", 200),
                WeaponVo(R.drawable.ic_defense, "恒河沙数盾", 300),
                WeaponVo(R.drawable.ic_speed, "屠戮战靴", 10),
                WeaponVo(R.drawable.ic_critical, "浮光掠影", 500)
            )
        )
    }

    companion object {
        fun starter(context: Context, part: Int) {
            val intent = Intent(context, WeaponChooseActivity::class.java)
            intent.putExtra("PART", part)
            context.startActivity(intent)
        }
    }
}