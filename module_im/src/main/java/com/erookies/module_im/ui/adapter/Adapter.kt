package com.erookies.module_im.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import cn.jpush.im.android.api.content.TextContent
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.enums.MessageDirect
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.Message
import cn.jpush.im.android.api.model.UserInfo
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.IStartConversation
import com.erookies.module_im.R
import com.erookies.module_im.model.MessageWrapper
import com.erookies.module_im.ui.holder.BaseMessageViewHolder
import com.erookies.module_im.ui.holder.ConversationViewHolder
import com.erookies.module_im.ui.holder.LeftViewHolder
import com.erookies.module_im.ui.holder.RightViewHolder

class MessagesAdapter(
    val avatarUrl:String,
    val messages:MutableList<Message> = mutableListOf()
) : RecyclerView.Adapter<BaseMessageViewHolder>() {
    private val left = -1
    private val right = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMessageViewHolder {
        @LayoutRes var layoutRes = R.layout.im_item_left_msg
        if (viewType != left){
            layoutRes = R.layout.im_item_right_msg
        }
        val mainView = LayoutInflater.from(parent.context).inflate(layoutRes,parent,false)
        return when(viewType){
            right -> RightViewHolder(mainView)
            else -> LeftViewHolder(mainView)
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(messages[position].direct){
            MessageDirect.send -> right
            else -> left
        }
    }

    override fun onBindViewHolder(holder: BaseMessageViewHolder, position: Int) {
        val msg = messages[position]
        when(getItemViewType(position)){
            right -> (holder as RightViewHolder).load(msg)
            else -> (holder as LeftViewHolder).load(msg)
        }
    }
}

class ConversationRVAdapter(
    val conversations:MutableList<Conversation> = mutableListOf(),
    val listener:IStartConversation
): RecyclerView.Adapter<ConversationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.im_item_conversation,parent,false)
        return ConversationViewHolder(mainView,listener)
    }

    override fun getItemCount(): Int {
        return conversations.size
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        holder.load(conversations[position])
    }

}