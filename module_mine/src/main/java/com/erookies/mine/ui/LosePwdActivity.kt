package com.erookies.mine.ui

import android.os.Bundle
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.lib_common.extentions.toast
import com.erookies.mine.R
import com.erookies.mine.viewmodel.LosePwdViewModel
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.CHANGE_ERROR
import com.erookies.mine.viewmodel.LosePwdViewModel.Companion.CHANGE_SUCCEED
import kotlinx.android.synthetic.main.mine_activity_lose_pwd.*
import org.greenrobot.eventbus.EventBus

class LosePwdActivity : BaseActivity() {

    private val viewModel: LosePwdViewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(LosePwdViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_lose_pwd)

        viewModel.changePwdStatusEvent.observe {
            when(it) {
                CHANGE_SUCCEED -> {
                    toast("修改密码成功")
                    EventBus.getDefault().post(IMEvent(IMEventType.UPDATE_PWD,newPwd = BaseApp.user?.pwd ?: ""))
                }
                CHANGE_ERROR -> toast("修改密码失败")
            }
        }

        btn_lose_sure.setOnClickListener {
            val sno = tip_lost_sno.text.toString()
            val pwd = tip_lose_pwd.text.toString()
            if (sno.isBlank()) {
                toast("学号为空哦~")
                return@setOnClickListener
            }
            if (pwd.isBlank()) {
                toast("密码为空哦～")
                return@setOnClickListener
            }
            viewModel.changePwd(str = pwd, sno = sno)
        }
    }
}
