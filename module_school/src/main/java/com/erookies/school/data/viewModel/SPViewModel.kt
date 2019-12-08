package com.erookies.school.data.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.repository.SearchPeopleRepository

class SPViewModel(private val repository: SearchPeopleRepository) :  BaseViewModel() {
    var currentUser = MutableLiveData<User>()

    var items = MutableLiveData<MutableList<ItemData>>()
    var startType = START_FROM_MAIN

    var isRefresh = MutableLiveData<Boolean>()
    var needToast = MutableLiveData<Boolean>()
    var error:String = ""

    init {
        items.value = mutableListOf()
        needToast.value = false
        isRefresh.value = false
        currentUser.value = User()
    }

    fun getItemDataListFromNetWork(){
        isRefresh.value = true
        needToast.value = false
        error = ""

        Log.d("SPViewModel",items.value.toString())

        items.value?.clear()
        repository.loadItemList(startType, {list ->
            items.value?.addAll(list)
            if (items.value.isNullOrEmpty()){
                error = "没有相关数据"
                needToast.value = true
            }
            isRefresh.value = false
        },{
            isRefresh.value = false
            error = "建立连接失败"
            needToast.value = true
            Log.d("SPViewModel",it)
        })
    }
}