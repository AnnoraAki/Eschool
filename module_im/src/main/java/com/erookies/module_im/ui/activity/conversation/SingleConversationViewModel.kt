package com.erookies.module_im.ui.activity.conversation

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.android.api.model.UserInfo
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.module_im.helper.JIMHelper
import java.util.*

class SingleConversationViewModel : BaseViewModel() {
    private val TAG = "ConversationViewModel"
    val conversation = MutableLiveData<Conversation>()
    val messages = MutableLiveData<MutableList<Message>>()

    init {
        conversation.value = JIMHelper.conversation
    }

    fun getAllMessages():MutableList<Message> = JIMHelper.getAllMessageForUser()
}