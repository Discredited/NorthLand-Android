package com.nl.module.characters.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.june.base.basic.decoration.GridItemDecoration
import com.june.base.basic.ext.setGridManager
import com.nl.module.characters.R

class MagicDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val mAdapter = com.nl.module.magic.MagicDisplayAdapter()

    override fun onFinishInflate() {
        super.onFinishInflate()
        setGridManager(4)
        adapter = mAdapter
        setHasFixedSize(true)
        addItemDecoration(GridItemDecoration(3, resources.getDimensionPixelSize(R.dimen.dp_10)))
    }

    fun setMagic(magics: MutableList<com.nl.module.magic.MagicVo>) {
        mAdapter.setNewInstance(magics)
    }
}