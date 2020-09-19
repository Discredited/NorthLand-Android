package com.june.northland.feature.equipment

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.SpanUtils
import com.june.northland.R
import com.june.northland.base.component.AppViewModel
import com.june.northland.common.ConstantUtils
import com.june.northland.feature.equipment.strengthen.StrengthAdditionVo

class EquipmentViewModel(application: Application) : AppViewModel(application) {

    val mEquipmentLive: MutableLiveData<EquipmentVo> = MutableLiveData()

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
            value = 1000,
            quality = quality,
            basicDesc = "攻击力+1000",
            extraDesc = extraDesc
        )

        equipment.strengthenAdditions.addAll(
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
        return ConstantUtils.randomEquipment(part)
    }

    //打造装备
    fun equipmentBuild(part: Int): EquipmentVo {
        return ConstantUtils.randomEquipment(part)
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
            coverIcon = equipment?.coverIcon ?: R.drawable.ic_attack,
            name = forgingName,
            value = forgingValue,
            part = equipment?.part ?: 0,
            id = equipment?.id ?: "",
            quality = forgingQuality,
            valueUpgrade = equipment?.valueUpgrade ?: 0,
            property = equipment?.property ?: 0,
            extraDesc = equipment?.extraDesc ?: "",
            strengthenMax = equipment?.strengthenMax ?: 0,
            strengthen = equipment?.strengthen ?: 0,
            strengthenAdditions = equipment?.strengthenAdditions ?: mutableListOf()
        )
        mEquipmentLive.value = forgingEquipment
    }
}