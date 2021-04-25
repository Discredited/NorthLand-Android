package com.june.northland.feature.character.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.common.ConstantUtils
import com.june.northland.databinding.ActivityCharacterDetailBinding
import com.june.northland.feature.character.AttributeExplanationFragment
import com.june.northland.feature.character.CharacterPotentialFragment
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.equipment.EquipmentViewModel
import com.june.northland.feature.equipment.EquipmentVo
import com.june.northland.feature.equipment.choose.EquipmentChooseActivity
import com.june.northland.utils.ColorUtils

/**
 * 人物详情
 */
class CharacterDetailActivity : BaseActivity<ActivityCharacterDetailBinding>() {

    private val mEquipmentViewModel by viewModels<EquipmentViewModel>()
    private val mPagerTitleList = mutableListOf<String>()

    override fun viewBinding(): ActivityCharacterDetailBinding {
        return ActivityCharacterDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.vpCharacter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mBinding.vpCharacter.adapter = CharacterDetailAdapter(supportFragmentManager, lifecycle)

        mBinding.btBringUp.click {
            CharacterPotentialFragment.newInstance()
                .show(supportFragmentManager, CharacterPotentialFragment::javaClass.name)
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
        mEquipmentViewModel.mEquipmentLive.observe(this, Observer {
            mBinding.vCharacterDisplay.wearEquipment(it)
        })
        mBinding.vCharacterDisplay.equipmentClick()
        setCharacter(CharacterVo(power = intent?.getIntExtra("REALM", 8) ?: 8))

        mPagerTitleList.add("属性")
        mPagerTitleList.add("技能")
        mPagerTitleList.add("秘籍")
        //mPageTitleList.add("道心")
        TabLayoutMediator(
            mBinding.tlCharacter,
            mBinding.vpCharacter,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = mPagerTitleList[position]
            }).attach()
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
        val powerColor = ContextCompat.getColor(this, ColorUtils.getPowerColor(character.power))
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