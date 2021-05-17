package com.nl.module.relationship

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class RelationshipView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val column = 2

    private val mRelationshipList = mutableListOf<RelationshipVo>()

    private val mRelationshipWidthList = mutableListOf<Int>()
    private val mRelationshipHeightList = mutableListOf<Int>()

    private var mMaxWidth = 0F
    private var mMaxHeight = 0F

    private var mColumnGap = 50F

    private var mActiveColor = 0
    private var mNegativeColor = 0

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mRect = Rect()

    init {
        mPaint.textSize = 48F

        mActiveColor = Color.parseColor("#FF0000")
        mNegativeColor = Color.parseColor("#CCCCCC")

        mMaxWidth = mPaint.measureText("一")
        mMaxHeight = mPaint.descent() - mPaint.ascent()

        mRelationshipList.addAll(
            mutableListOf(
                RelationshipVo("丽人行", true),
                RelationshipVo("青梅竹马", true),
                RelationshipVo("道心羁绊", false),
                RelationshipVo("轮回毒誓", false),
                RelationshipVo("同为人妖", false),
                RelationshipVo("七窍雪莲", true)
            )
        )

        measureRelationshipSpec(mRelationshipList)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        //val measureHeight = MeasureSpec.getSize(heightMeasureSpec)

        val row = if (mRelationshipList.size % column == 0) {
            mRelationshipList.size / column
        } else {
            mRelationshipList.size / column + 1
        }

        var expectWidth: Int = (mMaxWidth * column).toInt() + paddingStart + paddingEnd
        val expectHeight: Int =
            (mMaxHeight * row + mColumnGap * (row - 1)).toInt() + paddingTop + paddingBottom

        if (expectWidth < measureWidth) {
            expectWidth = measureWidth
        }
//        if (expectHeight < measureHeight) {
//            expectHeight = measureHeight
//        }
        setMeasuredDimension(expectWidth, expectHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mRelationshipList.forEachIndexed { index, relationshipVo ->
            val row = index / column
            val textX = if (index % column == 0) {
                (width shr 2).toFloat() - (mRelationshipWidthList[index] shr 1)
            } else {
                (width shr 2) * 3F - (mRelationshipWidthList[index] shr 1)
            }
            val textY =
                paddingTop + row * mMaxHeight + mColumnGap * row + mRelationshipHeightList[index]

            mPaint.color = if (relationshipVo.isActive) {
                mActiveColor
            } else {
                mNegativeColor
            }
            canvas.drawText(relationshipVo.name, textX, textY, mPaint)
        }
    }

    private fun measureRelationshipSpec(list: MutableList<RelationshipVo>) {
        if (list.isEmpty()) return

        mRelationshipWidthList.clear()
        mRelationshipHeightList.clear()

        list.forEach { relationship ->
            mPaint.getTextBounds(relationship.name, 0, relationship.name.length, mRect)
            val currentWidth = mRect.right - mRect.left
            mRelationshipWidthList.add(currentWidth)
            if (currentWidth > mMaxWidth) mMaxWidth = currentWidth.toFloat()

            val currentHeight = mRect.bottom - mRect.top
            mRelationshipHeightList.add(currentHeight)
            if (currentHeight > mMaxHeight) mMaxHeight = currentHeight.toFloat()
        }
    }

    fun setRelationships(list: MutableList<RelationshipVo>) {
        mRelationshipList.clear()
        mRelationshipList.addAll(list)
        measureRelationshipSpec(list)
        invalidate()
    }
}