package com.erookies.mine.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.MAIN_LOGIN
import com.erookies.mine.R
import com.erookies.mine.utils.DialogBuilder
import com.erookies.mine.utils.DialogHelper
import kotlinx.android.synthetic.main.mine_activity_authentication.*

class AuthenticationActivity : BaseActivity() {

    private val user = BaseApp.user

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_authentication)
        common_toolbar.init("我的验证资料")
        if (user == null) {
            toLogin()
        } else {
            tv_stu_name.text = "姓名：${user.username}"
            tv_college.text = "学院：${user.institute}"
            tv_stu_num.text = "学号：${user.sno}"
        }

        btn_add_auth.setOnClickListener {
            ARouter.getInstance().build(MAIN_LOGIN).navigation()
            finish()
        }
    }

    private fun toLogin() {
        val builder = DialogBuilder().apply {
            title = "亲现在还没有登陆哦～"
            hint = "点击去登陆，体验更多功能"
            todoEvent = {
                ARouter.getInstance().build(MAIN_LOGIN).navigation()
                finish()
            }
        }
        DialogHelper.toastDialog(this@AuthenticationActivity, builder)
    }
}
