package com.erookies.module_im.ui.activity.conversation

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.UserInfo
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.margin
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.utils.JIMUtils

const val cTAG = "ConversationActivity"

abstract class ConversationActivity(private val type: ConversationType): BaseActivity() {
    private var maxWindowBottom: Int = 0
    private var minWindowBottom: Int = 0

    private val rect = Rect()
    private val mGlobalLayoutChangeListener = ViewTreeObserver.OnGlobalLayoutListener {
        attemptChangeWindowSize()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        window.decorView.viewTreeObserver.addOnGlobalLayoutListener(mGlobalLayoutChangeListener)
        if (JIMUtils.conversation.type != type) {
            toast("聊天类型不对")
            finish()
        }
        when (type) {
            ConversationType.single -> {
                val username = (JIMUtils.conversation.targetInfo as UserInfo).userName
                JMessageClient.enterSingleConversation(username)
            }
            ConversationType.group -> {
                val groupId: Long = (JIMUtils.conversation.targetInfo as GroupInfo).groupID
                JMessageClient.enterGroupConversation(groupId)
            }
            else -> {
                toast("不支持的聊天类型")
                finish()
            }
        }
        JMessageClient.registerEventReceiver(this)
        JIMUtils.conversation.resetUnreadCount()
    }

    abstract fun getLayoutId(): Int

    override fun onDestroy() {
        super.onDestroy()
        window.decorView.viewTreeObserver.removeOnGlobalLayoutListener(mGlobalLayoutChangeListener)
        JMessageClient.unRegisterEventReceiver(this)
        JMessageClient.exitConversation()
    }

    private fun attemptChangeWindowSize() {
        window.decorView.getGlobalVisibleRect(rect)
        maxWindowBottom = rect.bottom
        Log.d(cTAG, "getGlobalVisibleRect: {bottom: ${rect.bottom}}")
        window.decorView.getWindowVisibleDisplayFrame(rect)
        minWindowBottom = rect.bottom
        Log.d(cTAG, "getWindowVisibleDisplayFrame: {bottom: ${rect.bottom}}")
        val offset = maxWindowBottom - minWindowBottom
        adjustContentViewSize(offset)
    }

    abstract fun adjustContentViewSize(offset: Int)
}