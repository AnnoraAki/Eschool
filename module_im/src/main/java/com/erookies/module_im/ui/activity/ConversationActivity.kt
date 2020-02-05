package com.erookies.module_im.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseActivity
import com.erookies.module_im.R
import com.erookies.module_im.helper.JIMHelper

class ConversationActivity : BaseActivity() {
    private val TAG = "ConversationActivity"
    private val conversation = JIMHelper.conversation
    private val messages:MutableList<Message> = JIMHelper.getAllMessageForUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.im_activity_conversation)
        JIMHelper.receiver = this
        JIMHelper.enterChat()
    }

    override fun onDestroy() {
        super.onDestroy()
        JIMHelper.exitChat()
    }

    fun onEvent(event: MessageEvent){
        val msg = event.message
        when(msg.contentType){
            ContentType.text -> {
                //todo 写入消息体展示
            }
            else -> {
                Log.d(TAG,msg.contentType.name)
            }
        }
    }

    fun onEvent(event:OfflineMessageEvent){
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
}
