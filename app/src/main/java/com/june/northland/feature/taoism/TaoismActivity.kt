package com.june.northland.feature.taoism

import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.feature.taoism.arena.ArenaListActivity
import com.june.northland.feature.taoism.ladder.LadderListActivity
import com.june.northland.utils.Toast
import kotlinx.android.synthetic.main.activity_taoism.*
import kotlinx.android.synthetic.main.view_close_image.*

/**
 * @author June
 * @description 论道
 * @version 1.0.0
 * @time 2020/8/6 14:47
 */
class TaoismActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_taoism

    override fun initView() {
        cdArena.click {
            startActivity(Intent(this, ArenaListActivity::class.java))
        }
        cdLadder.click {
            startActivity(Intent(this, LadderListActivity::class.java))
        }
        cdLeague.click {
            Toast.toastShort(getString(R.string.str_stay_tuned))
        }
        cdView.click {
            Toast.toastShort(getString(R.string.str_stay_tuned))
        }

        ivClose.click { finish() }
    }

    override fun loadData() {
    }
}