package com.june.northland.feature.equipment.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.R
import com.june.northland.base.ext.setLinearManager
import com.june.northland.feature.equipment.strengthen.StrengthAdditionVo

class StrengthenAdditionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val mAdapter = StrengthenAttrAdapter()
    private var mActiveListener: AdditionActiveListener? = null

    init {
        mAdapter.addChildClickViewIds(R.id.btAdditionStatus)
        mAdapter.setOnItemChildClickListener { _, _, position ->
            mActiveListener?.onAdditionActive(position)
        }

        setLinearManager()
        adapter = mAdapter
        setHasFixedSize(true)
    }

    fun initAdditionActive(listener: AdditionActiveListener) {
        mActiveListener = listener
    }

    fun initAddition(additions: MutableList<StrengthAdditionVo>) {
        mAdapter.setNewInstance(additions)
    }

    fun additionChanged(position: Int) {
        mAdapter.notifyItemChanged(position)
    }
}