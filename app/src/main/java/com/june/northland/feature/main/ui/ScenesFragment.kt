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
import com.june.northland.feature.character.CharacterVo
import com.june.northland.feature.main.MainActivity
import com.june.northland.feature.main.vo.MenuVo
import com.june.northland.feature.main.vo.PlotVo
import kotlinx.android.synthetic.main.fragment_main_scene.*

class ScenesFragment : BaseFragment() {

    private val mCharacterAdapter = ScenesCharacterAdapter()
    private val mMenuAdapter = ScenesMenuAdapter()
    private val mPlotAdapter = ScenesPlotAdapter()

    override fun getLayoutResId(): Int = R.layout.fragment_main_scene

    override fun initView() {
        //阵容人物
        mCharacterAdapter.itemClick { _, _, _ ->
            val characterInfoFragment = CharacterInfoFragment()
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
                0 -> startActivity(Intent(requireActivity(), BackpackActivity::class.java))
                else -> ToastUtils.showShort("没有这个按钮")
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
                CharacterVo(),
                CharacterVo(),
                CharacterVo(),
                CharacterVo(),
                CharacterVo(),
                CharacterVo(),
                CharacterVo(),
                CharacterVo()
            )
        )
    }

    private fun requestPlot() {
        mPlotAdapter.setNewInstance(
            mutableListOf(
                PlotVo("红尘天", R.drawable.ic_scense_one),
                PlotVo("魔刹天", R.drawable.ic_scense_second),
                PlotVo("罗生天", R.drawable.ic_scense_third),
                PlotVo("清虚天", R.drawable.ic_scense_one),
                PlotVo("吉祥天", R.drawable.ic_scense_second)
            )
        )
    }

    private fun initMenu() {
        mMenuAdapter.setNewInstance(
            mutableListOf(
                MenuVo("背包", R.drawable.ic_defense),
                MenuVo("阵容", R.drawable.ic_health),
                MenuVo("关卡", R.drawable.ic_speed),
                MenuVo("竞技场", R.drawable.ic_critical),
                MenuVo("其他", R.drawable.ic_resister)
            )
        )
    }
}