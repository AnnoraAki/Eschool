package com.erookies.module_im.helper

import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.api.BasicCallback
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.config.APK_KEY

object JIMHelper {
    lateinit var conversation: Conversation
    var receiver:Any? = null

    fun register(user: User,callback: BasicCallback){
        JMessageClient.register(user.username,user.pwd,callback)
    }

    fun login(user: User,callback: BasicCallback){
        JMessageClient.login(user.username,user.pwd,callback)
    }

    fun logout(){
        JMessageClient.logout()
    }

    fun updateMyPwd(oldPwd:String,newPwd:String,callback: BasicCallback){
        JMessageClient.updateUserPassword(oldPwd,newPwd,callback)
    }

    fun chatWith(user: User){
        conversation = Conversation.createSingleConversation(user.username, APK_KEY)
        JMessageClient.enterSingleConversation(user.username, APK_KEY)
    }

    fun getConversationList():MutableList<Conversation>{
        return JMessageClient.getConversationList()
    }

    /**
     * 以下方法需在进入聊天界面后调用才行
     * 进入界面后设置receiver
     */

    //进入聊天界面调用
    fun enterChat(){
        JMessageClient.registerEventReceiver(receiver)
    }

    //退出聊天界面调用
    fun exitChat(){
        JMessageClient.exitConversation()
        JMessageClient.unRegisterEventReceiver(receiver)
    }

    fun getAllMessageForUser():MutableList<Message>{
        return conversation.allMessage
    }

    //发送消息
    fun sendMessage(content:String,callback: BasicCallback){
        val message = conversation.createSendTextMessage(content)
        message.setOnSendCompleteCallback(callback)
        //接收消息需要写到UI里面或者viewModel内 onEventMainThread(event:MessageEvent)
        //接收消息的界面需要记得注册和解绑
        //JMessageClient.registerEventReceiver(this)
        //JMessageClient.unRegisterEventReceiver(this)
        JMessageClient.sendMessage(message)
    }
}