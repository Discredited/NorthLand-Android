package com.june.northland

import android.content.Intent
import com.june.northland.base.component.BaseActivity
import com.june.northland.feature.character.CharacterConfigActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        tvToCharacterConfig.setOnClickListener {
            startActivity(Intent(this, CharacterConfigActivity::class.java))
        }
    }

    override fun loadData() {
    }
}