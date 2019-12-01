package com.erookies.add.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.add.network.Api
import com.erookies.add.string2Int
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator

/**
 * Create by Cchanges.
 * Time: 2019-11-03
 */
class AddViewModel : BaseViewModel() {
    val statusData = MutableLiveData<Int>()

    fun check(type: String, address: String, description : String, peopleNum: Int, time: String) {
        val user = BaseApp.user
        val sno = user?.sno ?: return
        if (type.isBlank()|| address.isBlank()|| peopleNum == 0 || time.isBlank() || description.isBlank()) {
            statusData.value = MISS_INFORMATION
        } else {
            ApiGenerator.getApiService(Api::class.java)
                .uploadData(string2Int(type),sno,time,address,peopleNum,description)
                .setSchedulers()
                .safeSubscribeBy {
                    statusData.value = it.code
                }.lifeCycle()
        }
    }

    companion object {
        const val MISS_INFORMATION = 2
        const val SUCCEED = 0
        const val FAILED = 1
    }
}