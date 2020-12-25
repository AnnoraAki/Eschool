package com.erookies.module_im.ui.activity.conversation.single

import android.graphics.Rect
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.api.BasicCallback
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.SINGLE_CONVERSATION
import com.erookies.lib_common.extentions.margin
import com.erookies.lib_common.extentions.toast
import com.erookies.module_im.R
import com.erookies.lib_common.utils.JIMUtils
import com.erookies.lib_common.utils.getAttrValue
import com.erookies.lib_common.utils.getStatusBarHeight
import com.erookies.module_im.ui.activity.conversation.ConversationActivity
import com.erookies.module_im.ui.adapter.MessagesAdapter
import kotlinx.android.synthetic.main.im_activity_conversation.*

@Route(path = SINGLE_CONVERSATION)
class SingleConversationActivity : ConversationActivity(ConversationType.single) {
    private val TAG = "SingleConversationActivity"
    private val userInfo: UserInfo = JIMUtils.conversation.targetInfo as UserInfo
    private val avatar:String = userInfo.extras["avatar"] ?: ""
    private val nickName:String = if (!TextUtils.isEmpty(userInfo.nickname)) userInfo.nickname else userInfo.userName
    private val adapter = MessagesAdapter(avatar)

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(
        SingleConversationViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        common_toolbar.init(title = nickName)
        initView()
    }

    override fun getLayoutId(): Int {
        return R.layout.im_activity_conversation
    }

    private fun initView(){
        val msgs = viewModel.getAllMessages()
        adapter.messages.addAll(msgs)
        im_message_list.layoutManager = LinearLayoutManager(this)
        im_message_list.adapter = adapter
        adapter.notifyDataSetChanged()
        im_message_list.scrollToPosition(adapter.itemCount - 1)

        im_send_message.setOnClickListener {
            val str = im_input_text.text.toString()
            if (!TextUtils.isEmpty(str)) {
                im_input_text.setText("")
                val msg = JIMUtils.createMessage(str)
                adapter.messages.add(msg)
                adapter.notifyDataSetChanged()
                im_message_list.scrollToPosition(adapter.itemCount - 1)

                JIMUtils.sendMessage(msg,object : BasicCallback(){
                    override fun gotResult(responseCode: Int, responseMessage: String?) {
                        if (responseCode != 0){
                            toast(responseMessage.toString())
                        }
                    }
                })
            }

        }
    }

    override fun getFactory(): ViewModelProvider.Factory? {
        return SingleConversationFactory()
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
                    if (TextUtils.equals(BaseApp.user?.stuNum,userId)){
                        adapter.messages.add(msg)
                    }
                }
                else -> {
                    Log.d(TAG,"other conversation")
                }
            }
        }
        adapter.notifyDataSetChanged()
        im_message_list.scrollToPosition(adapter.itemCount - 1)
    }

    fun onEventMainThread(event: MessageEvent){
        val msg = event.message
        val type = event.message.targetType
        when(type){
            ConversationType.single -> {
                val userId = (msg.targetInfo as UserInfo).userName
                if (TextUtils.equals(BaseApp.user?.stuNum,userId)){
                    adapter.messages.add(msg)
                }
            }
            else -> {
                Log.d(TAG,"other conversation")
            }
        }
        adapter.notifyDataSetChanged()
        im_message_list.scrollToPosition(adapter.itemCount - 1)
    }

    override fun adjustContentViewSize(offset: Int) {
        parent_container.margin(0, 0, 0, offset)
    }
}
