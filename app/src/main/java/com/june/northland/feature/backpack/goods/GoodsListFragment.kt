package com.june.northland.feature.backpack.goods

import android.os.Bundle
import com.june.northland.R
import com.june.northland.base.component.BaseFragment
import com.june.northland.base.ext.setGridManager
import com.june.northland.common.GridItemDecoration
import kotlinx.android.synthetic.main.fragment_goods_list.*

class GoodsListFragment : BaseFragment() {

    private val mAdapter = GoodsAdapter()

    override fun getLayoutResId(): Int = R.layout.fragment_goods_list

    override fun initView() {
        rvGoods.setGridManager(4)
        rvGoods.adapter = mAdapter
        rvGoods.setHasFixedSize(true)
        rvGoods.addItemDecoration(
            GridItemDecoration(
                4,
                resources.getDimensionPixelSize(R.dimen.dp_5)
            )
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestGoods()
    }

    private fun requestGoods() {
        val list = mutableListOf<GoodsVo>()
        for (index in 0..30) {
            list.add(GoodsVo())
        }

        mAdapter.setNewInstance(list)
    }

    companion object {
        fun newInstance(type: Int): GoodsListFragment {
            val fragment = GoodsListFragment()
            val args = Bundle()
            args.putInt("TYPE", type)
            fragment.arguments = args
            return fragment
        }
    }
}