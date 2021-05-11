package com.june.northland.feature.backpack.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.base.basic.ext.setGridManager
import com.june.northland.R
import com.june.base.basic.part.BaseFragment
import com.june.northland.common.GridItemDecoration
import com.june.northland.databinding.FragmentGoodsListBinding

class GoodsListFragment : BaseFragment<FragmentGoodsListBinding>() {

    private val mAdapter = GoodsAdapter()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGoodsListBinding {
        return FragmentGoodsListBinding.inflate(inflater, container, false)
    }

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