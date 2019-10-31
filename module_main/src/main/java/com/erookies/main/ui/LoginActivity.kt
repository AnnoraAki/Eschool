package com.erookies.main.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.MAIN_LOGIN
import com.erookies.main.R
import kotlinx.android.synthetic.main.main_activity_login.*
import org.jetbrains.anko.startActivity

@Route(path = MAIN_LOGIN)
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_login)

        common_toolbar.init("登陆")

    }
}
