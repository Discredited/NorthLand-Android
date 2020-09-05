package com.june.northland.feature.equipment

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.SpanUtils
import com.june.northland.R
import com.june.northland.base.component.AppViewModel
import com.june.northland.common.ConstantUtils

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
        mEquipmentLive.value = equipment
        return equipment
    }

    fun equipmentBuildInfo(part: Int): EquipmentVo {
        return ConstantUtils.randomEquipment(part)
    }
}