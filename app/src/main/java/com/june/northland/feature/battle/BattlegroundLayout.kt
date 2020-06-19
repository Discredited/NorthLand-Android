package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.LinearLayoutCompat

class BattlegroundLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mColumn = 3 // 一列显示多少个
    private val mBattleCount = 12 // Battle数量

    private val mBattleMap = mutableMapOf<String, BattleView>()

    private val mDefaultParams = LinearLayoutCompat.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    init {

        initBattleView()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        //val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        val itemSize = specWidth / mColumn
        mDefaultParams.width = itemSize
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        //super.onLayout(changed, left, top, right, bottom)

    }

    private fun initBattleView() {
        for (index in 0..mBattleCount) {
            val battleView = BattleView(context)
            mBattleMap["$index"] = battleView
            addView(battleView, mDefaultParams)
        }
    }
}