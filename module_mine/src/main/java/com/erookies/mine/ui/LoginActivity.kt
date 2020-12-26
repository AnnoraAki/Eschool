package com.erookies.mine.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.FIRST_IN
import com.erookies.lib_common.config.MINE_LOGIN
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.lib_common.event.LoginEvent
import com.erookies.lib_common.extentions.defaultSharedPreferences
import com.erookies.lib_common.extentions.editor
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.extentions.visible
import com.erookies.mine.R
import com.erookies.mine.utils.DialogBuilder
import com.erookies.mine.utils.DialogHelper
import com.erookies.mine.viewmodel.LoginViewModel
import com.erookies.mine.viewmodel.LoginViewModel.Companion.EMPTY_PWD
import com.erookies.mine.viewmodel.LoginViewModel.Companion.EMPTY_SNO
import com.erookies.mine.viewmodel.LoginViewModel.Companion.ERROR_EXIST
import com.erookies.mine.viewmodel.LoginViewModel.Companion.ERROR_PWD
import com.erookies.mine.viewmodel.LoginViewModel.Companion.GO_LOGIN
import com.erookies.mine.viewmodel.LoginViewModel.Companion.GO_REGISTER
import com.erookies.mine.viewmodel.LoginViewModel.Companion.LOGIN_SUCCEED
import com.erookies.mine.viewmodel.LosePwdViewModel
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.CHANGE_ERROR
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.CHANGE_SUCCEED
import kotlinx.android.synthetic.main.mine_activity_login.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.startActivity

@Route(path = MINE_LOGIN)
class LoginActivity : BaseActivity() {

    private val loginViewModel: LoginViewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(LoginViewModel::class.java) }
    private val changePwdViewModel: LosePwdViewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(LosePwdViewModel::class.java) }


    private val isFirstIn by lazy(LazyThreadSafetyMode.NONE) {
        defaultSharedPreferences.getBoolean(
            FIRST_IN,
            true
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_login)

        common_toolbar.init("登陆")

        if (isFirstIn) btn_skip_login.visible()

        changeStatus()

        loginViewModel.statusEvent.observe {
            when (it) {
                EMPTY_PWD -> toast("输入的密码为空哦～")
                EMPTY_SNO -> toast("输入的学号为空哦～")
                GO_REGISTER -> {
                    toast("你没有注册呢～现前往注册页面注册账号")
                    startActivity<RegisterActivity>()
                }
                GO_LOGIN -> loginViewModel.login(
                    til_stu_num.text.toString(),
                    til_pwd.text.toString()
                )
                LOGIN_SUCCEED -> {
                    toast("欢迎登陆")
                    EventBus.getDefault().post(IMEvent(type = IMEventType.LOGIN))
                    EventBus.getDefault().post(LoginEvent(true))
                    finish()
                }
                ERROR_PWD -> toast("密码输入错误，请重试哟")
                ERROR_EXIST -> toast("该用户不存在...")
            }
        }

        changePwdViewModel.changePwdStatusEvent.observe {
            when(it) {
                CHANGE_SUCCEED -> {
                    toast("修改密码成功")
                    EventBus.getDefault().post(IMEvent(IMEventType.UPDATE_PWD,newPwd = BaseApp.user?.pwd ?: ""))
                }
                CHANGE_ERROR -> toast("修改密码失败")
            }
        }

        btn_login.setOnClickListener {
            loginViewModel.verify(til_stu_num.text.toString())
        }

        btn_skip_login.setOnClickListener {
            finish()
        }

        tv_register.setOnClickListener {
            startActivity<RegisterActivity>()
        }

        tv_forget.setOnClickListener {
            startActivity<LosePwdActivity>()
        }
    }

    private fun changeStatus() {
        if (isFirstIn) {
            defaultSharedPreferences.editor {
                putBoolean(FIRST_IN, false)
            }
        }
    }
}
