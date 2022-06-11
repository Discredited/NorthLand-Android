package com.nl.module.store.recruit

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ToastUtils
import com.june.widget.explosion.ExplosionFieldView
import com.nl.component.NLBaseActivity
import com.nl.component.ext.click
import com.nl.component.ext.loadImage
import com.nl.lib.element.role.PlayerRoleEntity
import com.nl.module.store.databinding.ActivityRecruitResultBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecruitResultActivity : NLBaseActivity<ActivityRecruitResultBinding>() {

    private val mViewModel by viewModels<RecruitViewModel>()

    private val mExplosionView by lazy { ExplosionFieldView.attach2Window(this) }

    override fun initView() {
    }

    override fun loadData() {
        lifecycleScope.launch {
            mViewModel.mRecruitRoleFlow.collect { playerRole ->
                playerRole?.let { setRecruitResult(it) }
            }
            mViewModel.mErrorFlow.collect { ToastUtils.showShort(it) }
        }
        requestRecruit()
    }

    private fun requestRecruit() {
        mViewModel.recruitRole("1001")
    }

    private fun setRecruitResult(playerRole: PlayerRoleEntity) {
        mBinding.ivRecruitAvatar.loadImage(playerRole.avatar)
        mBinding.tvRecruitName.text = playerRole.name
        boom()
    }

    private fun boom() {
        mBinding.tvRecruitSlogan.text = "沙罗铁树，只为自己盛开"
        mBinding.tvRecruitSlogan.visibility = View.VISIBLE

        mBinding.flRecruitSlogan.click {
            mExplosionView?.explode(it)
        }
    }
}