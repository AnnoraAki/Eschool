package com.erookies.add.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.add.network.Api
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator

class AddGroupViewModel : BaseViewModel() {
    var statusCode = MutableLiveData<Int>()

    fun addGroup(sno: String, id: Int) {
        if (sno.isEmpty()) {
            statusCode.value = 3
            return
        }
        ApiGenerator.getApiService(Api::class.java)
            .addGroup(sno, id)
            .setSchedulers()
            .safeSubscribeBy {
                statusCode.value = it.code
            }.lifeCycle()

    }
}