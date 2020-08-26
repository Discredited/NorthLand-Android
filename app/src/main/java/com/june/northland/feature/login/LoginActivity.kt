package com.june.northland.feature.login

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.utils.Toast
import com.june.northland.utils.cache.UserDataCache
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun initView() {
        btLogin.click {
            val account = etAccount.text.toString()
            if (account.isEmpty()) {
                Toast.toastShort(getString(R.string.prompt_input_account))
                return@click
            }
            val password = etPassword.text.toString()
            if (password.isEmpty()) {
                Toast.toastShort(getString(R.string.prompt_input_password))
                return@click
            }

            UserDataCache.getInstance().saveToken("1111")
            UserDataCache.getInstance().saveUserId("1111")
            UserDataCache.getInstance().saveUserName(account)

            val intent = Intent()
            intent.putExtra(RESPONSE_ID, "")
            intent.putExtra(RESPONSE_NAME, account)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun loadData() {
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