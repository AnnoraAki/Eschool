package com.erookies.lib_common.event

import com.erookies.lib_common.bean.User

data class IMEvent(val type:IMEventType,
                   var friend:User? = null,
                   val newPwd:String="")

enum class IMEventType{

    /**
     * 注册账号事件类型
     * event中只需要type即可
     * 需要发送粘性事件
     */
    REGISTER,

    /**
     * 登录账号事件类型
     * 同上
     * 需要发送粘性事件
     */
    LOGIN,

    /**
     * 退出登录事件类型
     */
    LOGOUT,

    /**
     * 更新密码
     * event中需要type和newPwd
     */
    UPDATE_PWD,

    /**
     * 更新信息
     * 在更新当前用户信息（主要是更新昵称、头像）时使用
     * event中只需要type即可
     */
    UPDATE_INFO,

    /**
     * 进入聊天界面
     * event中需要type和friendUser(聊天对象)
     */
    START_CONVERSATION
}