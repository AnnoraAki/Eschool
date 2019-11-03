package com.erookies.add.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.base.BaseViewModel

/**
 * Create by Cchanges.
 * Time: 2019-11-03
 */
class AddViewModel : BaseViewModel() {
    val statusData = MutableLiveData<String>()

    fun check(type: String, address: String, peopleNum: Int, time: String) {
        if (type == "" || address == "" || peopleNum == 0 || time == "") {
            statusData.value = "请确认是否填写完拼单信息哦～"
        } else {
            //do network
        }
    }
}