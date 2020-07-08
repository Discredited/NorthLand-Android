package com.june.northland.feature.login

import android.content.Intent
import com.june.northland.R
import com.june.northland.base.component.BaseActivity
import com.june.northland.base.ext.click
import com.june.northland.feature.main.MainActivity
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

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun loadData() {
    }
}