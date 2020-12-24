package com.erookies.module_im.ui.activity.conversation

import androidx.lifecycle.MutableLiveData
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.utils.JIMHelper

class SingleConversationViewModel : BaseViewModel() {
    private val TAG = "ConversationViewModel"
    val conversation = MutableLiveData<Conversation>()
    val messages = MutableLiveData<MutableList<Message>>()

    init {
        conversation.value = JIMHelper.conversation
    }

    fun getAllMessages():MutableList<Message> = JIMHelper.getAllMessageForUser()
}