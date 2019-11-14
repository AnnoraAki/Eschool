package com.erookies.mine.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator

/**
 * Create by Cchanges.
 * Time: 2019-11-12
 */


class RegisterViewModel : BaseViewModel() {
    val statusEvent = MutableLiveData<Int>()

    fun register(r: com.erookies.mine.bean.RegisterBean) {
        ApiGenerator.getApiService(com.erookies.mine.network.Api::class.java)
            .register(r)
            .setSchedulers()
            .safeSubscribeBy {
                statusEvent.value = if (it.code == 0) REGISTER_SUCCEED else REGISTER_FAILED
            }.lifeCycle()
    }

    companion object {
        const val REGISTER_SUCCEED = 1
        const val REGISTER_FAILED = 2
    }
}