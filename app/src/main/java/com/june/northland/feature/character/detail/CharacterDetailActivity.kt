package com.june.northland.feature.character.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.feature.character.AttributeExplanationFragment
import com.june.northland.feature.character.CharacterPotentialFragment
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.equipment.EquipmentChooseActivity
import com.june.northland.feature.equipment.EquipmentVo
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.activity_character_detail.*
import kotlinx.android.synthetic.main.view_close_image.*

/**
 * 人物详情
 */
class CharacterDetailActivity : BaseActivity() {

    private lateinit var mAdapter: CharacterDetailAdapter
    private val mPagerTitleList = mutableListOf<String>()

    override fun getLayoutResId(): Int = R.layout.activity_character_detail

    override fun initView() {
        mAdapter = CharacterDetailAdapter(supportFragmentManager, lifecycle)

        vpCharacter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vpCharacter.adapter = mAdapter

        btBringUp.click {
            CharacterPotentialFragment.newInstance()
                .show(supportFragmentManager, CharacterPotentialFragment::javaClass.name)
        }

        ivHelper.click {
            AttributeExplanationFragment().show(
                supportFragmentManager,
                AttributeExplanationFragment::javaClass.name
            )
        }
        ivClose.click { onBackPressed() }
    }

    override fun loadData() {
        vCharacterDisplay.replaceWeaponClick()
        setCharacter(CharacterVo())

        mPagerTitleList.add("基本信息")
        mPagerTitleList.add("技能")
        mPagerTitleList.add("秘籍")
        //mPageTitleList.add("道心")
        TabLayoutMediator(
            tlCharacter,
            vpCharacter,
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
                    vCharacterDisplay.wearEquipment(equipment)
                }
            }
        }
    }

    private fun setCharacter(character: CharacterVo) {
        val realm = intent?.getIntExtra("REALM", 8) ?: 8
        val realmColor = ContextCompat.getColor(this, ColorUtils.getRealmColor(realm))
        vCollapsing.setContentScrimColor(realmColor)

        vCharacterDisplay.setCharacterAndWeapon(realmColor, character)
        tvCharacterName.text = character.name
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