package com.nl.module.equipment.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.june.base.basic.ext.setLinearManager
import com.nl.module.equipment.R
import com.nl.module.equipment.strengthen.StrengthAdditionVo
import com.nl.module.equipment.strengthen.StrengthenAttrAdapter

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