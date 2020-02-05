package com.erookies.module_im.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.api.BasicCallback
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.IM_ENTRY
import com.erookies.lib_common.config.SCHOOL_PUBLISH
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType

import com.erookies.module_im.R
import com.erookies.module_im.helper.JIMHelper
import com.erookies.module_im.ui.activity.ConversationActivity
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.support.v4.toast

@Route(path = IM_ENTRY)
class IMEntryFragment : BaseFragment() {
    private val TAG = "IMEntryFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JMessageClient.init(BaseApp.context)
        ARouter.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.im_fragment_imentry, container, false)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun attchIMFunction(event:IMEvent){
        when(event.type){
            //注册账户时调用的
            IMEventType.REGISTER -> JIMHelper.register(event.currentUser,object : BasicCallback() {
                override fun gotResult(responseCode: Int, responseMessage: String?) {
                    if (responseCode != 0){
                        Log.d(TAG,responseMessage)
                    }
                }
            })
            //登录时调用
            IMEventType.LOGIN -> JIMHelper.login(event.currentUser,object : BasicCallback(){
                override fun gotResult(responseCode: Int, responseMessage: String?) {
                    if (responseCode != 0){
                        Log.d(TAG,responseMessage)
                    }
                }
            })
            IMEventType.LOGOUT -> JIMHelper.logout()
            IMEventType.START_CONVERSATION -> {
                if (event.friend != null){
                    JIMHelper.chatWith(event.friend!!)
                    //TODO 获取conversation对象，启动相应UI界面,并将conversation传入
                    val intent = Intent(activity,ConversationActivity::class.java)
                    startActivity(intent)
                }else{
                    toast("没有聊天对象不能进行聊天哦~")
                }
            }
            IMEventType.EXIT_CONVERSATION -> JIMHelper.exitChat()
            IMEventType.UPDATE_PWD -> {
                if (!TextUtils.isEmpty(event.newPwd)){
                    JIMHelper.updateMyPwd(event.currentUser.pwd,event.newPwd,object : BasicCallback(){
                        override fun gotResult(responseCode: Int, responseMessage: String?) {
                            if (responseCode != 0){
                                Log.d(TAG,responseMessage)
                            }
                        }
                    })
                }else{
                    toast("新密码不能为空哦~")
                }
            }
            IMEventType.CONVERSATION_LIST -> JIMHelper.getConversationList()
        }
    }

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
}
