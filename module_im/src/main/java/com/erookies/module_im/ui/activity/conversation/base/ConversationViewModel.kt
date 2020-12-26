package com.erookies.module_im.ui.activity.conversation.base

import androidx.lifecycle.MutableLiveData
import cn.jpush.im.android.api.model.Message
import com.erookies.lib_common.base.BaseViewModel

abstract class ConversationViewModel : BaseViewModel() {
    val msgs = MutableLiveData<MutableList<Message>>()

    val add = MutableLiveData<Boolean>()

    val isFirstIn = MutableLiveData<Boolean>()

    abstract fun getAllMessages()

    abstract fun loadMoreNewestMessage(limit: Int)

    abstract fun addMessage(m: Message)
}