package com.erookies.module_im.ui.activity.conversation.base

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.lifecycle.ViewModelProvider
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.UserInfo
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.utils.JIMUtils
import com.erookies.module_im.ui.activity.conversation.single.SimpleConversationFactory
import com.erookies.module_im.ui.activity.conversation.single.SimpleConversationViewModel

const val cTAG = "ConversationActivity"

abstract class ConversationActivity(): BaseActivity() {
    private var maxWindowBottom: Int = 0
    private var minWindowBottom: Int = 0

    private val rect = Rect()
    private val mGlobalLayoutChangeListener = ViewTreeObserver.OnGlobalLayoutListener {
        attemptChangeWindowSize()
    }

    val viewModel : ConversationViewModel by lazy {
        getViewModel(SimpleConversationViewModel::class.java)
    }

    override fun getFactory(): ViewModelProvider.Factory {
        return SimpleConversationFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        window.decorView.viewTreeObserver.addOnGlobalLayoutListener(mGlobalLayoutChangeListener)
        if (JIMUtils.conversation.type != getConversationType()) {
            toast("聊天类型不对")
            finish()
        }
        when (getConversationType()) {
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
        common_toolbar.init(title = getConversationName())
    }

    abstract fun getLayoutId(): Int

    abstract fun getConversationName(): String

    abstract fun getConversationType() : ConversationType

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