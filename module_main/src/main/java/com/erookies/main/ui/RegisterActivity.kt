package com.erookies.main.ui

import android.os.Bundle
import com.erookies.lib_common.base.BaseActivity
import com.erookies.main.R

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_register)

        common_toolbar.init("注册")
    }
}
