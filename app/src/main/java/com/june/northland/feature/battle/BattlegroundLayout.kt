package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children
import com.june.northland.R
import timber.log.Timber

class BattlegroundLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mColumn = 3 // 一列显示多少个
    private val mBattleCount = 6 // Battle数量

    private val mBattleGap = context.resources.getDimension(R.dimen.dp_50)

    private var mBattleWidth = 0

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
        mBattleWidth = ((specWidth - mBattleGap * 2) / mColumn).toInt()
        mDefaultParams.width = mBattleWidth
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        //super.onLayout(changed, left, top, right, bottom)
        children.forEachIndexed { index, child ->
            val row = (index + 1) / mColumn

            val childLeft = index * mBattleWidth
            val childTop = row * child.height
            val childRight = left + mBattleWidth
            val childBottom = bottom + child.height

            Timber.e("childLeft:$childLeft    childTop:$childTop    childRight:$childRight    childBottom:$childBottom")

            child.layout(childLeft, childTop, childRight, childBottom)
        }
    }

    private fun initBattleView() {
        for (index in 0..mBattleCount) {
            val battleView = BattleView(context)
            mBattleMap["$index"] = battleView
            addView(battleView, mDefaultParams)
        }
    }
}