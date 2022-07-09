package com.nl.module.equipment

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.SpanUtils
import com.nl.component.AppViewModel
import com.nl.module.equipment.strengthen.StrengthAdditionVo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EquipmentViewModel(application: Application) : AppViewModel(application) {

    private val mEquipmentRepository = EquipmentRepository()
    val mEquipmentLive: MutableLiveData<EquipmentVo> = MutableLiveData()

    val mEquipmentsFlow: MutableSharedFlow<MutableList<EquipmentVo>> = MutableStateFlow(mutableListOf())

    fun equipmentList(part: Int = EquipmentHelper.PART_ALL) {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) { mEquipmentRepository.equipmentList(part) }
            mEquipmentsFlow.emit(list)
        }
    }

    fun equipmentDetail(id: String): EquipmentVo {
        val quality = (Math.random() * 10 % 6).toInt()
        val qualityString = EquipmentHelper.equipmentQuality(quality)

        val extraDesc = SpanUtils()
            .append("攻击+%10").setForegroundColor(ContextCompat.getColor(getApplication(), R.color.color_attack))
            .appendLine()
            .append("暴击+%5").setForegroundColor(ContextCompat.getColor(getApplication(), R.color.color_speed))
            .create()

        val equipment = EquipmentVo(
            name = "${qualityString}长剑",
            icon = EquipmentHelper.equipmentIcon(quality),
            value = 1000,
            quality = quality,
            basicDesc = "攻击力+1000",
            id = id,
            extraDesc = extraDesc
        )

        equipment.strengthenAdditions?.addAll(
            mutableListOf(
                StrengthAdditionVo("攻击+5%", 0, "激活", true),
                StrengthAdditionVo("暴击+5%", -1, "未激活", false),
                StrengthAdditionVo("命中+10%", 1, "已激活", false),
                StrengthAdditionVo("防御+20%", 0, "激活", true)
            )
        )

        mEquipmentLive.value = equipment
        return equipment
    }

    //打造装备信息
    fun equipmentBuildInfo(part: Int): EquipmentVo {
        return EquipmentVo()
    }

    //打造装备
    fun equipmentBuild(part: Int): EquipmentVo {
        return EquipmentVo()
    }

    //强化装备
    fun equipmentStrengthen(id: String, level: Int) {

    }

    //锻造装备
    fun equipmentForging(id: String) {
        val equipment = mEquipmentLive.value
        val forgingQuality = (equipment?.quality ?: 0) + 1
        val forgingName = "${EquipmentHelper.equipmentQuality(forgingQuality)}长剑"
        val forgingValueUpgrade = forgingQuality * 100
        val forgingValue = (forgingQuality + 1) * 1000 + (equipment?.strengthen ?: 0 * forgingValueUpgrade)

        val forgingEquipment = EquipmentVo(
            name = forgingName,
            value = forgingValue,
            part = equipment?.part ?: 0,
            id = equipment?.id ?: "",
            quality = forgingQuality,
            valueGrowth = equipment?.valueGrowth ?: 0,
            property = equipment?.property ?: 0,
            extraDesc = equipment?.extraDesc ?: "",
            strengthenGrowth = equipment?.strengthenGrowth ?: 0,
            strengthen = equipment?.strengthen ?: 0,
            strengthenAdditions = equipment?.strengthenAdditions ?: mutableListOf()
        )
        mEquipmentLive.value = forgingEquipment
    }

    //增幅
    fun equipmentIncrease() {

    }

    //洗练
    fun increaseRefine() {

    }
}