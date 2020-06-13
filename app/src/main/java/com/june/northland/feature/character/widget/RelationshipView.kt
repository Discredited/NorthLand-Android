package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.base.ext.setGridManager
import com.june.northland.feature.character.RelationshipAdapter
import com.june.northland.feature.character.RelationshipVo

class RelationshipView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val mAdapter =
        RelationshipAdapter()

    override fun onFinishInflate() {
        super.onFinishInflate()
        setGridManager(2)
        adapter = mAdapter
        setHasFixedSize(true)
        //addItemDecoration(GridItemDecoration(2))
    }

    fun setRelationship(relationships: MutableList<RelationshipVo>) {
        mAdapter.setNewInstance(relationships)
    }
}