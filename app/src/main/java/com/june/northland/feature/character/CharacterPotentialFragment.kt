package com.june.northland.feature.character

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.dialog.ChoiceDialog
import com.june.northland.base.ext.click
import com.june.northland.databinding.FragmentCharacterPotentialBinding
import kotlin.math.abs

class CharacterPotentialFragment : BaseDialogFragment<FragmentCharacterPotentialBinding>(),
    View.OnClickListener {

    private var mPotential = 1000
    private var mSelectedType = 0 // 0-attack 1-defense 2-health
    private var mSelectedView: AppCompatTextView? = null

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCharacterPotentialBinding {
        return FragmentCharacterPotentialBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        mBinding.tvAttackTitle.click {
            if (mSelectedType == 0) {
                return@click
            }
            mSelectedType = 0
            mBinding.vAttackSelected.visibility = View.VISIBLE
            mBinding.vDefenseSelected.visibility = View.INVISIBLE
            mBinding.vHealthSelected.visibility = View.INVISIBLE
            mSelectedView = mBinding.tvAttackChange
        }
        mBinding.tvDefenseTitle.click {
            if (mSelectedType == 1) {
                return@click
            }
            mSelectedType = 1
            mBinding.vAttackSelected.visibility = View.INVISIBLE
            mBinding.vDefenseSelected.visibility = View.VISIBLE
            mBinding.vHealthSelected.visibility = View.INVISIBLE
            mSelectedView = mBinding.tvDefenseChange
        }
        mBinding.tvHealthTitle.click {
            if (mSelectedType == 2) {
                return@click
            }
            mSelectedType = 2
            mBinding.vAttackSelected.visibility = View.INVISIBLE
            mBinding.vDefenseSelected.visibility = View.INVISIBLE
            mBinding.vHealthSelected.visibility = View.VISIBLE
            mSelectedView = mBinding.tvHealthChange
        }

        mBinding.tvAddHundred.setOnClickListener(this)
        mBinding.tvSubHundred.setOnClickListener(this)
        mBinding.tvAddTen.setOnClickListener(this)
        mBinding.tvSubTen.setOnClickListener(this)
        mBinding.tvAddOne.setOnClickListener(this)
        mBinding.tvSubOne.setOnClickListener(this)

        mBinding.tvSure.click {
            val choiceDialog = ChoiceDialog(requireActivity())
            choiceDialog.setChoiceTitle("提示")
            choiceDialog.setChoiceContent("当前花费1000潜力点，确定继续?")
            choiceDialog.setChoiceSureListener(DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
                requestPotential()
            })
            choiceDialog.show()
        }
        mBinding.tvCancel.click { dismiss() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.tvPotentialTitle.text = "当前潜力点："
        mBinding.tvPotential.text = mPotential.toString()

        mBinding.tvAttack.text = "500"
        mBinding.tvDefense.text = "300"
        mBinding.tvHealth.text = "800"

        mBinding.tvAttackChange.tag = 0
        mBinding.tvDefenseChange.tag = 0
        mBinding.tvHealthChange.tag = 0

        mSelectedView = mBinding.tvAttackChange
    }

    override fun onClick(v: View) {
        val calculation = when (v.id) {
            R.id.tvAddHundred -> +100
            R.id.tvSubHundred -> -100
            R.id.tvAddTen -> +10
            R.id.tvSubTen -> -10
            R.id.tvAddOne -> +1
            R.id.tvSubOne -> -1
            else -> 0
        }

        val point = (mSelectedView?.tag ?: 0) as Int

        if (calculation > 0) {
            //增加
            var addCalculation = if (mPotential > calculation) {
                calculation
            } else {
                mPotential
            }
            val result = point + addCalculation
            mPotential -= addCalculation
            mSelectedView?.tag = result
            mSelectedView?.text = result.toString()
        } else {
            //减少
            var subCalculation = if (point > abs(calculation)) {
                calculation
            } else {
                -point
            }
            val result = point + subCalculation
            mPotential -= subCalculation
            mSelectedView?.tag = result
            mSelectedView?.text = result.toString()
        }
        mBinding.tvPotential.text = mPotential.toString()

        val resultPoint = (mSelectedView?.tag ?: 0) as Int
        mSelectedView?.visibility = if (resultPoint > 0) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun requestPotential() {
        showLoading()
        mBinding.tvAttackTitle.postDelayed({
            hideLoading()
            dismiss()
        }, 1000)
    }

    override fun layoutParamsWidth(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutParamsHeight(): Int = WindowManager.LayoutParams.WRAP_CONTENT

    override fun layoutGravity(): Int = Gravity.CENTER

    companion object {
        fun newInstance(): CharacterPotentialFragment {
            return CharacterPotentialFragment()
        }
    }
}