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
import androidx.core.animation.addListener
import androidx.core.view.children
import com.june.northland.feature.battle.vo.BattleResultVo
import com.june.northland.feature.battle.vo.BattleVo
import com.june.northland.feature.battle.vo.RoundVo
import timber.log.Timber
import java.util.*

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

    private var mRoundList = LinkedList<RoundVo>()

    private var mBattling: Boolean = false
    private var mBattleProcedureListener: BattleProcedureListener? = null

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
        val maxCount = mBattleOpponent.size.coerceAtLeast(mBattleOwnSide.size)
        return if (maxCount / mColumn > 0) {
            mColumn
        } else {
            maxCount % (mColumn + 1)
        }
    }

    fun bindSkillEffectView(view: AppCompatTextView) {
        mSkillEffectView = view
    }

    fun bindBattleProcedureListener(listener: BattleProcedureListener) {
        mBattleProcedureListener = listener
    }

    fun initBattle(battleResult: BattleResultVo) {
        Timber.e("生成了 ${battleResult.ownSideList.size} 个己方战员")
        Timber.e("生成了 ${battleResult.opponentList.size} 个敌方战员")
        mOpponent.addAll(battleResult.opponentList)
        mOwnSide.addAll(battleResult.ownSideList)

        Timber.e("生成了 ${battleResult.rounds.groupBy { it.round }.size} 个回合")
        Timber.e("生成了 ${battleResult.rounds.size} 次的战斗")
        battleResult.rounds.forEach {
            mRoundList.add(it)
        }

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

    fun roundStart(round: RoundVo) {
        // moverPosition 行动者的位置
        val moverPosition = round.attackPosition
        val target = round.defenderPosition
        val attackMode = round.attackType

        mAttackAnimator = if (attackMode == 1) {
            attackSkill(moverPosition)
        } else {
            // 找到目标者位置
            val targetPosition = target[0]
            attackNormal(moverPosition, targetPosition)
        }
        mAttackAnimator?.addListener(onEnd = {
            mAttackAnimator?.removeAllListeners()
            mAttackAnimator = null
            roundStart()
        })
        mAttackAnimator?.start()

        target.forEach {
            val battleView = getChildAt(it) as BattleView
            battleView.damage(20, moverPosition % 3)
        }
    }

    fun roundStart() {
        if (mRoundList.isEmpty()) {
            //对战结束
            mBattling = false
            mBattleProcedureListener?.onBattleFinish()
            return
        }
        if (!mBattling) {
            mBattling = true
            mBattleProcedureListener?.onBattleBegin()
        }
        roundStart(mRoundList.pop())
    }

    private fun attackNormal(moverPosition: Int, targetPosition: Int): ObjectAnimator {
        val targetView = getChildAt(targetPosition)
        val targetX = targetView.x
        val targetY = targetView.y

        val moverView = getChildAt(moverPosition)
        val moverX = moverView.x
        val moverY = moverView.y

        //判断是敌方进攻还是己方进攻
        val offsetX = targetX - moverX
        val offsetY = if (moverPosition >= mBattleOpponent.size) {
            //己方进攻
            (targetY - moverY) * 0.75F
        } else {
            //敌方进攻
            (targetY - moverY) * 0.75F
        }

        val translationX = PropertyValuesHolder.ofFloat("translationX", offsetX, 0F, 0F)
        val translationY = PropertyValuesHolder.ofFloat("translationY", offsetY, 0F, 0F)
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
        val offsetY = if (moverPosition > mOpponent.size) {
            -(moverView.height shr 1).toFloat()
        } else {
            (moverView.height shr 1).toFloat()
        }

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