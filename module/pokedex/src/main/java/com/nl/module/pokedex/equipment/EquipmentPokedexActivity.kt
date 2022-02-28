package com.nl.module.pokedex.equipment

import androidx.recyclerview.widget.GridLayoutManager
import com.nl.component.NLBaseActivity
import com.nl.module.pokedex.databinding.ActivityEquipmentPokedexBinding

class EquipmentPokedexActivity : NLBaseActivity<ActivityEquipmentPokedexBinding>() {

    private val mAdapter = EquipmentPokedexAdapter()

    override fun initView() {
        mBinding.rvEquipmentPokedex.apply {
            layoutManager = GridLayoutManager(this@EquipmentPokedexActivity, 3)
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    override fun loadData() {

    }
}