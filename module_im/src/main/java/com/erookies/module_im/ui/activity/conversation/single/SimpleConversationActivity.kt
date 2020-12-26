package com.erookies.module_im.ui.activity.conversation.single

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.api.BasicCallback
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.config.SIMPLE_CONVERSATION
import com.erookies.lib_common.extentions.margin
import com.erookies.lib_common.extentions.toast
import com.erookies.module_im.R
import com.erookies.lib_common.utils.JIMUtils
import com.erookies.module_im.ui.activity.conversation.base.ConversationActivity
import com.erookies.module_im.ui.adapter.MessagesAdapter
import kotlinx.android.synthetic.main.im_activity_conversation.*

const val PAGE_VALUE = 10

@Route(path = SIMPLE_CONVERSATION)
class SimpleConversationActivity : ConversationActivity() {
    private val TAG = "SimpleConversationActivity"

    private val swipeRefreshLayout: SwipeRefreshLayout
        get() = im_message_list_refresh

    private val adapter by lazy {
        viewModel.loadMoreNewestMessage(PAGE_VALUE)
        MessagesAdapter(viewModel.msgs.value ?: mutableListOf())
    }

    override fun getLayoutId(): Int {
        return R.layout.im_activity_conversation
    }

    override fun getConversationName(): String {
        return if (getConversationType() == ConversationType.single) {
            val info = JIMUtils.conversation.targetInfo as UserInfo
            if (!TextUtils.isEmpty(info.nickname)) {
                info.nickname
            } else {
                info.userName
            }
        } else if (getConversationType() == ConversationType.group){
            val groupInfo = JIMUtils.conversation.targetInfo as GroupInfo
            if (!TextUtils.isEmpty(groupInfo.groupName)) {
                groupInfo.groupName
            } else {
                val info = groupInfo.ownerMemberInfo.userInfo
                if (!TextUtils.isEmpty(info.nickname)) {
                    info.nickname + "的群聊"
                } else {
                    info.userName + "的群聊"
                }
            }
        } else{
            "unknown"
        }
    }

    override fun getConversationType(): ConversationType {
        return JIMUtils.conversation.type
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe()
        initView()
    }

    private fun initView(){
        im_message_list.layoutManager = LinearLayoutManager(this)
        im_message_list.adapter = adapter
        im_message_list.scrollToPosition(adapter.itemCount - 1)

        im_send_message.setOnClickListener {
            val str = im_input_text.text.toString()
            if (!TextUtils.isEmpty(str)) {
                im_input_text.setText("")
                val msg = JIMUtils.createMessage(str)
                JIMUtils.sendMessage(msg,object : BasicCallback(){
                    override fun gotResult(responseCode: Int, responseMessage: String?) {
                        if (responseCode != 0){
                            toast(responseMessage.toString())
                        } else {
                            viewModel.addMessage(msg)
                        }
                    }
                })
            }

        }

        swipeRefreshLayout.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.themeYellow)
            )
            setOnRefreshListener {
                viewModel.loadMoreNewestMessage(PAGE_VALUE)
            }
        }
    }

    private fun observe() {
        viewModel.msgs.observe{ m ->
            swipeRefreshLayout.isRefreshing = true
            adapter.update(m)
            JIMUtils.conversation.resetUnreadCount()
            swipeRefreshLayout.isRefreshing = false
        }

        viewModel.add.observe {
            swipeRefreshLayout.isRefreshing = true
            adapter.addNewMessage()
            im_message_list.scrollToPosition(adapter.itemCount - 1)
            JIMUtils.conversation.resetUnreadCount()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    /**
     * EventBus事件
     */
    fun onEventMainThread(event: OfflineMessageEvent){
        val offlineMessages = event.offlineMessageList
        for (msg in offlineMessages){
            when(msg.targetType){
                ConversationType.single -> {
                    val userId = (msg.targetInfo as UserInfo).userName
                    val info = JIMUtils.conversation.targetInfo as UserInfo
                    if (TextUtils.equals(info.userName,userId)){
                        viewModel.addMessage(msg)
                    }
                }
                else -> {
                    Log.d(TAG,"other conversation")
                }
            }
        }
    }

    fun onEventMainThread(event: MessageEvent){
        val msg = event.message
        val type = event.message.targetType
        when(type){
            ConversationType.single -> {
                val userId = (msg.targetInfo as UserInfo).userName
                val info = JIMUtils.conversation.targetInfo as UserInfo
                if (TextUtils.equals(info.userName,userId)){
                    viewModel.addMessage(msg)
                }
            }
            else -> {
                Log.d(TAG,"other conversation")
            }
        }
    }

    override fun adjustContentViewSize(offset: Int) {
        parent_container.margin(0, 0, 0, offset)
    }
}
