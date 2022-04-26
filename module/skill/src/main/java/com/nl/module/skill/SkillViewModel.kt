package com.nl.module.skill

import android.text.SpannableStringBuilder
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nl.lib.element.enum.CommonEnum
import com.nl.room.RoomHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 技能ViewModel
 *
 * 2022/4/23
 * @author June
 */
class SkillViewModel : ViewModel() {

    private val skillDao by lazy { RoomHelper.getInstance().database().skillDao() }
    private val effectDao by lazy { RoomHelper.getInstance().database().effectDao() }

    val skillListFlow: MutableStateFlow<MutableList<SkillVo>> = MutableStateFlow(mutableListOf())

    fun loadSkillList() {
        viewModelScope.launch {
            val skillList: MutableList<SkillVo> = withContext(Dispatchers.IO) {
                val skills = mutableListOf<SkillVo>()
                skillDao.loadSkills().forEach { skillEntity ->
                    val effects = effectDao.findEffectByRelation(
                        relationId = skillEntity.id,
                        relationType = CommonEnum.OBJECT_SKILL
                    )

                    val stringBuilder = SpannableStringBuilder()
                    effects?.forEach { effect->
                        stringBuilder.append("")
                    }

                    skills.add(
                        SkillVo(
                            id = skillEntity.id,
                            name = skillEntity.name,
                            desc = stringBuilder,
                            icon = skillEntity.icon
                        )
                    )
                }
                skills
            }
            skillListFlow.emit(skillList.toMutableList())
        }
    }
}