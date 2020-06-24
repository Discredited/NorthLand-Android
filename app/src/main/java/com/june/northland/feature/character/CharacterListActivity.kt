package com.june.northland.feature.character

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import kotlinx.android.synthetic.main.activity_character_list.*

class CharacterListActivity : BaseActivity() {

    private val mAdapter = CharacterListAdapter()

    override fun getLayoutResId(): Int = R.layout.activity_character_list

    override fun initView() {
        mAdapter.itemClick { _, _, position ->
            CharacterDetailActivity.starter(this, position.toString())
        }

        rvCharacter.setLinearManager()
        rvCharacter.adapter = mAdapter
        rvCharacter.setHasFixedSize(true)
        rvCharacter.addLinearItemDecoration()
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                CharacterVo(name = "甘柠真", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen),
                CharacterVo(name = "海姬", avatarIcon = R.drawable.ic_avatar_hai_ji),
                CharacterVo(name = "鸠丹媚", avatarIcon = R.drawable.ic_avatar_jiu_dan_mei),
                CharacterVo(name = "丁香愁", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1),
                CharacterVo(name = "林飞", avatarIcon = R.drawable.ic_avatar_lin_fei),

                CharacterVo(name = "甘柠真", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen),
                CharacterVo(name = "海姬", avatarIcon = R.drawable.ic_avatar_hai_ji),
                CharacterVo(name = "鸠丹媚", avatarIcon = R.drawable.ic_avatar_jiu_dan_mei),
                CharacterVo(name = "丁香愁", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1),
                CharacterVo(name = "林飞", avatarIcon = R.drawable.ic_avatar_lin_fei),

                CharacterVo(name = "甘柠真", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen),
                CharacterVo(name = "海姬", avatarIcon = R.drawable.ic_avatar_hai_ji),
                CharacterVo(name = "鸠丹媚", avatarIcon = R.drawable.ic_avatar_jiu_dan_mei),
                CharacterVo(name = "丁香愁", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1),
                CharacterVo(name = "林飞", avatarIcon = R.drawable.ic_avatar_lin_fei),

                CharacterVo(name = "甘柠真", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen),
                CharacterVo(name = "海姬", avatarIcon = R.drawable.ic_avatar_hai_ji),
                CharacterVo(name = "鸠丹媚", avatarIcon = R.drawable.ic_avatar_jiu_dan_mei),
                CharacterVo(name = "丁香愁", avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1),
                CharacterVo(name = "林飞", avatarIcon = R.drawable.ic_avatar_lin_fei)
            )
        )
    }
}