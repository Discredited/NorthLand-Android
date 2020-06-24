package com.june.northland.feature.lineup

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.june.northland.base.ext.setGridManager
import com.june.northland.common.GridItemDecoration
import timber.log.Timber
import java.util.*

/**
 * 阵容视图
 */
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

            private var from: Int = -1
            private var to: Int = -1

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
                from = viewHolder.adapterPosition
                to = target.adapterPosition
                return false
            }

            override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
            }

            override fun clearView(recyclerView: RecyclerView, viewHolder: ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                if (from >= 0 && to >= 0 && from != to) {
                    Timber.e("clearView    from:$from    to:$to")
                    Collections.swap(mAdapter.data, from, to)
                    mAdapter.notifyItemChanged(to)
                    mAdapter.notifyItemChanged(from)
                }
            }
        }).attachToRecyclerView(this)
    }

    fun setLineUp(list: MutableList<LineUpVo>) {
        mAdapter.setNewInstance(list)
    }

    fun getLineUp(): MutableList<LineUpVo> {
        return mAdapter.data
    }
}