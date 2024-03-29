package com.nl.module.store.recruit

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.view.View
import com.nl.component.NLBaseFragment
import com.nl.component.ext.click
import com.nl.module.store.databinding.FragmentRecruitNormalBinding

class RecruitNormalFragment : NLBaseFragment<FragmentRecruitNormalBinding>() {

    override fun initView() {
        mBinding.btRecruitOnce.click {
            startActivity(
                Intent(
                    requireActivity(),
                    RecruitResultActivity::class.java
                )
            )
        }
        mBinding.btRecruitTen.click { shakeAnimator() }
    }


    private fun shakeAnimator() {
        val offsetX = (mBinding.ivAvatar.width shr 2).toFloat()
        val offsetY = -(mBinding.ivAvatar.height shr 2).toFloat()
        val halfOffsetX = offsetX / 2F
        val halfOffsetY = offsetY / 2F

        val translationX =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 0F, offsetX, -halfOffsetX, 0F)
        val translationY =
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0F, offsetY, halfOffsetY, 0F)
        val translationZ = PropertyValuesHolder.ofFloat(View.TRANSLATION_Z, 0F, 1F, 1F, 0F)
        val rotation = PropertyValuesHolder.ofFloat(View.ROTATION, 0F, 20F, -5F, 0F)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            mBinding.ivAvatar,
            translationX,
            translationY,
            translationZ,
            rotation
        )
        animator.duration = 800
        animator.start()

//        val rotation = RotateAnimation(
//            0F,
//            45F,
//            Animation.RELATIVE_TO_SELF,
//            1F,
//            Animation.RELATIVE_TO_SELF,
//            1F
//        )
//        rotation.duration = 1000
//        ivAvatar.startAnimation(rotation)

    }

    companion object {
        fun newInstance(): RecruitNormalFragment {
            return RecruitNormalFragment()
        }
    }
}