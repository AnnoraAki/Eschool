package com.erookies.lib_common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Process
import android.text.TextUtils
import android.util.Log
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.JMessageClient.FLAG_NOTIFY_DEFAULT
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.NotificationClickEvent
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.api.BasicCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.config.SIMPLE_CONVERSATION
import com.erookies.lib_common.config.SP_KEY_USER
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.lib_common.extentions.defaultSharedPreferences
import com.erookies.lib_common.extentions.editor
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.utils.JIMUtils
import com.erookies.lib_common.utils.LogUtils
import com.google.gson.Gson
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.bugly.crashreport.CrashReport.UserStrategy
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * Create by Cchanges.
 * Time: 2019-09-29
 */
const val TAG = "BaseApp"

open class BaseApp : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
            private set


        var user: User? = null
            set(value) {
                field = value
                val json = value?.toJSON() ?: ""
                LogUtils.e("value=$value,json:$json")
                context.defaultSharedPreferences.editor {
                    putString(SP_KEY_USER, json)
                }
            }
            get() {
                if (field == null) {
                    val json = context.defaultSharedPreferences.getString(SP_KEY_USER, "")
                    LogUtils.d(json, "userJson")
                    try {
                        field = Gson().fromJson(json, User::class.java)
                    } catch (e: Throwable) {
                        LogUtils.d(json, "userJson")
                    }
                }
                return field
            }

        val isLogin get() = user != null
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
    }

    override fun onCreate() {
        super.onCreate()
        initARouter()
        initBugly()
        initJMessage()
        initEventBus()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun initBugly() {
        val context = applicationContext
        val packageName = context.packageName
        val processName = com.erookies.lib_common.utils.getProcessName(Process.myPid())
        val strategy = UserStrategy(context)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(applicationContext, "869328ad4b", false)
    }

    private fun initJMessage() {
        JMessageClient.init(context)
        JMessageClient.registerEventReceiver(this)
        JMessageClient.setNotificationFlag(FLAG_NOTIFY_DEFAULT)
    }

    private fun initEventBus() {
        EventBus.getDefault().register(this)
    }

    /**
     * 处理SDK上抛的通知消息
     */
    fun onEventMainThread(event: NotificationClickEvent){
        val msg = event.message

        var canNavi = false
        when(msg.targetType) {
            ConversationType.single -> {
                val info = msg.targetInfo as UserInfo
                canNavi = JIMUtils.chatWith(info.userName)
            }
            ConversationType.group -> {
                val info = msg.targetInfo as GroupInfo
                canNavi = JIMUtils.chatWith(info.groupID)
            }
        }

        if (canNavi) ARouter.getInstance().build(SIMPLE_CONVERSATION).navigation()
    }

    /**
     * 处理即时聊天相关的事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public fun handleIMEvent(event: IMEvent){
        Log.d("attchIMFunction","event content : $event")
        when(event.type){
            IMEventType.REGISTER -> {
                JIMUtils.register(event.friend!!,object : BasicCallback() {
                    override fun gotResult(responseCode: Int, responseMessage: String?) {
                        Log.d(TAG,"状态码：$responseCode")
                        if (responseCode != 0){
                            Log.d(TAG,"状态码：$responseCode\n$responseMessage")
                            toast("${TAG}注册失败")
                        }else if (responseCode == 0){
                            toast("${TAG}注册成功")
                        }
                    }
                })
            }

            IMEventType.LOGIN -> JIMUtils.login(BaseApp.user!!,object : BasicCallback(){
                override fun gotResult(responseCode: Int, responseMessage: String?) {
                    Log.d(TAG,"状态码：$responseCode")
                    if (responseCode != 0){
                        Log.d(TAG,"状态码：$responseCode\n$responseMessage")
                    }else if (responseCode == 0){
                        JIMUtils.oldPwd = BaseApp.user!!.pwd
                        toast("${TAG} 登录成功")
                    }
                }
            })

            IMEventType.LOGOUT -> {
                if (BaseApp.isLogin){
                    JIMUtils.logout()
                    toast("${TAG}已退出")
                }else{
                    toast("${TAG}当前没有登录账号！")
                }
            }

            IMEventType.START_SINGLE_CONVERSATION -> {
                if (BaseApp.isLogin){
                    if (event.friend != null){
                        if (JIMUtils.chatWith(event.friend)) ARouter.getInstance().build(SIMPLE_CONVERSATION).navigation()
                    }else{
                        toast("${TAG}没有聊天对象不能进行聊天哦~")
                    }
                }else{
                    toast("${TAG}当前没有登录账号！")
                }
            }

            IMEventType.START_GROUP_CONVERSATION -> {
                if (BaseApp.isLogin){
                    if (event.groupId != -1L){
                        if (JIMUtils.chatWith(event.groupId)) ARouter.getInstance().build(SIMPLE_CONVERSATION).navigation()
                    }else{
                        toast("${TAG}无效的群聊~")
                    }
                }else{
                    toast("${TAG}当前没有登录账号！")
                }
            }

            IMEventType.UPDATE_PWD -> {
                if (BaseApp.isLogin){
                    if (!TextUtils.isEmpty(event.newPwd)){
                        JIMUtils.updateMyPwd(event.newPwd,object : BasicCallback(){
                            override fun gotResult(responseCode: Int, responseMessage: String?) {
                                if (responseCode != 0){
                                    Log.d(TAG,"状态码：$responseCode 错误信息：$responseMessage")
                                    Log.d(TAG,"原密码：${BaseApp.user!!.pwd} 新密码：${event.newPwd}")
                                }else{
                                    JIMUtils.oldPwd = event.newPwd
                                }
                            }
                        })
                    }else{
                        toast("${TAG}新密码不能为空哦~")
                    }
                }else{
                    toast("${TAG}当前没有登录账号！")
                }
            }

            IMEventType.UPDATE_INFO -> {
                if (BaseApp.isLogin){
                    JIMUtils.updateUserInfo(BaseApp.user!!,object : BasicCallback(){
                        override fun gotResult(responseCode: Int, responseMessage: String?) {
                            if (responseCode == 0){
                                toast("${TAG}信息更新成功！")
                            }else{
                                toast("${TAG}信息更新失败~")
                            }
                        }

                    })
                }else{
                    toast("${TAG}当前没有登录账号！")
                }
            }
        }

        //移除粘性事件
        val stickyEvent = EventBus.getDefault().getStickyEvent(MessageEvent::class.java)
        if (stickyEvent != null){
            EventBus.getDefault().removeStickyEvent(stickyEvent)
        }
    }
}