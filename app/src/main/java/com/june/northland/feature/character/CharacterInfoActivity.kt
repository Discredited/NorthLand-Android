package com.june.northland.feature.character

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import kotlinx.android.synthetic.main.activity_character_info.*

class CharacterInfoActivity : BaseActivity() {

    private var mRealm: Int = 0

    override fun getLayoutResId(): Int = R.layout.activity_character_info

    override fun initView() {
        tvRealmUpgrade.setOnClickListener {
            val drawable = getRealDrawable(mRealm % 9)
            ivCharacter.background = drawable

            mRealm++
        }
    }

    override fun loadData() {

    }

    private fun getRealDrawable(realm: Int): Drawable {
        val shapeDrawable = GradientDrawable()
        shapeDrawable.setColor(ContextCompat.getColor(this, R.color.color_bg_alpha_black))
        shapeDrawable.setStroke(
            resources.getDimensionPixelSize(R.dimen.dp_5),
            ContextCompat.getColor(this, getRealmColor(realm))
        )
        shapeDrawable.cornerRadius = resources.getDimension(R.dimen.dp_5)
        return shapeDrawable
    }

    private fun getRealmColor(realm: Int): Int {
        return when (realm) {
            2 -> R.color.color_quality_intermediate
            3 -> R.color.color_quality_advanced
            4 -> R.color.color_quality_rare
            5 -> R.color.color_quality_artifact
            6 -> R.color.color_quality_brave
            7 -> R.color.color_quality_legend
            8 -> R.color.color_quality_epic
            else -> R.color.color_quality_ordinary
        }
    }
}