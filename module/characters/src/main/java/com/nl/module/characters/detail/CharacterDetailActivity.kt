package com.nl.module.characters.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.base.basic.ext.click
import com.june.base.basic.part.BaseActivity
import com.nl.module.characters.AttributeExplanationFragment
import com.nl.module.characters.CharacterPotentialFragment
import com.nl.module.characters.CharacterVo
import com.nl.module.characters.databinding.ActivityCharacterDetailBinding
import com.nl.module.equipment.ConstantUtils
import com.nl.module.equipment.EquipmentVo
import com.nl.module.equipment.choose.EquipmentChooseActivity

/**
 * 人物详情
 */
class CharacterDetailActivity : BaseActivity<ActivityCharacterDetailBinding>() {

    //private val mEquipmentViewModel by viewModels<EquipmentViewModel>()
    private val mPagerTitleList = mutableListOf<String>()

    override fun viewBinding(): ActivityCharacterDetailBinding {
        return ActivityCharacterDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.vpCharacter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mBinding.vpCharacter.adapter = CharacterDetailAdapter(supportFragmentManager, lifecycle)

        mBinding.btBringUp.click {
            CharacterPotentialFragment.newInstance().show(
                supportFragmentManager,
                CharacterPotentialFragment::javaClass.name
            )
        }

        mBinding.ivHelper.click {
            AttributeExplanationFragment().show(
                supportFragmentManager,
                AttributeExplanationFragment::javaClass.name
            )
        }
        mBinding.iClose.ivClose.click { onBackPressed() }
    }

    override fun loadData() {
//        mEquipmentViewModel.mEquipmentLive.observe(this, Observer {
//            mBinding.vCharacterDisplay.wearEquipment(it)
//        })
        mBinding.vCharacterDisplay.equipmentClick()
        setCharacter(CharacterVo(power = intent?.getIntExtra("REALM", 8) ?: 8))

        mPagerTitleList.add("属性")
        mPagerTitleList.add("技能")
        mPagerTitleList.add("秘籍")
        //mPageTitleList.add("道心")
        TabLayoutMediator(
            mBinding.tlCharacter,
            mBinding.vpCharacter
        ) { tab, position ->
            tab.text = mPagerTitleList[position]
        }.attach()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == EquipmentChooseActivity.REQUEST_WEAPON_CHOOSE) {
            data?.let {
                val choice = it.getParcelableExtra<EquipmentVo>(
                    EquipmentChooseActivity.RESPONSE_WEAPON_CHOOSE
                )
                choice?.let { equipment ->
                    mBinding.vCharacterDisplay.wearEquipment(equipment)
                }
            }
        }
    }

    private fun setCharacter(character: CharacterVo) {
        val powerColor = ContextCompat.getColor(
            this,
            com.nl.component.common.ColorUtils.getPowerColor(character.power)
        )
        mBinding.vCollapsing.setContentScrimColor(powerColor)

        mBinding.tvCharacterName.text = character.name
        mBinding.vCharacterDisplay.setCharacterAndEquipment(
            powerColor,
            character,
            ConstantUtils.randomEquipment(1),
            ConstantUtils.randomEquipment(2)
        )
    }

    companion object {
        fun starter(context: Context, id: String) {
            val intent = Intent(context, CharacterDetailActivity::class.java)
            intent.putExtra("ID", id)
            intent.putExtra("REALM", id.toInt())
            context.startActivity(intent)
        }
    }
}