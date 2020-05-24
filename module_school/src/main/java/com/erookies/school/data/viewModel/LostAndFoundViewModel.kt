package com.erookies.school.data.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.lib_common.config.START_FROM_USER
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.Tag
import com.erookies.school.data.repository.LostAndFoundRepository

class LostAndFoundViewModel(private val repository: LostAndFoundRepository) : BaseViewModel() {
    var currentUser = MutableLiveData<User>()

    var items = MutableLiveData<MutableList<ItemData>>()

    var currentTag = MutableLiveData<Tag>()

    var startType = START_FROM_MAIN

    var isRefreshing = MutableLiveData<Boolean>()

    var needToast = MutableLiveData<Boolean>()
    var errorMsg:String = ""

    init {
        items.value = mutableListOf()
        currentUser.value = User()
        isRefreshing.value = true
        currentTag.value = Tag.CARD
        needToast.value = false
    }

    fun getItemDataList(){
        isRefreshing.value = true
        needToast.value = false

        errorMsg = ""

        //获取数据
        repository.loadItemList(startType, {list->
            //装载数据
            if (list.isNullOrEmpty()){
                isRefreshing.value = false
                errorMsg = "无相关数据"
                needToast.value = true
            }else{
                //判断启动类型再装载数据
                if (startType == START_FROM_MAIN){
                    items.value = list.filter {item->
                            item.tag == currentTag.value
                        }.toMutableList()
                }else{
                    items.value = list.filter {item->
                        item.tag != Tag.SP
                    }.toMutableList()
                }

                isRefreshing.value = false
                if (items.value.isNullOrEmpty()){
                    errorMsg = "没有相关数据"
                    needToast.value = true
                }
            }
        },{
            //错误处理
            isRefreshing.value = false
            errorMsg = "建立连接失败"
            needToast.value = true
            Log.d("LostAndFoundViewModel",it)
        })
    }
}