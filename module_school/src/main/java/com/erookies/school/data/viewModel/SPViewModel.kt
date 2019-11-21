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
                needToast.value = true
                error = "没有相关数据"
            }
            isRefresh.value = false
        },{
            needToast.value = true
            error = "建立连接失败"
            Log.d("SPViewModel",it)
        })
    }
}