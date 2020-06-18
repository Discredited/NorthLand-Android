package com.june.northland.feature.lineup

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.activity_line_up.*

/**
 * 阵容
 */
class LineUpActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_line_up

    override fun initView() {
        add.click {
//            val progress = vExperience.getProgress() + 10
//            vExperience.setProgress(progress)
            vHealthView.restore(70)
        }
        sub.click {
//            val progress = vExperience.getProgress() - 10
//            vExperience.setProgress(progress)
            vHealthView.damage(90)
        }
    }

    override fun loadData() {
        vExperience.initExperience(0, 0, 100, 20)
    }
}