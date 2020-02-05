package com.erookies.lib_common.event

import com.erookies.lib_common.bean.User

data class IMEvent(val type:IMEventType,
                   val currentUser: User,
                   var friend:User? = null,
                   val newPwd:String="") {
}

enum class IMEventType{
    REGISTER,
    LOGIN,
    LOGOUT,
    UPDATE_PWD,
    EXIT_CONVERSATION,
    START_CONVERSATION,
    CONVERSATION_LIST
}