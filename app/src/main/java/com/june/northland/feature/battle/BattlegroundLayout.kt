package com.june.northland.feature.battle

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
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
    private var mBattleGap = 0  //BattleView的间距

    private var mbgHalfHeight = 0  //战场中间分割线
    private var mBgDivider = 0  //BattleView分割线高度(敌方和己方的距离)

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

    private var mAttackAnimator: ObjectAnimator? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        mBattleWidth = (specWidth * 0.2F).toInt()
        mBattleHeight = mBattleWidth
        mBattleGap = (specWidth * 0.1F / 3).toInt()

        val maxColumn = getMaxColumn()
        mBgPadding = (specWidth - mBattleWidth * maxColumn - mBattleGap * (maxColumn - 1)) / 2

        mBgDivider = mBattleGap * 3

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
                layoutOpponent(index, child)
            } else {
                //己方布局
                val position = index - mBattleOpponent.size
                layoutOwnSide(position, child)
            }
        }
    }

    private fun layoutOpponent(position: Int, child: View) {
        val row = position / mColumn
        val column = position % mColumn
        val childLeft = mBgPadding + column * (mBattleWidth + mBattleGap)
        val childTop = mbgHalfHeight - mBgDivider - mBattleHeight * (row + 1) - mBattleGap * row
        val childRight = childLeft + mBattleWidth
        val childBottom = childTop + mBattleHeight

        child.layout(childLeft, childTop, childRight, childBottom)
    }

    private fun layoutOwnSide(position: Int, child: View) {
        val row = position / mColumn
        val column = position % mColumn
        val childLeft = mBgPadding + column * (mBattleWidth + mBattleGap)
        val childTop = mbgHalfHeight + mBgDivider + (mBattleHeight + mBattleGap) * row
        val childRight = childLeft + mBattleWidth
        val childBottom = childTop + mBattleHeight

        child.layout(childLeft, childTop, childRight, childBottom)
    }

    private fun getMaxColumn(): Int {
        val opponentColumn = if (mBattleOpponent.size / mColumn > 0) {
            mColumn
        } else {
            mBattleOpponent.size % (mColumn + 1)
        }
        val ownSideColumn = if (mBattleOwnSide.size / mColumn > 0) {
            mColumn
        } else {
            mBattleOpponent.size % (mColumn + 1)
        }
        return opponentColumn.coerceAtLeast(ownSideColumn)
    }

    fun initBattleView() {

        val opponentSize = (Math.random() * 7).toInt() + 1
        val ownSideSize = (Math.random() * 7).toInt() + 1

        Timber.e("生成了 $opponentSize 个地方战员")
        Timber.e("生成了 $ownSideSize 个己方战员")

        val opponentColor = ContextCompat.getColor(context, R.color.color_quality_rare)
        val ownSideColor = ContextCompat.getColor(context, R.color.color_quality_epic)
        val strokeWidth = resources.getDimensionPixelSize(R.dimen.dp_2)
        val radius = resources.getDimension(R.dimen.dp_2)
        for (index in 0 until opponentSize) {
            val battleView = BattleView(context)
            battleView.setDrawable(strokeColor = opponentColor, strokeWidth = strokeWidth, cornerRadius = radius)
            battleView.setPosition(index + 1)
            mBattleOpponent.add(battleView)
            addView(battleView, mDefaultParams)
        }
        for (index in 0 until ownSideSize) {
            val battleView = BattleView(context)
            battleView.setPosition(index + 1)
            battleView.setDrawable(strokeColor = ownSideColor, strokeWidth = strokeWidth, cornerRadius = radius)
            mBattleOwnSide.add(battleView)
            addView(battleView, mDefaultParams)
        }
    }

    var mTargetPosition = 0

    fun roundStart() {
        //找到目标位置
        val targetPosition = mTargetPosition % mBattleOpponent.size
        val targetView = getChildAt(targetPosition)
        val targetCenterX = targetView.x
        val targetCenterY = targetView.y

        mTargetPosition++

        val translationX = PropertyValuesHolder.ofFloat("translationX", targetCenterX, 0F)
        val translationY = PropertyValuesHolder.ofFloat("translationY", -targetCenterY, 0F)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.3F, 1F)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.3F, 1F)

        mAttackAnimator = ObjectAnimator.ofPropertyValuesHolder(
            getChildAt(mBattleOpponent.size),
            translationX,
            translationY,
            scaleX,
            scaleY
        )
        mAttackAnimator?.duration = 1000
        mAttackAnimator?.start()

        for (index in 0 until mBattleOpponent.size) {
            val battleView = getChildAt(index) as BattleView
            battleView.damage(20)
        }
    }
}