package com.erookies.lib_common.utils

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

object JIMUtils {
    lateinit var conversation: Conversation
        private set

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

    fun chatWith(user: User?): Boolean{
        user ?: return false
        user.stuNum ?: return false
        conversation = Conversation.createSingleConversation(user.stuNum, APK_KEY)
        JMessageClient.enterSingleConversation(user.stuNum, APK_KEY)
        return true
    }

    fun chatWith(userName: String?): Boolean{
        userName ?: return false
        conversation = Conversation.createSingleConversation(userName, APK_KEY)
        JMessageClient.enterSingleConversation(userName, APK_KEY)
        return true
    }

    fun getConversationList():MutableList<Conversation>{
        val list = JMessageClient.getConversationList()
        return if (list.isNullOrEmpty()) {
            mutableListOf()
        } else {
            list
        }
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

    fun groupConversationIsExist(groupId:Long):Boolean {
        for (con in JMessageClient.getConversationList()){
            if (conversation.type == ConversationType.group){
                if (groupId == (con.targetInfo as GroupInfo).groupID){
                    return true
                }
            }
        }
        return false
    }

    fun addMemberIntoGroup(groupId: Long, userName: String, basicCallback: BasicCallback) {
        if (!groupConversationIsExist(groupId)) return
        JMessageClient.addGroupMembers(groupId, arrayListOf(userName), basicCallback)
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