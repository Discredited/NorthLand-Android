package com.june.northland.feature.taoism

import android.content.Intent
import com.june.base.basic.ext.click
import com.june.northland.R
import com.june.northland.databinding.ActivityTaoismBinding
import com.june.northland.feature.taoism.arena.ArenaListActivity
import com.june.northland.feature.taoism.ladder.LadderListActivity
import com.june.northland.utils.Toast
import com.nl.component.NLBaseActivity

/**
 * @author June
 * @description 论道
 * @version 1.0.0
 * @time 2020/8/6 14:47
 */
class TaoismActivity : NLBaseActivity<ActivityTaoismBinding>() {

    override fun initView() {
        mBinding.cdArena.click {
            startActivity(Intent(this, ArenaListActivity::class.java))
        }
        mBinding.cdLadder.click {
            startActivity(Intent(this, LadderListActivity::class.java))
        }
        mBinding.cdLeague.click {
            Toast.toastShort(getString(R.string.str_stay_tuned))
        }
        mBinding.cdView.click {
            Toast.toastShort(getString(R.string.str_stay_tuned))
        }

        mBinding.iClose.ivClose.click { finish() }
    }

    override fun loadData() {
    }
}