package com.erookies.mine.ui

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.MINE_LOGIN
import com.erookies.lib_common.event.LoginEvent
import com.erookies.lib_common.extentions.toast
import com.erookies.mine.R
import com.erookies.mine.utils.DialogBuilder
import com.erookies.mine.utils.DialogHelper
import com.erookies.mine.viewmodel.LosePwdViewModel
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.CHANGE_ERROR
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.CHANGE_SUCCEED
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.NOT_LOGIN
import kotlinx.android.synthetic.main.mine_activity_setting.*
import org.greenrobot.eventbus.EventBus

class SettingActivity : BaseActivity() {

    private val changePwdViewModel: LosePwdViewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(LosePwdViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_setting)

        common_toolbar.init("设置")

        changePwdViewModel.changePwdStatusEvent.observe {
            when (it) {
                CHANGE_SUCCEED -> toast("修改密码成功")
                CHANGE_ERROR -> toast("修改密码失败")
                NOT_LOGIN -> toast("未登录不能使用该功能哦")
            }
        }

        tv_mine_change_pwd.setOnClickListener {
            val builder = DialogBuilder().apply {
                title = "修改密码"
                hint = "输入新的密码哦～"
                isPwd = true
                checkEvent = { it.trim().length > 6 }
                todoEvent = { changePwdViewModel.changePwd(it) }
                falseEvent = { toast("密码长度大于6哦～") }
            }
            DialogHelper.editDialog(this, builder)
        }


        tv_mine_login_exit.apply {
            text = if (BaseApp.isLogin) "退出登陆" else "登陆"
            setOnClickListener {
                if (!BaseApp.isLogin) {
                    ARouter.getInstance().build(MINE_LOGIN).navigation()
                    finish()
                } else {
                    val builder = DialogBuilder().apply {
                        title = "退出登录"
                        hint = "确定退出吗？"
                        checkEvent = { true }
                        todoEvent = {
                            EventBus.getDefault().post(LoginEvent(false))
                            BaseApp.user = null
                            finish()
                        }
                    }
                    DialogHelper.toastDialog(this@SettingActivity, builder)
                }
            }
        }
    }
}
