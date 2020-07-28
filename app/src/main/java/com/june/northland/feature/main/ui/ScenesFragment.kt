package com.june.northland.feature.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ToastUtils
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.addLinearItemDecoration
import com.june.northland.base.ext.click
import com.june.northland.base.ext.itemClick
import com.june.northland.base.ext.setLinearManager
import com.june.northland.feature.backpack.BackpackActivity
import com.june.northland.feature.character.CharacterInfoFragment
import com.june.northland.feature.character.CharacterListActivity
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.lineup.LineUpActivity
import com.june.northland.feature.main.MainActivity
import com.june.northland.feature.main.vo.MenuVo
import com.june.northland.feature.dungeon.DungeonVo
import com.june.northland.feature.dungeon.piece.PieceActivity
import com.june.northland.feature.practice.PracticeActivity
import com.june.northland.feature.store.StoreActivity
import kotlinx.android.synthetic.main.fragment_main_scene.*

class ScenesFragment : BaseFragment() {

    private val mCharacterAdapter = ScenesCharacterAdapter()
    private val mMenuAdapter = ScenesMenuAdapter()
    private val mPlotAdapter = ScenesPlotAdapter()

    override fun getLayoutResId(): Int = R.layout.fragment_main_scene

    override fun initView() {
        //阵容人物
        mCharacterAdapter.itemClick { _, _, position ->
            val characterInfoFragment = CharacterInfoFragment.newInstance(position)
            characterInfoFragment.show(childFragmentManager, CharacterInfoFragment::javaClass.name)
        }

        rvCharacter.setLinearManager(
            orientation = RecyclerView.HORIZONTAL
        )
        rvCharacter.adapter = mCharacterAdapter
        rvCharacter.setHasFixedSize(true)
        rvCharacter.addLinearItemDecoration(orientation = RecyclerView.HORIZONTAL)


        //剧情关卡
        rvPlot.setLinearManager(
            orientation = RecyclerView.HORIZONTAL
        )
        rvPlot.adapter = mPlotAdapter
        rvPlot.setHasFixedSize(true)
        rvPlot.addLinearItemDecoration(orientation = RecyclerView.HORIZONTAL)
        PagerSnapHelper().attachToRecyclerView(rvPlot)


        //底部菜单
        mMenuAdapter.itemClick { _, _, position ->
            when (position) {
                0 -> startActivity(Intent(requireActivity(), CharacterListActivity::class.java))
                1 -> startActivity(Intent(requireActivity(), BackpackActivity::class.java))
                2 -> startActivity(Intent(requireActivity(), LineUpActivity::class.java))
                3 -> startActivity(Intent(requireActivity(), PieceActivity::class.java))
                5 -> startActivity(Intent(requireActivity(), StoreActivity::class.java))
                7 -> startActivity(Intent(requireActivity(), PracticeActivity::class.java))
                else -> ToastUtils.showShort(getString(R.string.prompt_coming_soon))
            }
        }
        rvMenu.setLinearManager(
            orientation = RecyclerView.HORIZONTAL
        )
        rvMenu.adapter = mMenuAdapter
        rvMenu.setHasFixedSize(true)

        vPlayerSection.getAvatarView()?.click {
            activity?.let {
                if (it is MainActivity) {
                    it.openDrawLayout()
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vPlayerSection.setPlayerInfo()
        requestCharacter()
        requestPlot()
        initMenu()
    }

    private fun requestCharacter() {
        mCharacterAdapter.setNewInstance(
            mutableListOf(
                CharacterVo(avatarIcon = R.drawable.ic_avatar_gan_ning_zhen),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_hai_ji),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_jiu_dan_mei),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_lin_fei),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_gan_ning_zhen),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_hai_ji),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_jiu_dan_mei),
                CharacterVo(avatarIcon = R.drawable.ic_avatar_lin_fei)
            )
        )
    }

    private fun requestPlot() {
        mPlotAdapter.setNewInstance(
            mutableListOf(
                DungeonVo("红尘天", R.drawable.ic_scense_one),
                DungeonVo("魔刹天", R.drawable.ic_scense_second),
                DungeonVo("罗生天", R.drawable.ic_scense_third),
                DungeonVo("清虚天", R.drawable.ic_scense_one),
                DungeonVo("吉祥天", R.drawable.ic_scense_second)
            )
        )
    }

    private fun initMenu() {
        mMenuAdapter.setNewInstance(
            mutableListOf(
                MenuVo("人物", R.drawable.ic_menu_weapon),
                MenuVo("背包", R.drawable.ic_menu_backpack),
                MenuVo("阵容", R.drawable.ic_menu_line_up),
                MenuVo("关卡", R.drawable.ic_menu_plot),
                MenuVo("竞技场", R.drawable.ic_menu_arena),
                MenuVo("商店", R.drawable.ic_menu_store),
                MenuVo("秘籍", R.drawable.ic_menu_magic),
                MenuVo("修炼", R.drawable.ic_menu_practice)
            )
        )
    }
}