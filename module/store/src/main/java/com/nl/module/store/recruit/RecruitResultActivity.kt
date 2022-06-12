package com.nl.module.store.recruit

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ToastUtils
import com.june.widget.explosion.ExplosionFieldView
import com.nl.component.NLBaseActivity
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.click
import com.nl.component.ext.loadImage
import com.nl.module.store.databinding.ActivityRecruitResultBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecruitResultActivity : NLBaseActivity<ActivityRecruitResultBinding>() {

    private val mViewModel by viewModels<RecruitViewModel>()

    private val mExplosionView by lazy { ExplosionFieldView.attach2Window(this) }

    private val mRunnable = Runnable {
        mBinding.llRecruitContainer.visibility = View.VISIBLE
    }

    override fun initView() {
        mExplosionView
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

    private fun setRecruitResult(role: RecruitRoleVo) {
        mBinding.ivRecruitAvatar.loadImage(FilePathHelper.getCharacterAvatar(role.avatar))
        mBinding.tvRecruitName.text = role.name
        boom(role.getSlogan())
    }

    private fun boom(slogan: String) {
        mBinding.tvRecruitSlogan.text = slogan
        mBinding.tvRecruitSlogan.visibility = View.VISIBLE

        mBinding.flRecruitSlogan.click {
            mExplosionView?.explode(it)
            mBinding.llRecruitContainer.postDelayed(mRunnable, 400)
        }
    }

    override fun onDestroy() {
        mBinding.llRecruitContainer.removeCallbacks(mRunnable)
        super.onDestroy()
    }
}