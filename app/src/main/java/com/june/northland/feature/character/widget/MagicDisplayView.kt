package com.june.northland.feature.character.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.R
import com.june.northland.base.ext.setGridManager
import com.june.northland.common.GridItemDecoration
import com.june.northland.feature.magic.MagicDisplayAdapter
import com.june.northland.feature.magic.MagicVo

class MagicDisplayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val mAdapter = MagicDisplayAdapter()

    override fun onFinishInflate() {
        super.onFinishInflate()
        setGridManager(4)
        adapter = mAdapter
        setHasFixedSize(true)
        addItemDecoration(GridItemDecoration(3, resources.getDimensionPixelSize(R.dimen.dp_10)))
    }

    fun setMagic(magics: MutableList<MagicVo>) {
        mAdapter.setNewInstance(magics)
    }
}