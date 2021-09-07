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
                    name = "林飞",
                    avatar = "lin_fei.png",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                ),
                CharacterVo(
                    name = "甘柠真",
                    avatar = "gan_ning_zhen.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "海姬",
                    avatar = "hai_ji.png",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "鸠丹媚",
                    avatar = "jiu_dan_mei.png",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "无颜",
                    avatar = "wu_yan.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "龙碟",
                    avatar = "long_die.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),

                CharacterVo(
                    name = "楚度",
                    avatar = "chu_du.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "阿萝",
                    avatar = "a_luo.png",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "悲喜和尚",
                    avatar = "bei_xi_he_shang.png",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "碧潮戈",
                    avatar = "bi_chao_ge.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "龙眼雀",
                    avatar = "long_yan_que.png",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                ),

                CharacterVo(
                    name = "夜流冰",
                    avatar = "ye_liu_bing.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "阿凡提",
                    avatar = "a_fan_ti.png",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "吐鲁番",
                    avatar = "tu_lu_fan.png",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "公子樱",
                    avatar = "gong_zi_ying.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "拓跋峰",
                    avatar = "tuo_ba_feng.png",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                ),

                CharacterVo(
                    name = "庄梦",
                    avatar = "zhuang_meng.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen
                ),
                CharacterVo(
                    name = "无崖子",
                    avatar = "wu_ya_zi.png",
                    avatarIcon = R.drawable.ic_avatar_hai_ji
                ),
                CharacterVo(
                    name = "黄真",
                    avatar = "huang_zhen.png",
                    avatarIcon = R.drawable.ic_avatar_jiu_dan_mei
                ),
                CharacterVo(
                    name = "丁香愁",
                    avatar = "ding_xiang_chou.png",
                    avatarIcon = R.drawable.ic_avatar_gan_ning_zhen_1
                ),
                CharacterVo(
                    name = "珠穆朗玛",
                    avatar = "zhu_mu_lang_ma.png",
                    avatarIcon = R.drawable.ic_avatar_lin_fei
                )
            )
        )
    }
}