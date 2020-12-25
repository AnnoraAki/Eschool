package com.erookies.module_im.ui.holder

import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cn.jpush.im.android.api.content.TextContent
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.enums.ConversationType
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.GroupInfo
import cn.jpush.im.android.api.model.UserInfo
import com.bumptech.glide.Glide
import com.erookies.lib_common.IStartConversation
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.lib_common.extentions.toast
import com.erookies.module_im.R
import com.erookies.module_im.model.MessageWrapper
import kotlinx.android.synthetic.main.im_item_conversation.view.*
import kotlinx.android.synthetic.main.im_item_left_msg.view.*
import kotlinx.android.synthetic.main.im_item_right_msg.view.*

open class BaseMessageViewHolder(view: View) : RecyclerView.ViewHolder(view){
    companion object{
        const val TAG = "BaseMessageViewHolder"
    }

    open fun load(msg:MessageWrapper){

    }
}

class LeftViewHolder(view: View) : BaseMessageViewHolder(view){
    override fun load(msg: MessageWrapper) {
        super.load(msg)
        Glide.with(itemView)
            .asBitmap()
            .load(msg.avatarUrl)
            .placeholder(R.drawable.common_default_avatar)
            .into(itemView.im_left_msg_avatar)

        itemView.im_left_msg_content.text = msg.msg
    }
}

class RightViewHolder(view: View) : BaseMessageViewHolder(view){
    override fun load(msg: MessageWrapper) {
        super.load(msg)
        Glide.with(itemView)
            .asBitmap()
            .load(msg.avatarUrl)
            .placeholder(R.drawable.common_default_avatar)
            .into(itemView.im_right_msg_avatar)

        itemView.im_right_msg_content.text = msg.msg
    }
}

class ConversationViewHolder(view: View, private val listener:IStartConversation) : RecyclerView.ViewHolder(view){
    fun load(conversation: Conversation) {
        var info: UserInfo? = null
        var type = ConversationType.single

        if (conversation.type == ConversationType.single) {
            info = conversation.targetInfo as UserInfo
            type = ConversationType.single
        }

        if (conversation.type == ConversationType.group) {
            val groupInfo = conversation.targetInfo as GroupInfo
            info = groupInfo.ownerMemberInfo.userInfo
            type = ConversationType.group
        }

        info ?: return
        loadTagContent(info, type)
        loadBaseContent(conversation)
    }

    private fun loadBaseContent(conversation: Conversation) {
        if (conversation.latestMessage != null) {
            itemView.im_conversation_newest_msg.text = when(conversation.latestMessage.contentType){
                ContentType.text -> (conversation.latestMessage.content as TextContent).text
                else -> "[不支持的消息类型]"
            }
        }

        if (conversation.unReadMsgCnt > 0){
            itemView.im_conversation_unread_msg_bg.visibility = View.VISIBLE
            itemView.im_conversation_unread_msg_count.visibility = View.VISIBLE
            itemView.im_conversation_unread_msg_count.text = conversation.unReadMsgCnt.toString()
        } else {
            itemView.im_conversation_unread_msg_bg.visibility = View.GONE
            itemView.im_conversation_unread_msg_count.visibility = View.GONE
        }
    }

    private fun loadTagContent(info: UserInfo, type: ConversationType) {
        Glide.with(itemView)
            .asBitmap()
            .placeholder(R.drawable.common_default_avatar)
            .load(info.extras["avatar"])
            .into(itemView.im_user_avatar)

        itemView.im_user_nickname.text = if (!TextUtils.isEmpty(info.nickname)) info.nickname else info.userName

        var event: IMEvent? = null
        if (type == ConversationType.single) {
            event = IMEvent(
                type = IMEventType.START_SINGLE_CONVERSATION,
                friend = User(stuNum = info.userName)
            )
        }

        itemView.setOnClickListener {
            if (event == null) {
                toast("不支持该种聊天类型~")
            } else {
                listener.sendEvent(event)
            }
        }
    }
}