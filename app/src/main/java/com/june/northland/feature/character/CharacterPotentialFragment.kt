package com.june.northland.feature.character

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatTextView
import com.june.northland.R
import com.june.northland.base.component.BaseDialogFragment
import com.june.northland.base.dialog.ChoiceDialog
import com.june.northland.base.ext.click
import kotlinx.android.synthetic.main.fragment_character_potential.*
import kotlin.math.abs

class CharacterPotentialFragment : BaseDialogFragment(), View.OnClickListener {

    private var mPotential = 1000
    private var mSelectedType = 0 // 0-attack 1-defense 2-health
    private var mSelectedView: AppCompatTextView? = null

    override fun getLayoutResId(): Int = R.layout.fragment_character_potential

    override fun initView() {
        tvAttackTitle.click {
            if (mSelectedType == 0) {
                return@click
            }
            mSelectedType = 0
            vAttackSelected.visibility = View.VISIBLE
            vDefenseSelected.visibility = View.INVISIBLE
            vHealthSelected.visibility = View.INVISIBLE
            mSelectedView = tvAttackChange
        }
        tvDefenseTitle.click {
            if (mSelectedType == 1) {
                return@click
            }
            mSelectedType = 1
            vAttackSelected.visibility = View.INVISIBLE
            vDefenseSelected.visibility = View.VISIBLE
            vHealthSelected.visibility = View.INVISIBLE
            mSelectedView = tvDefenseChange
        }
        tvHealthTitle.click {
            if (mSelectedType == 2) {
                return@click
            }
            mSelectedType = 2
            vAttackSelected.visibility = View.INVISIBLE
            vDefenseSelected.visibility = View.INVISIBLE
            vHealthSelected.visibility = View.VISIBLE
            mSelectedView = tvHealthChange
        }

        tvAddHundred.setOnClickListener(this)
        tvSubHundred.setOnClickListener(this)
        tvAddTen.setOnClickListener(this)
        tvSubTen.setOnClickListener(this)
        tvAddOne.setOnClickListener(this)
        tvSubOne.setOnClickListener(this)

        tvSure.click {
            val choiceDialog = ChoiceDialog(requireActivity())
            choiceDialog.setChoiceTitle("提示")
            choiceDialog.setChoiceContent("当前花费1000潜力点，确定继续?")
            choiceDialog.setChoiceSureListener(DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
                requestPotential()
            })
            choiceDialog.show()
        }
        tvCancel.click { dismiss() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvPotentialTitle.text = "当前潜力点："
        tvPotential.text = mPotential.toString()

        tvAttack.text = "500"
        tvDefense.text = "300"
        tvHealth.text = "800"

        tvAttackChange.tag = 0
        tvDefenseChange.tag = 0
        tvHealthChange.tag = 0

        mSelectedView = tvAttackChange
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
        tvPotential.text = mPotential.toString()

        val resultPoint = (mSelectedView?.tag ?: 0) as Int
        mSelectedView?.visibility = if (resultPoint > 0) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun requestPotential() {
        showLoading()
        tvAttackTitle.postDelayed({
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