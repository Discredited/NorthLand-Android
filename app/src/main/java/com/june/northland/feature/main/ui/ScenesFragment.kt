package com.june.northland.feature.main.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ToastUtils
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.click
import com.june.base.basic.ext.setLinearManager
import com.june.northland.R
import com.june.northland.databinding.FragmentMainSceneBinding
import com.june.northland.feature.backpack.BackpackActivity
import com.june.northland.feature.dungeon.DungeonVo
import com.june.northland.feature.dungeon.chapter.ChapterListActivity
import com.june.northland.feature.lineup.LineUpActivity
import com.june.northland.feature.main.email.EmailListActivity
import com.june.northland.feature.main.user.UserInfoDialogFragment
import com.june.northland.feature.main.vo.MenuVo
import com.june.northland.feature.practice.PracticeActivity
import com.june.northland.feature.taoism.TaoismActivity
import com.nl.component.NLBaseFragment
import com.nl.component.ext.itemClick
import com.nl.component.ext.simpleName
import com.nl.module.characters.CharacterViewModel
import com.nl.module.characters.detail.CharacterDetailActivity
import com.nl.module.characters.list.CharacterListActivity
import com.nl.module.store.StoreActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScenesFragment : NLBaseFragment<FragmentMainSceneBinding>() {

    private val mCharacterViewModel by viewModels<CharacterViewModel>()
    private val mCharacterAdapter = ScenesCharacterAdapter()
    private val mMenuAdapter = ScenesMenuAdapter()
    private val mPlotAdapter = ScenesPlotAdapter()

    override fun initView() {
        //阵容人物
        mCharacterAdapter.itemClick { _, _, _ ->
            CharacterDetailActivity.starter(requireActivity(), "111111")
        }

        mBinding.rvCharacter.apply {
            setLinearManager(orientation = RecyclerView.HORIZONTAL)
            adapter = mCharacterAdapter
            setHasFixedSize(true)
            addLinearItemDecoration(orientation = RecyclerView.HORIZONTAL)
        }

        //剧情关卡
        mBinding.rvPlot.apply {
            setLinearManager(orientation = RecyclerView.HORIZONTAL)
            adapter = mPlotAdapter
            setHasFixedSize(true)
            addLinearItemDecoration(orientation = RecyclerView.HORIZONTAL)
        }
        PagerSnapHelper().attachToRecyclerView(mBinding.rvPlot)

        //底部菜单
        mMenuAdapter.itemClick { _, _, position ->
            when (position) {
                0 -> startActivity(Intent(requireActivity(), CharacterListActivity::class.java))
                1 -> startActivity(Intent(requireActivity(), BackpackActivity::class.java))
                2 -> startActivity(Intent(requireActivity(), LineUpActivity::class.java))
                3 -> startActivity(Intent(requireActivity(), ChapterListActivity::class.java))
                4 -> startActivity(Intent(requireActivity(), TaoismActivity::class.java))
                5 -> startActivity(Intent(requireActivity(), StoreActivity::class.java))
                7 -> startActivity(Intent(requireActivity(), PracticeActivity::class.java))
                else -> ToastUtils.showShort(getString(R.string.prompt_coming_soon))
            }
        }
        mBinding.rvMenu.apply {
            setLinearManager(orientation = RecyclerView.HORIZONTAL)
            adapter = mMenuAdapter
            setHasFixedSize(true)
        }

        mBinding.vPlayerSection.getAvatarView().click {
            UserInfoDialogFragment.newInstance().show(childFragmentManager, UserInfoDialogFragment.simpleName())
        }

        mBinding.ivEmail.click {
            startActivity(Intent(requireActivity(), EmailListActivity::class.java))
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.vPlayerSection.setPlayerInfo()
        requestCharacter()
        requestPlot()
        initMenu()
    }

    private fun requestCharacter() {
        viewLifecycleOwner.lifecycleScope.launch {
            mCharacterViewModel.characterOnline().collect {
                mCharacterAdapter.setNewInstance(it)
            }
        }
    }

    private fun requestPlot() {
        mPlotAdapter.setNewInstance(
            mutableListOf(
                DungeonVo("红尘天", "", R.drawable.ic_scense_one),
                DungeonVo("魔刹天", "", R.drawable.ic_scense_second),
                DungeonVo("罗生天", "", R.drawable.ic_scense_third),
                DungeonVo("清虚天", "", R.drawable.ic_scense_one),
                DungeonVo("吉祥天", "", R.drawable.ic_scense_second)
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