package com.june.northland.feature.battle

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.june.northland.R
import com.june.northland.base.ext.setDrawable
import timber.log.Timber

class BattlegroundLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mColumn = 4 // 一列显示多少个
    private val mBattleCount = 8 // Battle数量

    private var mBgPadding = 0
    private var mBattleGap = 0
    private var mbgHalfHeight = 0

    private var mBattleWidth = 0
    private var mBattleHeight = 0

    //对手
    private val mBattleOpponent = mutableListOf<BattleView>()

    //己方
    private val mBattleOwnSide = mutableListOf<BattleView>()

    private val mDefaultParams = LinearLayoutCompat.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        mBattleWidth = (specWidth * 0.2F).toInt()
        mBattleHeight = mBattleWidth
        mBattleGap = (specWidth * 0.1F / 3).toInt()
        mBgPadding = (specWidth * 0.05F).toInt()
        mbgHalfHeight = specHeight / 2
        children.forEachIndexed { _, view ->
            view.layoutParams.width = mBattleWidth
            view.layoutParams.height = mBattleHeight
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        //super.onLayout(changed, left, top, right, bottom)
        children.forEachIndexed { index, child ->
            if (index < mBattleOpponent.size) {
                //对手布局
                val row = index / mColumn
                val column = index % mColumn

                val childLeft = mBgPadding + column * (mBattleWidth + mBattleGap)
                val childTop = if (row == 0) {
                    mbgHalfHeight - mBattleHeight * 2 - mBattleGap * 3
                } else {
                    mbgHalfHeight + mBattleGap * 2
                }
                val childRight = childLeft + mBattleWidth
                val childBottom = childTop + mBattleHeight

                Timber.e("row:$row    column$column    childLeft:$childLeft    childTop:$childTop    childRight:$childRight    childBottom:$childBottom")

                child.layout(childLeft, childTop, childRight, childBottom)
            } else {
                //己方布局
                //对手布局
                val position = index - mBattleOpponent.size
                val row = position / mColumn
                val column = position % mColumn

                val childLeft = mBgPadding + column * (mBattleWidth + mBattleGap)
                val childTop = if (row == 0) {
                    mbgHalfHeight - mBattleHeight - mBattleGap * 2
                } else {
                    mbgHalfHeight + mBattleHeight + mBattleGap * 3
                }
                val childRight = childLeft + mBattleWidth
                val childBottom = childTop + mBattleHeight

                Timber.e("row:$row    column$column    childLeft:$childLeft    childTop:$childTop    childRight:$childRight    childBottom:$childBottom")

                child.layout(childLeft, childTop, childRight, childBottom)
            }
        }
    }

    fun initBattleView() {
        val opponentColor = ContextCompat.getColor(context, R.color.color_quality_rare)
        val ownSideColor = ContextCompat.getColor(context, R.color.color_quality_epic)
        val strokeWidth = resources.getDimensionPixelSize(R.dimen.dp_1)
        val radius = resources.getDimension(R.dimen.dp_1)
        for (index in 0 until mBattleCount) {
            val battleView = BattleView(context)
            battleView.setDrawable(strokeColor = opponentColor, strokeWidth = strokeWidth, cornerRadius = radius)
            mBattleOpponent.add(battleView)
            addView(battleView, mDefaultParams)
        }
        for (index in 0 until mBattleCount) {
            val battleView = BattleView(context)
            battleView.setDrawable(strokeColor = ownSideColor, strokeWidth = strokeWidth, cornerRadius = radius)
            mBattleOwnSide.add(battleView)
            addView(battleView, mDefaultParams)
        }
    }
}