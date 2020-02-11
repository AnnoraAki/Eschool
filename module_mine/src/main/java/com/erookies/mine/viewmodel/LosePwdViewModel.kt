package com.erookies.mine.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.mine.bean.ChangeBody
import com.erookies.mine.network.Api

/**
 * Create by Cchanges.
 * Time: 2019-11-14
 */

class LosePwdViewModel : BaseViewModel() {
    val changePwdStatusEvent = MutableLiveData<Int>()

    fun changePwd(str: String, sno: String = "") {
        val user = BaseApp.user
        if (user == null) changePwdStatusEvent.value = NOT_LOGIN
        else {
            ApiGenerator.getApiService(Api::class.java)
                .changePwd(ChangeBody(if (sno.isBlank()) user.stuNum else sno, str))
                .setSchedulers()
                .safeSubscribeBy {
                    changePwdStatusEvent.value = if (it.code == 0) {
                        BaseApp.user?.pwd = str
                        CHANGE_SUCCEED
                    } else CHANGE_ERROR
                }.lifeCycle()
        }

    }

    companion object {
        const val CHANGE_SUCCEED = 1
        const val CHANGE_ERROR = 2
        const val NOT_LOGIN = 3
    }
}