package com.june.northland.feature.backpack.goods

import android.annotation.SuppressLint
import android.os.Bundle
import com.june.base.basic.decoration.GridItemDecoration
import com.june.base.basic.ext.setGridManager
import com.june.northland.R
import com.june.northland.databinding.FragmentGoodsListBinding
import com.nl.component.NLBaseFragment

class GoodsListFragment : NLBaseFragment<FragmentGoodsListBinding>() {

    private val mAdapter = GoodsAdapter()

    override fun initView() {
        mBinding.rvGoods.apply {
            setGridManager(4)
            adapter = mAdapter
            setHasFixedSize(true)
            addItemDecoration(
                GridItemDecoration(
                    4,
                    resources.getDimensionPixelSize(R.dimen.dp_5)
                )
            )
        }
    }

    @SuppressLint("MissingSuperCall")
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