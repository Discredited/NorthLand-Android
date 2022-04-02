package com.nl.module.characters.list

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.nl.component.NLBaseActivity
import com.nl.component.ext.itemClick
import com.nl.module.characters.CharacterViewModel
import com.nl.module.characters.databinding.ActivityCharacterListBinding
import com.nl.module.characters.detail.CharacterDetailActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * 人物列表
 */
class CharacterListActivity : NLBaseActivity<ActivityCharacterListBinding>() {

    private val mCharacterViewModel by viewModels<CharacterViewModel>()
    private val mAdapter = CharacterListAdapter()

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
        lifecycleScope.launch {
            mCharacterViewModel.characterList().collect {
                mAdapter.setNewInstance(it)
            }
        }
    }
}