package com.june.northland.feature.login

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import com.june.base.basic.ext.click
import com.june.northland.R
import com.june.northland.databinding.ActivityLoginBinding
import com.june.northland.utils.Toast
import com.june.northland.utils.cache.UserDataCache
import com.nl.component.NLBaseActivity

class LoginActivity : NLBaseActivity<ActivityLoginBinding>() {

    override fun initView() {
        mBinding.btLogin.click {
            val account = mBinding.etAccount.text.toString()
            if (account.isEmpty()) {
                Toast.toastShort(getString(R.string.prompt_input_account))
                return@click
            }
            val password = mBinding.etPassword.text.toString()
            if (password.isEmpty()) {
                Toast.toastShort(getString(R.string.prompt_input_password))
                return@click
            }
            requestLogin(account, password)
        }
    }

    override fun loadData() {
    }

    private fun requestLogin(account: String, password: String) {
        showLoading(isAllowDismiss = false)

        mBinding.btLogin.postDelayed({
            hideLoading()

            UserDataCache.getInstance().saveToken("1111")
            UserDataCache.getInstance().saveUserId("1111")
            UserDataCache.getInstance().saveUserName(account)

            val intent = Intent()
            intent.putExtra(RESPONSE_ID, "")
            intent.putExtra(RESPONSE_NAME, account)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }, 1200)
    }

    companion object {
        const val REQUEST_LOGIN = 100
        const val RESPONSE_ID = "RESPONSE_ID"
        const val RESPONSE_NAME = "RESPONSE_NAME"

        fun starter(fragment: Fragment) {
            val intent = Intent(fragment.requireActivity(), LoginActivity::class.java)
            fragment.startActivityForResult(intent, REQUEST_LOGIN)
        }
    }
}