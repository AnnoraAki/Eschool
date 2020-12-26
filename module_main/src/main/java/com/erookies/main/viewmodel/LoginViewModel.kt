package com.erookies.main.viewmodel

import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.lib_common.utils.LogUtils
import com.erookies.main.bean.LoginBean
import com.erookies.main.network.Api
import org.greenrobot.eventbus.EventBus

/**
 * Create by Cchanges.
 * Time: 2019-12-02
 */
class LoginViewModel : BaseViewModel() {

    fun login(sno: String, pwd: String) {
        LogUtils.e("sno:$sno,pwd:$pwd")
        if (sno.trim().isEmpty()) {
            return
        }
        if (pwd.trim().isEmpty()) {
            return
        }
        ApiGenerator.getApiService(Api::class.java)
            .login(LoginBean(sno, pwd))
            .setSchedulers()
            .safeSubscribeBy {
                when (it.code) {
                    0 -> {
                        BaseApp.user = it.data
                    }
                }
            }.lifeCycle()

        EventBus.getDefault().post(
            IMEvent(type = IMEventType.LOGIN)
        )
    }
}