package com.erookies.school.data.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.Tag
import com.erookies.school.data.repository.LostAndFoundRepository

class LostAndFoundViewModel(private val repository: LostAndFoundRepository) : BaseViewModel() {
    var users = MutableLiveData<MutableList<User>>()
    var currentUser = MutableLiveData<User>()

    var items = MutableLiveData<MutableList<ItemData>>()
    private var originalItems = MutableLiveData<MutableList<ItemData>>()

    var currentTag = MutableLiveData<Tag>()

    var startType = START_FROM_MAIN

    var isRefreshing = MutableLiveData<Boolean>()

    var needToast = MutableLiveData<Boolean>()
    var errorMsg:String = ""

    init {
        items.value = mutableListOf()
        originalItems.value = mutableListOf()
        users.value = mutableListOf()
        currentUser.value = User()
        isRefreshing.value = true
        currentTag.value = Tag.CARD
        needToast.value = false
    }

    fun getItemDataList(){
        isRefreshing.value = true
        needToast.value = false
        errorMsg = ""
        originalItems.value?.clear()

        //获取数据
        repository.loadItemList(startType, {list->
            originalItems.value?.addAll(list)
            //装载数据
            if (originalItems.value.isNullOrEmpty()){
                needToast.value = true
                errorMsg = "拉取数据失败"
            }else{
                items.value?.clear()

                //过滤数据
                items.value?.addAll(
                    originalItems.value!!
                        .asSequence().filter {item->
                            item.tag == currentTag.value
                        })

                if (items.value.isNullOrEmpty()){
                    needToast.value = true
                    errorMsg = "没有相关数据"
                }
            }
        },{
            needToast.value = true
            errorMsg = "建立连接失败"
            Log.d("LostAndFoundViewModel",it)
        })

        needToast.value = false
        isRefreshing.value = false
    }

    fun getItemByCurrentTag(){
        isRefreshing.value = true
        needToast.value = false
        errorMsg = ""

        if (!originalItems.value.isNullOrEmpty()){
            items.value?.addAll(
                originalItems.value!!.filter { item->
                    item.tag == currentTag.value
                })
        }

        if (items.value.isNullOrEmpty()){
            needToast.value = true
            errorMsg = "没有相关数据"
        }

        needToast.value = false
        isRefreshing.value = false
    }
}