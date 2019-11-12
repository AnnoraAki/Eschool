package com.erookies.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.main.bean.RegisterBean
import com.erookies.main.network.Api

/**
 * Create by Cchanges.
 * Time: 2019-11-12
 */

const val REGISTER_SUCCEED = 1
const val REGISTER_FAILED = 2

class RegisterViewModel : BaseViewModel() {
    val statusEvent = MutableLiveData<Int>()

    fun register(r:RegisterBean) {
        ApiGenerator.getApiService(Api::class.java)
            .register(r)
            .setSchedulers()
            .safeSubscribeBy {
                statusEvent.value = if (it.code == 0) REGISTER_SUCCEED else REGISTER_FAILED
            }.lifeCycle()
    }
}