package com.nl.module.characters.list

import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.june.base.basic.part.BaseActivity
import com.nl.component.ext.itemClick
import com.nl.module.characters.CharacterVo
import com.nl.module.characters.R
import com.nl.module.characters.databinding.ActivityCharacterListBinding
import com.nl.module.characters.detail.CharacterDetailActivity

/**
 * 人物列表
 */
class CharacterListActivity : BaseActivity<ActivityCharacterListBinding>() {

    private val mAdapter = CharacterListAdapter()

    override fun viewBinding(): ActivityCharacterListBinding {
        return ActivityCharacterListBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mAdapter.itemClick { _, _, position ->
            CharacterDetailActivity.starter(this, position.toString())
        }

        mBinding.rvCharacter.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }

        mBinding.iToolbar.toolbar.title = "人物列表"
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                CharacterVo(
                    name = "甘柠真",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "海姬",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "鸠丹媚",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "丁香愁",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "林飞",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                ),

                CharacterVo(
                    name = "甘柠真",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "海姬",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "鸠丹媚",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "丁香愁",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "林飞",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                ),

                CharacterVo(
                    name = "甘柠真",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "海姬",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "鸠丹媚",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "丁香愁",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "林飞",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                ),

                CharacterVo(
                    name = "甘柠真",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "海姬",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "鸠丹媚",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "丁香愁",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "林飞",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                )
            )
        )
    }
}