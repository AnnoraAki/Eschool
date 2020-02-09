package com.erookies.module_im.ui.fragment.entry

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.NotificationClickEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.api.BasicCallback
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.IM_ENTRY
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType

import com.erookies.module_im.R
import com.erookies.module_im.helper.JIMHelper
import com.erookies.module_im.ui.activity.conversation.ConversationActivity
import com.erookies.module_im.ui.adapter.ConversationRVAdapter
import kotlinx.android.synthetic.main.im_fragment_imentry.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.support.v4.toast

@Route(path = IM_ENTRY)
class IMEntryFragment : BaseFragment() {
    private val TAG = "IMEntryFragment"
    private val adapter:ConversationRVAdapter = ConversationRVAdapter()
    private val recyclerView:RecyclerView
        get() = im_conversation_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JMessageClient.init(BaseApp.context)
        ARouter.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.im_fragment_imentry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter.conversations.addAll(JIMHelper.getConversationList())
        adapter.notifyDataSetChanged()
    }

    /**
     * 处理SDK上抛的在线消息
     */
    fun onEventMainThread(event: MessageEvent){
        //todo 根据上抛的在线消息放入对应的conversation所持有的消息列表
    }

    /**
     * 处理SDK上抛的离线消息
     */
    fun onEventMainThread(event: OfflineMessageEvent){
        //todo 根据上抛的离线消息放入对应的conversation所持有的消息列表
        val msgs = event.offlineMessageList
        event.conversation.targetInfo
    }

    /**
     * 处理SDK上抛的通知消息
     */
    fun onEventMainThread(event: NotificationClickEvent){
        val msg = event.message
    }

    /**
     * 处理即时聊天相关的时间
     */
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    fun attchIMFunction(event:IMEvent){
        Log.d(TAG,BaseApp.user?.username)
        when(event.type){
            IMEventType.REGISTER -> JIMHelper.register(BaseApp.user!!,object : BasicCallback() {
                override fun gotResult(responseCode: Int, responseMessage: String?) {
                    Log.d(TAG,"状态码：$responseCode")
                    if (responseCode != 0){
                        Log.d(TAG,responseMessage)
                        toast("状态码：$responseCode\n$responseMessage")
                    }else if (responseCode == 0){
                        toast("注册成功")
                    }
                }
            })

            IMEventType.LOGIN -> JIMHelper.login(BaseApp.user!!,object : BasicCallback(){
                override fun gotResult(responseCode: Int, responseMessage: String?) {
                    Log.d(TAG,"状态码：$responseCode")
                    if (responseCode != 0){
                        Log.d(TAG,responseMessage)
                        toast("状态码：$responseCode\n$responseMessage")
                    }else if (responseCode == 0){
                        toast("登录成功")
                    }
                }
            })

            IMEventType.LOGOUT -> {
                if (BaseApp.isLogin){
                    JIMHelper.logout()
                    toast("已退出")
                }else{
                    toast("当前没有登录账号！")
                }
            }

            IMEventType.START_CONVERSATION -> {
                if (BaseApp.isLogin){
                    if (event.friend != null){
                        JIMHelper.chatWith(event.friend!!)
                        val intent = Intent(activity,
                            ConversationActivity::class.java)
                        startActivity(intent)
                    }else{
                        toast("没有聊天对象不能进行聊天哦~")
                    }
                }else{
                    toast("当前没有登录账号！")
                }
            }

            IMEventType.UPDATE_PWD -> {
                if (BaseApp.isLogin){
                    if (!TextUtils.isEmpty(event.newPwd)){
                        JIMHelper.updateMyPwd(BaseApp.user!!.pwd,event.newPwd,object : BasicCallback(){
                            override fun gotResult(responseCode: Int, responseMessage: String?) {
                                if (responseCode != 0){
                                    Log.d(TAG,responseMessage)
                                    toast("密码更新失败~")
                                }else{
                                    toast("密码更新成功！")
                                }
                            }
                        })
                    }else{
                        toast("新密码不能为空哦~")
                    }
                }else{
                    toast("当前没有登录账号！")
                }
            }

            IMEventType.UPDATE_INFO -> {
                if (BaseApp.isLogin){
                    JIMHelper.updateUserInfo(BaseApp.user!!,object : BasicCallback(){
                        override fun gotResult(responseCode: Int, responseMessage: String?) {
                            if (responseCode == 0){
                                toast("信息更新成功！")
                            }else{
                                toast("信息更新失败~")
                            }
                        }

                    })
                }else{
                    toast("当前没有登录账号！")
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
