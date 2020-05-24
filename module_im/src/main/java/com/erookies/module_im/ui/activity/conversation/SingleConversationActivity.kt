package com.erookies.module_im.ui.activity.conversation

import android.graphics.Rect
import android.os.Bundle
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.OfflineMessageEvent
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.api.BasicCallback
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.toast
import com.erookies.module_im.R
import com.erookies.module_im.helper.JIMHelper
import com.erookies.module_im.model.MessageWrapper
import com.erookies.module_im.ui.adapter.MessagesAdapter
import kotlinx.android.synthetic.main.im_activity_conversation.*
import java.lang.StringBuilder

class SingleConversationActivity : BaseActivity() {
    private val TAG = "ConversationActivity"
    private val userInfo: UserInfo = JIMHelper.conversation.targetInfo as UserInfo
    private val avatar:String = userInfo.extras["avatar"] ?: ""
    private val nickName:String = if (!TextUtils.isEmpty(userInfo.nickname)) userInfo.nickname else userInfo.userName
    private val adapter = MessagesAdapter(avatar)

    private val mInputAreaRect = Rect()
    private val mCurrentWindowRect = Rect()

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(SingleConversationViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.im_activity_conversation)
        window.decorView.viewTreeObserver.addOnGlobalLayoutListener(mViewGlobalListener)
        JMessageClient.registerEventReceiver(this)
        JMessageClient.enterSingleConversation((JIMHelper.conversation.targetInfo as UserInfo).userName)
        common_toolbar.init(title = nickName)
        initView()
    }

    private fun initView(){
        val msgs = viewModel.getAllMessages()
        adapter.messages.addAll(msgs)
        computeInputAreaBounds()
        im_message_list.layoutManager = LinearLayoutManager(this)
        im_message_list.adapter = adapter
        adapter.notifyDataSetChanged()
        im_message_list.scrollToPosition(adapter.itemCount - 1)

        im_send_message.setOnClickListener {
            val str = im_input_text.text.toString()
            im_input_text.setText("")
            val msg = JIMHelper.createMessage(str)
            adapter.messages.add(msg)
            adapter.notifyDataSetChanged()
            im_message_list.scrollToPosition(adapter.itemCount - 1)

            JIMHelper.sendMessage(msg,object : BasicCallback(){
                override fun gotResult(responseCode: Int, responseMessage: String?) {
                    if (responseCode != 0){
                        toast(responseMessage.toString())
                    }
                }
            })

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        JMessageClient.unRegisterEventReceiver(this)
        JMessageClient.exitConversation()
    }

    override fun getFactory(): ViewModelProvider.Factory? {
        return SingleConversationFactory()
    }

    private val mViewGlobalListener = ViewTreeObserver.OnGlobalLayoutListener {
        window.decorView.getWindowVisibleDisplayFrame(mCurrentWindowRect)
        val topValue = mCurrentWindowRect.bottom - mInputAreaRect.height()
        val margin = ViewGroup.MarginLayoutParams(im_input_area.layoutParams)
        margin.setMargins(topValue, 0, 0, 0)
        im_input_area.layoutParams = margin
    }

    private fun computeInputAreaBounds() {
        im_input_area.getLocalVisibleRect(mInputAreaRect)
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
}
