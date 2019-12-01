package com.erookies.add.ui.viemodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erookies.add.bean.AddEntry
import com.erookies.add.network.Api
import com.erookies.add.string2Int
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator

/**
 * Create by Cchanges.
 * Time: 2019-12-01
 */
class AddEntryViewModel(private val kind: String, private val own: Boolean) : BaseViewModel() {

    var list = MutableLiveData<List<AddEntry>>()
    var status = MutableLiveData<Int>()

    fun getData() {
        ApiGenerator.getApiService(Api::class.java)
            .getData(string2Int(kind),if (own) BaseApp.user?.sno ?: "0" else "0")
            .setSchedulers()
            .safeSubscribeBy {
                status.value = it.code
                if (it.code == 0) {
                    list.value = it.data
                }
            }.lifeCycle()
    }

    class Factory(private val kind: String, private val isOwn: Boolean) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AddEntryViewModel::class.java)) {
                return AddEntryViewModel(kind, isOwn) as T
            } else {
                throw RuntimeException("view model not found.")
            }
        }
    }
}