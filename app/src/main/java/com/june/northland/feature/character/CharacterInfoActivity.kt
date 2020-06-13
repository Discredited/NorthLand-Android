package com.june.northland.feature.character

import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.setDrawable
import com.june.northland.utils.ColorUtils
import kotlinx.android.synthetic.main.activity_character_info.*

class CharacterInfoActivity : BaseActivity() {

    private var mRealm: Int = 0

    override fun getLayoutResId(): Int = R.layout.activity_character_info

    override fun initView() {
        tvRealmUpgrade.setOnClickListener {
            ivCharacter.setDrawable(
                ContextCompat.getColor(
                    this,
                    ColorUtils.getRealmColor(mRealm % 9)
                )
            )
            mRealm++
        }
    }

    override fun loadData() {

    }
}