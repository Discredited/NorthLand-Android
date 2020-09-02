package com.june.northland.feature.battle

import android.view.animation.Interpolator
import timber.log.Timber

class BattleSkillInterpolator : Interpolator {

    override fun getInterpolation(input: Float): Float {
        //0.4F之前超速
        //0.4F-0.6F缓慢
        //0.6F之后加速
        val result = when {
            input <= 0.2F -> {
                input * 2.5F
            }
            input >= 0.8F -> {
                input * 2.5F - 1.5F
            }
            else -> {
                0.5F
            }
        }

        Timber.e("input:$result")
        return result
    }
}