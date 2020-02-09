package com.erookies.module_im.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.jpush.im.android.api.model.Conversation
import com.erookies.module_im.R
import com.erookies.module_im.ui.holder.ConversationViewHolder

class ConversationRVAdapter(
    val conversations:MutableList<Conversation> = mutableListOf()
) : RecyclerView.Adapter<ConversationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.im_item_conversation,parent,false)
        return ConversationViewHolder(mainView)
    }

    override fun getItemCount(): Int {
        return conversations.size
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        holder.load(conversations[position])
    }
}