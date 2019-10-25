package com.erookies.school.data.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erookies.lib_common.User
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.school.data.model.SearchPeopleItemData
import com.erookies.school.data.repository.SearchPeopleRepository
import java.util.*

class SPViewModel(private val repository: SearchPeopleRepository) :  BaseViewModel() {
    var userMutableList = MutableLiveData<MutableList<User>>()
    var currentUser = MutableLiveData<User>()
    var items = mutableListOf<MutableLiveData<SearchPeopleItemData>>()
    var isRefresh = MutableLiveData<Boolean>()

    init {
        isRefresh.value = false
        currentUser.value = User()
        userMutableList.value = mutableListOf()
    }

    fun createTestData(name:String,content:String){
        isRefresh.value = true
        val user = User(username = name)
        val spid = SearchPeopleItemData(user,content)
        val data = MutableLiveData<SearchPeopleItemData>()
        items.clear()
        for (x in 0..10){
            data.value = spid
            items.add(data)
        }
        isRefresh.value = false
    }

    fun createTestData(){
        createTestData("雨幕","梦里梦到醒不来的梦，红线里被软禁的红，所有...")
    }
}