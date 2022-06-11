package com.nl.module.store.recruit

import com.blankj.utilcode.util.GsonUtils
import com.june.network.api.ApiResponse
import com.nl.lib.element.effect.PlayerEffectEntity
import com.nl.lib.element.enum.CommonEnum
import com.nl.lib.element.role.PlayerRoleEntity
import com.nl.lib.element.skill.PlayerRoleSkillEntity
import com.nl.lib.element.skill.SkillEnum
import com.nl.room.RoomHelper
import timber.log.Timber

/**
 * 招募数据仓库
 *
 * 2022/6/10
 * @author June
 */
class RecruitRepository {

    private val roleDao by lazy { RoomHelper.getInstance().database().roleDao() }
    private val playerRoleDao by lazy { RoomHelper.getInstance().database().playerRoleDao() }

    private val skillDao by lazy { RoomHelper.getInstance().database().skillDao() }
    private val playerRoleSkillDao by lazy { RoomHelper.getInstance().database().playerRoleSkillDao() }

    private val effectDao by lazy { RoomHelper.getInstance().database().effectDao() }
    private val playerEffectDao by lazy { RoomHelper.getInstance().database().playerEffectDao() }

    suspend fun recruitRole(playerId: String): ApiResponse<PlayerRoleEntity> {
        // 首先从角色库中查找对应的角色列表
        val roleList = roleDao.loadRoles()
        // 从角色列表中随机抽出一个角色
        val random = ((roleList.size - 1) * Math.random()).toInt()
        val recruitRole = roleList[random]
        Timber.i("recruit 招募到的角色:${GsonUtils.toJson(recruitRole)}")
        // 根据招募角色的技能属性生成对应的玩家角色属性
        val playerRoleId = playerRoleDao.randomIdByDao { randomId ->
            null != playerRoleDao.findPlayerRoleById(randomId)
        }
        Timber.i("recruit 生成的角色ID:${playerRoleId}")

        val playerRolePassiveSkillId = playerRoleSkillDao.randomIdByDao { randomId ->
            null != playerRoleSkillDao.findPlayerRoleSkillById(randomId)
        }
        Timber.i("recruit 生成的被动技能ID:${playerRolePassiveSkillId}")

        val playerRoleInitiativeSkillId = playerRoleSkillDao.randomIdByDao { randomId ->
            null != playerRoleSkillDao.findPlayerRoleSkillById(randomId)
        }
        Timber.i("recruit 生成的主动技能ID:${playerRoleInitiativeSkillId}")

        // 根据招募角色的技能生成对应的玩家技能
        val skillList = skillDao.findSkillByRoleId(roleId = recruitRole.id)
        skillList?.forEach { skill ->
            val skillId = when (skill.type) {
                SkillEnum.TYPE_PASSIVE -> playerRolePassiveSkillId
                SkillEnum.TYPE_INITIATIVE -> playerRoleInitiativeSkillId
                else -> throw Exception("技能类型错误")
            }

            playerRoleSkillDao.insertEntity(
                PlayerRoleSkillEntity(
                    id = skillId,
                    skillId = skill.id,
                    playerRoleId = playerRoleId,
                    level = 1,
                    triggerProbability = 0F
                )
            )
            Timber.i("recruit 技能已插入数据库:${skillId} ${skill.name}")

            val effectList = effectDao.findEffectByRelation(skill.id, CommonEnum.OBJECT_SKILL)
            effectList?.forEach { effect ->
                val playerEffectId = playerEffectDao.randomIdByDao { randomId ->
                    null != playerEffectDao.findPlayerEffectById(randomId)
                }
                Timber.i("recruit 生成的属性ID:${playerEffectId}")

                playerEffectDao.insertEntity(
                    PlayerEffectEntity(
                        id = playerEffectId,
                        effectId = effect.id,
                        relationType = CommonEnum.OBJECT_SKILL,
                        relationId = effect.relationName,
                        relationName = skill.name,
                        isActive = false,
                        percentage = effect.percentage,
                        value = effect.value,
                        triggerProbability = effect.triggerProbability
                    )
                )
                Timber.i("recruit 属性已插入数据库:${playerEffectId} ${effect.desc}")
            }
        }

        // 生成对应的招募角色
        val playerRole = PlayerRoleEntity(
            id = playerRoleId,
            playerId = playerId,
            roleId = recruitRole.id,
            name = recruitRole.name,
            nick = "",
            avatar = recruitRole.avatar,
            image = recruitRole.image,
            level = 0,
            experience = 0L,
            expNextLevel = recruitRole.expNextLevel,
            attack = recruitRole.attackInit,
            defense = recruitRole.defenseInit,
            health = recruitRole.healthInit,
            speed = recruitRole.speedInit,
            potential = recruitRole.potential,
            critical = recruitRole.critInit,
            resist = recruitRole.resistInit,
            hit = recruitRole.hitInit,
            dodge = recruitRole.dodgeInit,
            skillPassive = playerRolePassiveSkillId,
            skillInitiative = playerRoleInitiativeSkillId,
        )
        playerRoleDao.insertEntity(playerRole)
        Timber.i("recruit 角色已插入数据库:${playerRoleId} ${recruitRole.name}")

        return ApiResponse.Success(playerRole)
    }
}