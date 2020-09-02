package com.june.northland.feature.battle

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children
import com.june.northland.feature.battle.vo.BattleVo
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
    private val mOpponent = mutableListOf<BattleVo>()
    private val mBattleOpponent = mutableListOf<BattleView>()

    //己方
    private val mOwnSide = mutableListOf<BattleVo>()
    private val mBattleOwnSide = mutableListOf<BattleView>()

    private val mDefaultParams = LinearLayoutCompat.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    private var mAttackAnimator: ObjectAnimator? = null

    private var mSkillEffectView: AppCompatTextView? = null

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

    fun initBattleView(ownSide: MutableList<BattleVo>, opponent: MutableList<BattleVo>) {
        Timber.e("生成了 ${ownSide.size} 个己方战员")
        Timber.e("生成了 ${opponent.size} 个敌方战员")
        mOpponent.addAll(opponent)
        mOwnSide.addAll(ownSide)

        mOpponent.forEach {
            val battleView = BattleView(context)
            battleView.setBattleVo(it)
            mBattleOpponent.add(battleView)
            addView(battleView, mDefaultParams)
        }
        mOwnSide.forEach {
            val battleView = BattleView(context)
            battleView.setBattleVo(it)
            mBattleOwnSide.add(battleView)
            addView(battleView, mDefaultParams)
        }
    }

    fun bindSkillEffectView(view: AppCompatTextView) {
        mSkillEffectView = view
    }

    fun roundStart(mover: Int = 0, target: Int = 0, attackMode: Int = 0) {
        //行动者的位置
        val moverPosition = (mBattleOpponent.size + (mover % mBattleOwnSide.size))
        //找到目标者位置
        val targetPosition = target % mBattleOpponent.size

        val attackSkill = attackMode == 1

        mAttackAnimator = if (attackSkill) {
            attackSkill(moverPosition)
        } else {
            attackNormal(moverPosition, targetPosition)
        }
        mAttackAnimator?.start()

        val battleView = getChildAt(targetPosition) as BattleView
        battleView.damage(20)
    }

    private fun attackNormal(moverPosition: Int, targetPosition: Int): ObjectAnimator {
        val targetView = getChildAt(targetPosition)
        val targetX = targetView.x
        val targetY = targetView.y

        val moverView = getChildAt(moverPosition)
        val moverX = moverView.x
        val moverY = moverView.y

        val offsetX = targetX - moverX
        val offsetY = (moverY - targetY) * 0.75F

        val translationX = PropertyValuesHolder.ofFloat("translationX", offsetX, 0F, 0F)
        val translationY = PropertyValuesHolder.ofFloat("translationY", -offsetY, 0F, 0F)
        val translationZ = PropertyValuesHolder.ofFloat("translationZ", 1F, 0F, 0F)

        val animator = ObjectAnimator.ofPropertyValuesHolder(
            moverView,
            translationX,
            translationY,
            translationZ
        )
        animator.interpolator = null
        animator.duration = 600
        return animator
    }

    private fun attackSkill(moverPosition: Int): ObjectAnimator {
        val moverView = getChildAt(moverPosition)
        val offsetY = -(moverView.height shr 1).toFloat()

        val translationY = PropertyValuesHolder.ofFloat("translationY", 0F, offsetY, 0F)
        val translationZ = PropertyValuesHolder.ofFloat("translationZ", 0F, 1F, 0F)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1F, 1.3F, 1F)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1F, 1.3F, 1F)

        mSkillEffectView?.let {
            it.text = "- 崩山裂地斩 -"
            val animator = ObjectAnimator.ofFloat(it, "alpha", 0F, 1F, 1F, 1F, 1F, 0F)
            animator.duration = 1200L
            animator.start()
        }

        val animator = ObjectAnimator.ofPropertyValuesHolder(
            moverView,
            translationY,
            translationZ,
            scaleX,
            scaleY
        )
        animator.interpolator = BattleSkillInterpolator()
        animator.duration = 1000
        return animator
    }

    override fun onDetachedFromWindow() {
        mAttackAnimator?.cancel()
        mAttackAnimator = null
        super.onDetachedFromWindow()
    }
}