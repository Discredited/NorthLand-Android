package com.june.northland.feature.lineup

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.activity_line_up.*
import timber.log.Timber

/**
 * 阵容
 */
class LineUpActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_line_up

    override fun initView() {

        tvPrompt.click {
            val lineUp = vLineUp.getLineUp()
            Timber.e(lineUp.toString())
        }
    }

    override fun loadData() {
        vLineUp.setLineUp(
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