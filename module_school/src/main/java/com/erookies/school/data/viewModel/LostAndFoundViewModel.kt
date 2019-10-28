package com.erookies.school.data.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.User
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.model.Tag
import com.erookies.school.data.repository.LostAndFoundRepository

class LostAndFoundViewModel(private val repository: LostAndFoundRepository) : BaseViewModel() {
    var users = MutableLiveData<MutableList<User>>()
    var currentUser = MutableLiveData<User>()
    var items = mutableListOf<MutableLiveData<LostAndFoundItemData>>()
    var currentTag = MutableLiveData<Tag>()

    var startType = 20

    var isRefreshing = MutableLiveData<Boolean>()

    init {
        users.value = mutableListOf()
        currentUser.value = User()
        isRefreshing.value = false
        currentTag.value = Tag.CARD
    }

    fun createTestData(name:String,content:String){
        isRefreshing.value = true
        items.clear()
        val user = User(username = name)
        val spid = LostAndFoundItemData(user,content,tag = currentTag.value!!)
        val data = MutableLiveData<LostAndFoundItemData>()
        data.value = spid
        items.clear()
        for (x in 0..10){
            items.add(data)
        }
        isRefreshing.value = false
        Log.d("LostAndFoundFragment","test data is created!")
    }

    fun createTestData() = createTestData(currentTag.value.toString(),"天若有情天亦老，人间正道是沧桑")
}