package com.june.northland.feature.lineup

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.base.ext.setGridManager
import com.june.northland.common.GridItemDecoration

class LineUpView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val mAdapter = LineUpAdapter()

    init {
        setGridManager(4)
        adapter = mAdapter
        setHasFixedSize(true)
        addItemDecoration(GridItemDecoration(4, 30))

        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
                val dragFlags =
                    ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags, 0)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: ViewHolder,
                target: ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                val fromVo = mAdapter.data[from]
                val toVo = mAdapter.data[to]
                fromVo.position = to
                toVo.position = from
                mAdapter.notifyItemMoved(from, to)
                return true

            }

            override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
            }
        }).attachToRecyclerView(this)
    }

    fun setLineUp(list: MutableList<LineUpVo>) {
        mAdapter.setNewInstance(list)
    }
}