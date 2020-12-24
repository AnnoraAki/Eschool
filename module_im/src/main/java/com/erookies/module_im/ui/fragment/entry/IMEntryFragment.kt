package com.erookies.module_im.ui.fragment.entry

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.event.ConversationRefreshEvent
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.event.NotificationClickEvent
import cn.jpush.im.api.BasicCallback
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.IStartConversation
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.APK_KEY
import com.erookies.lib_common.config.IM_ENTRY
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType

import com.erookies.module_im.R
import com.erookies.lib_common.utils.JIMHelper
import com.erookies.module_im.ui.activity.conversation.SingleConversationActivity
import com.erookies.module_im.ui.adapter.ConversationRVAdapter
import kotlinx.android.synthetic.main.im_fragment_imentry.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.support.v4.toast

@Route(path = IM_ENTRY)
class IMEntryFragment : BaseFragment(),IStartConversation {
    private val TAG = "IMEntryFragment"
    private val adapter:ConversationRVAdapter = ConversationRVAdapter(listener = this)
    private val recyclerView:RecyclerView
        get() = im_conversation_list
    private val swipeRefreshLayout:SwipeRefreshLayout
        get() = im_swipe_refresh

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(IMEntryViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JMessageClient.registerEventReceiver(this)
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
        viewModel.updateConversations()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        observe()
        adapter.apply {
            conversations.addAll(viewModel.conversations.value?: mutableListOf())
        }
        swipeRefreshLayout.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.themeYellow)
            )
            setOnRefreshListener {
                viewModel.updateConversations()
            }
        }
    }


    private fun observe(){
        viewModel.needToast.observe {
            if (it){
                toast(viewModel.toastMsg)
            }
        }
        viewModel.conversations.observe {
            swipeRefreshLayout.isRefreshing = true
            adapter.conversations.clear()
            adapter.conversations.addAll(it)
            adapter.notifyDataSetChanged()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        JMessageClient.unRegisterEventReceiver(this)
    }

    fun onEventMainThread(event: ConversationRefreshEvent){
        val reason = event.reason
        if (reason == ConversationRefreshEvent.Reason.UNREAD_CNT_UPDATED){
            viewModel.updateConversations()
        }
    }

    override fun sendEvent(event: IMEvent) {
        EventBus.getDefault().post(event)
    }
}
