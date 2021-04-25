package com.june.northland.feature.character.list

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import com.june.northland.databinding.ActivityCharacterListBinding
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.character.detail.CharacterDetailActivity

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