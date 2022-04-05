package com.nl.module.role.detail

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.nl.component.common.FilePathHelper
import com.nl.component.ext.loadAvatar
import com.nl.component.ext.setDrawable
import com.nl.lib.element.enum.*
import com.nl.lib.element.role.RoleEntity
import com.nl.module.role.R
import com.nl.module.role.databinding.WidgetRoleDetailLayoutBinding

/**
 * 角色详情
 *
 * 2022/4/5
 * @author June
 */
class RoleDetailView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val mBinding = WidgetRoleDetailLayoutBinding.inflate(LayoutInflater.from(context), this)

    fun setRole(role: RoleEntity) {
        val qualityColor = ContextCompat.getColor(context, QualityEnum.getQualityColor(role.quality))
        mBinding.flAvatar.setDrawable(qualityColor, cornerRadius = 0F)
        mBinding.ivRoleAvatar.loadAvatar(FilePathHelper.getCharacterAvatar(role.avatar))

        mBinding.tvQuality.setDrawable(ContextCompat.getColor(context, R.color.color_bg_alpha_black), 0F)
        mBinding.tvQuality.setTextColor(qualityColor)
        mBinding.tvQuality.text = QualityEnum.getQualityName(role.quality)

        mBinding.tvRoleName.setTextColor(qualityColor)
        mBinding.tvRoleName.text = role.name

        mBinding.tvRoleRace.text = "种族:${RaceEnum.getRaceName(role.race)}"
        mBinding.tvRoleFaction.text = "阵营:${FactionEnum.getFactionName(role.faction)}"

        val powerColor = ContextCompat.getColor(context, PowerEnum.getPowerColor(role.power))
        val powerSpan = buildSpan("妖力", PowerEnum.getPowerName((role.power)), powerColor)
        mBinding.tvRolePower.text = powerSpan

        val realmColor = ContextCompat.getColor(context, RealmEnum.getRealmColor(role.realm))
        val realmSpan = buildSpan("境界", RealmEnum.getRealmName((role.realm)), realmColor)
        mBinding.tvRoleRealm.text = realmSpan
    }

    private fun buildSpan(title: String, content: String, color: Int): SpannableString {
        val data = "${title}:${content}"
        val spannableString = SpannableString(data)
        spannableString.setSpan(
            ForegroundColorSpan(color),
            title.length,
            data.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }
}