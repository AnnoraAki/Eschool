package com.erookies.module_im.ui.fragment.entry

import androidx.lifecycle.MutableLiveData
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.android.api.model.UserInfo
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.module_im.helper.JIMHelper

class IMEntryViewModel() : BaseViewModel() {
    val conversations = MutableLiveData<MutableList<Conversation>>()

    var toastMsg:String = ""
    val needToast = MutableLiveData<Boolean>()

    init {
        needToast.value = false
        if (BaseApp.isLogin){
            conversations.value?.addAll(JIMHelper.getConversationList())
        }else{
            conversations.value = mutableListOf()

            toastMsg = "当前没有登录用户"
            needToast.value = true
        }
        toastMsg = ""
        needToast.value = false
    }

    fun updateConversations(){
        needToast.value = false
        if (BaseApp.isLogin){
            conversations.value = JIMHelper.getConversationList()
            if (conversations.value?.size == 0){
                toastMsg = "当前没有会话"
                needToast.value = true
            }
        }else{
            toastMsg = "当前没有登录用户"
            needToast.value = true
        }

        toastMsg = ""
        needToast.value = false
    }
}