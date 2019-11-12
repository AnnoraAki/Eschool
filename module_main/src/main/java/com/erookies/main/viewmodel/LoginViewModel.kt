package com.erookies.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.lib_common.utils.LogUtils
import com.erookies.main.bean.LoginBean
import com.erookies.main.bean.SnoBean
import com.erookies.main.network.Api

/**
 * Create by Cchanges.
 * Time: 2019-11-11
 */
const val EMPTY_SNO = 1
const val EMPTY_PWD = 2
const val GO_REGISTER = 3
const val GO_LOGIN = 4
const val LOGIN_SUCCEED = 5
const val ERROR_PWD = 6
const val ERROR_EXIST = 7

class LoginViewModel : BaseViewModel() {
    val statusEvent = MutableLiveData<Int>()

    fun verify(sno: String) {
        if (sno.trim().isEmpty()) {
            statusEvent.value = EMPTY_SNO
            return
        }

        ApiGenerator.getApiService(Api::class.java).verify(SnoBean(sno.trim()))
            .setSchedulers()
            .safeSubscribeBy {
                statusEvent.value = if (it.code == 0) GO_LOGIN else GO_REGISTER
            }.lifeCycle()
    }

    fun login(sno: String, pwd: String) {
        if (sno.trim().isEmpty()) {
            statusEvent.value = EMPTY_SNO
            return
        }
        if (pwd.trim().isEmpty()) {
            statusEvent.value = EMPTY_PWD
            return
        }

        ApiGenerator.getApiService(Api::class.java).login(LoginBean(sno, pwd))
            .setSchedulers()
            .safeSubscribeBy {
                statusEvent.value = when(it.code) {
                    0 -> {
                        BaseApp.user = it.data
                        LOGIN_SUCCEED
                    }
                    1 -> ERROR_PWD
                    else -> ERROR_EXIST
                }
            }.lifeCycle()
    }

}