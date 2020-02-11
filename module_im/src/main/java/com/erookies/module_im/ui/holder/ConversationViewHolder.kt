package com.erookies.module_im.ui.holder

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import cn.jpush.im.android.api.callback.GetUserInfoCallback
import cn.jpush.im.android.api.content.TextContent
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.UserInfo
import com.bumptech.glide.Glide
import com.erookies.module_im.R
import com.erookies.module_im.helper.JIMHelper
import kotlinx.android.synthetic.main.im_item_conversation.view.*

class ConversationViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val TAG = "ConversationViewHolder"


    fun load(conversation: Conversation){

        val newestMsg = when(conversation.latestMessage.contentType){
            ContentType.text -> {
                (conversation.latestMessage.content as TextContent).text
            }
            else -> {
                ""
            }
        }

        var user:UserInfo? = null

        val handler =object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                when(msg?.data?.getInt("result",0)){
                    1 -> {
                        val avatar = user?.getExtra("avatar_url")
                        if (TextUtils.isEmpty(avatar)){
                            Glide.with(itemView).load(R.drawable.common_default_avatar).into(itemView.im_user_avatar)
                        }else{
                            Glide.with(itemView).load(avatar).into(itemView.im_user_avatar)
                        }

                        itemView.im_user_nickname.text = user?.nickname
                        itemView.im_conversation_newest_msg.text = newestMsg
                        itemView.im_conversation_unread_msg_count.text = conversation.unReadMsgCnt.toString()
                    }
                }
            }
        }

        JIMHelper.getUserInfo((conversation.targetInfo as UserInfo).userName,object : GetUserInfoCallback(){
            override fun gotResult(responseCode: Int, responseMessage: String?, userInfo: UserInfo?) {
                val msg = Message.obtain()
                if (responseCode == 0){
                    user = userInfo
                    msg.data = bundleOf(
                        "result" to 1
                    )
                }else{
                    msg.data = bundleOf(
                        "result" to 0
                    )
                    Log.d(TAG,responseMessage)
                }
                handler.sendMessage(msg)
            }
        })
    }
}