package com.erookies.main.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.MAIN_LOGIN
import com.erookies.main.R
import com.erookies.main.viewmodel.*
import kotlinx.android.synthetic.main.main_activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

@Route(path = MAIN_LOGIN)
class LoginActivity : BaseActivity() {

    private val viewModel : LoginViewModel by lazy (LazyThreadSafetyMode.NONE) { getViewModel(LoginViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_login)

        common_toolbar.init("登陆")

        viewModel.statusEvent.observe {
            when(it) {
                EMPTY_PWD -> toast("输入的密码为空哦～")
                EMPTY_SNO -> toast("输入的学号为空哦～")
                GO_REGISTER ->  {
                    toast("你没有注册呢～现前往注册页面注册账号")
                    startActivity<RegisterActivity>()
                    finish()
                }
                GO_LOGIN -> viewModel.login(til_stu_num.text.toString(),til_pwd.text.toString())
                LOGIN_SUCCEED -> {
                    toast("欢迎登陆")
                    finish()
                }
                ERROR_PWD -> toast("密码输入错误，请重试哟")
                ERROR_EXIST -> toast("该用户不存在...")
            }
        }

        btn_login.setOnClickListener {
            viewModel.verify(til_stu_num.text.toString())
        }
    }
}
