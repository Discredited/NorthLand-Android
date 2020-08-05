package com.june.northland.feature.taoism

import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.activity_taoism.*

class TaoismActivity : BaseActivity() {
    
    override fun getLayoutResId(): Int = R.layout.activity_taoism

    override fun initView() {
        cdArena.click {  }
        cdLadder.click {  }
        cdLeague.click {  }
    }

    override fun loadData() {
    }
}