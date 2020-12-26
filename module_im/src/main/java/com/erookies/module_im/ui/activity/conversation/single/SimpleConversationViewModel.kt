package com.erookies.module_im.ui.activity.conversation.single

import cn.jpush.im.android.api.model.Message
import com.erookies.lib_common.utils.JIMUtils
import com.erookies.module_im.ui.activity.conversation.base.ConversationViewModel

class SimpleConversationViewModel : ConversationViewModel() {
    private val TAG = "ConversationViewModel"

    init {
        add.value = false
        msgs.value = mutableListOf()
        isFirstIn.value = true
    }

    override fun getAllMessages() {
        msgs.value = JIMUtils.getAllMessageForUser()
    }

    override fun addMessage(m : Message) {
        msgs.value?.add(m)
        add.value = !add.value!!
    }

    override fun loadMoreNewestMessage(limit: Int) {
        val list = mutableListOf<Message>()
        //msg.value为null时为避免越界，cnt设为1，这样计算offset可以统一
        val cnt = msgs.value?.size ?: 1
        val r = JIMUtils.getMessageFromNewest(cnt - 1, limit)
        list.addAll(r)
        list.addAll(msgs.value ?: emptyList<Message>())
        msgs.value = list
    }
}