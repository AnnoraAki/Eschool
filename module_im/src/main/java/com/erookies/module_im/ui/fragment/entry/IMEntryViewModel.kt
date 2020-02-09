package com.erookies.module_im.ui.fragment.entry

import androidx.lifecycle.MutableLiveData
import cn.jpush.im.android.api.model.Conversation
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.module_im.helper.JIMHelper

class IMEntryViewModel() : BaseViewModel() {
    val conversations = MutableLiveData<MutableList<Conversation>>()
    val needToast = MutableLiveData<Boolean>()
    val isRefreshing = MutableLiveData<Boolean>()

    init {
        isRefreshing.value = true
        needToast.value = false
        if (BaseApp.isLogin){
            conversations.value?.addAll(JIMHelper.getConversationList())
        }else{
            needToast.value = true
        }
        needToast.value = false
        isRefreshing.value = false
    }

    fun addNewConversation(conversation: Conversation){
        conversations.value?.add(0,conversation)
    }

    fun updateConversations(){
        isRefreshing.value = true
        needToast.value = false
        if (BaseApp.isLogin){
            conversations.value?.clear()
            conversations.value?.addAll(JIMHelper.getConversationList())
        }else{
            needToast.value = true
        }

        isRefreshing.value = false
        needToast.value = false
    }
}