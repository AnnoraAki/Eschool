package com.erookies.module_im.helper

import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.callback.GetUserInfoCallback
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.android.api.options.RegisterOptionalUserInfo
import cn.jpush.im.api.BasicCallback
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.config.APK_KEY

object JIMHelper {
    lateinit var conversation: Conversation
    private val TAG = "JIMHelper"

    fun register(user: User,callback: BasicCallback){
        val registerOptionalUserInfo = RegisterOptionalUserInfo()
        registerOptionalUserInfo.nickname = user.nickname
        registerOptionalUserInfo.extras = mapOf(
            "collage" to user.college,
            "email" to user.email,
            "avatar_url" to user.avatar
        )
        JMessageClient.register(user.stuNum,user.pwd,registerOptionalUserInfo,callback)
    }

    fun login(user: User,callback: BasicCallback){
        JMessageClient.login(user.stuNum,user.pwd,callback)
    }

    fun logout(){
        JMessageClient.logout()
    }

    fun updateMyPwd(oldPwd:String,newPwd:String,callback: BasicCallback){
        JMessageClient.updateUserPassword(oldPwd,newPwd,callback)
    }

    fun chatWith(user: User){
        conversation = Conversation.createSingleConversation(user.stuNum, APK_KEY)
        JMessageClient.enterSingleConversation(user.stuNum, APK_KEY)
    }

    fun getConversationList():MutableList<Conversation>{
        return JMessageClient.getConversationList()
    }

    fun updateUserInfo(user: User,basicCallback: BasicCallback){
        val userInfo = JMessageClient.getMyInfo()
        userInfo.nickname = user.username
        userInfo.setUserExtras("avatar_url",user.avatar)
        JMessageClient.updateMyInfo(UserInfo.Field.all,userInfo,basicCallback)
    }

    fun getUserInfo(userID: String,callback: GetUserInfoCallback){
        JMessageClient.getUserInfo(userID, APK_KEY,callback)
    }

    /**
     * 以下方法需在进入聊天界面后调用才行
     * 进入界面后设置receiver
     */

    fun getAllMessageForUser():MutableList<Message>{
        return conversation.allMessage
    }

    //发送消息
    fun sendMessage(content:String,callback: BasicCallback){
        val message = conversation.createSendTextMessage(content)
        message.setOnSendCompleteCallback(callback)
        JMessageClient.sendMessage(message)
    }
}