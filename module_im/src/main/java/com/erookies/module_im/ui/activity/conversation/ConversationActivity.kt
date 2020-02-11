package com.erookies.module_im.ui.activity.conversation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.android.api.model.UserInfo
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.module_im.R
import com.erookies.module_im.helper.JIMHelper

class ConversationActivity : BaseActivity() {
    private val TAG = "ConversationActivity"

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(ConversationViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.im_activity_conversation)
        JMessageClient.registerEventReceiver(this)
        JMessageClient.enterSingleConversation((JIMHelper.conversation.targetInfo as UserInfo).userName)
    }

    override fun onDestroy() {
        super.onDestroy()
        JMessageClient.unRegisterEventReceiver(this)
        JMessageClient.exitConversation()
    }

    override fun getFactory(): ViewModelProvider.Factory? {
        return ConversationFactory()
    }

    /**
     * EventBus事件
     */

    fun onEvent(event: OfflineMessageEvent){
        val offlineMessages = event.offlineMessageList
        for (msg in offlineMessages){
            when(msg.contentType){
                ContentType.text -> {
                    //todo 插入到对应的会话中的消息列表去
                }
                else -> {
                    Log.d(TAG,msg.contentType.name)
                }
            }
        }
    }

    fun onEvent(event: MessageEvent){
        val msg = event.message
        when(msg.contentType){
            ContentType.text -> {
                //todo 写入对应的conversation维护的消息列表中
                val userId = (msg.targetInfo as UserInfo).userName
                if (TextUtils.equals(BaseApp.user?.stuNum,userId)){
                }
            }
            else -> {
                Log.d(TAG,msg.contentType.name)
            }
        }
    }
}
