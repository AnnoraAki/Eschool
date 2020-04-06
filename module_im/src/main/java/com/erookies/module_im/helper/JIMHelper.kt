package com.erookies.module_im.helper

import android.text.TextUtils
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.callback.GetUserInfoCallback
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.android.api.options.RegisterOptionalUserInfo
import cn.jpush.im.api.BasicCallback
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.config.APK_KEY

object JIMHelper {
    lateinit var conversation: Conversation
    private val TAG = "JIMHelper"
    var oldPwd:String = ""

    fun register(user: User,callback: BasicCallback){
        val registerOptionalUserInfo = RegisterOptionalUserInfo()
        registerOptionalUserInfo.nickname = if (!TextUtils.isEmpty(user.nickname)) user.nickname else user.stuNum
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

    fun updateMyPwd(newPwd:String,callback: BasicCallback){
        JMessageClient.updateUserPassword(oldPwd,newPwd,callback)
    }

    fun chatWith(user: User?){
        if (user != null){
            conversation = Conversation.createSingleConversation(user.stuNum)
            JMessageClient.enterSingleConversation(user.stuNum, APK_KEY)
        }
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

    fun getSingleConversation(userNum:String):Conversation{
        for (con in JMessageClient.getConversationList()){
            if (conversation.type == ConversationType.single){
                if (userNum == (con.targetInfo as UserInfo).userName){
                    return con
                }
            }
        }
        return Conversation.createSingleConversation(userNum, APK_KEY)
    }

    fun getGroupConversation(groupId:Long):Conversation{
        for (con in JMessageClient.getConversationList()){
            if (conversation.type == ConversationType.group){
                if (groupId == (con.targetInfo as GroupInfo).groupID){
                    return con
                }
            }
        }
        return Conversation.createGroupConversation(groupId)
    }

    /**
     * 以下方法需在进入聊天界面后调用才行
     */

    fun getAllMessageForUser():MutableList<Message>{
        return conversation.allMessage
    }

    //创建消息
    fun createMessage(content:String):Message = conversation.createSendTextMessage(content)

    //发送消息
    fun sendMessage(message:Message,callback: BasicCallback){
        message.setOnSendCompleteCallback(callback)
        JMessageClient.sendMessage(message)
    }
}