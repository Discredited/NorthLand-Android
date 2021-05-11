package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.june.base.basic.ext.setGridManager
import com.june.northland.feature.relationship.RelationshipDisplayAdapter
import com.june.northland.feature.relationship.RelationshipVo

class RelationshipDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val mAdapter =
        RelationshipDisplayAdapter()

    override fun onFinishInflate() {
        super.onFinishInflate()
        setGridManager(2)
        adapter = mAdapter
        setHasFixedSize(true)
    }

    fun setRelationship(relationships: MutableList<RelationshipVo>) {
        mAdapter.setNewInstance(relationships)
    }
}