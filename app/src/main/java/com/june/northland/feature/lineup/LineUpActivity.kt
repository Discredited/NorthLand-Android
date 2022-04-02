package com.june.northland.feature.lineup

import com.june.base.basic.ext.click
import com.june.northland.R
import com.june.northland.databinding.ActivityLineUpBinding
import com.nl.component.NLBaseActivity
import timber.log.Timber

/**
 * 阵容
 */
class LineUpActivity : NLBaseActivity<ActivityLineUpBinding>() {

    override fun initView() {

        mBinding.tvPrompt.click {
            val lineUp = mBinding.vLineUp.getLineUp()
            Timber.e(lineUp.toString())
        }
    }

    override fun loadData() {
        mBinding.vLineUp.setLineUp(
            mutableListOf(
                LineUpVo(R.drawable.ic_avatar_gan_ning_zhen, 0, true),
                LineUpVo(R.drawable.ic_avatar_hai_ji, 1, true),
                LineUpVo(R.drawable.ic_avatar_jiu_dan_mei, 2, true),
                LineUpVo(R.drawable.ic_avatar_gan_ning_zhen_1, 3, true),

                LineUpVo(0, 4, false),
                LineUpVo(0, 5, false),
                LineUpVo(0, 6, false),
                LineUpVo(0, 7, false)
            )
        )
    }
}