package com.erookies.mine.ui

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.MAIN_LOGIN
import com.erookies.lib_common.event.LoginEvent
import com.erookies.lib_common.extentions.toast
import com.erookies.mine.R
import com.erookies.mine.utils.DialogBuilder
import com.erookies.mine.utils.DialogHelper
import kotlinx.android.synthetic.main.mine_activity_setting.*
import org.greenrobot.eventbus.EventBus

class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_setting)

        common_toolbar.init("设置")

        tv_mine_change_pwd.setOnClickListener {
            val builder = DialogBuilder().apply {
                title = "修改密码"
                hint = "输入新的密码哦～"
                isPwd = true
                checkEvent = { it.trim().length > 6 }
                todoEvent = { toast("changed") }
                falseEvent = { toast("密码长度大于6哦～") }
            }
            DialogHelper.editDialog(this, builder)
        }


        tv_mine_login_exit.apply {
            text = if (BaseApp.isLogin) "退出登陆" else "登陆"
            setOnClickListener {
                if (!BaseApp.isLogin) {
                    ARouter.getInstance().build(MAIN_LOGIN).navigation()
                    finish()
                } else {
                    val builder = DialogBuilder().apply {
                        title = "退出登录"
                        hint = "确定退出吗？"
                        checkEvent = { true }
                        todoEvent = {
                            EventBus.getDefault().post(LoginEvent(false))
                            finish()
                        }
                    }
                    DialogHelper.toastDialog(this@SettingActivity, builder)
                }

            }
        }
    }
}
