package com.erookies.school.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.lib_common.IStartConversation
import com.erookies.school.data.model.ItemData
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.holder.LostAndFoundViewHolder

class LostAndFoundRVAdapter(
    val list: MutableList<ItemData> = mutableListOf(),
    val listener: IStartConversation
) : RecyclerView.Adapter<LostAndFoundViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostAndFoundViewHolder {
        val binding = SchoolItemLostFoundBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LostAndFoundViewHolder(binding,listener)
    }

    override fun getItemCount(): Int {
        Log.d("LostAndFoundFragment","lost and found item size:${list.size}")
        return list.size
    }

    override fun onBindViewHolder(holder: LostAndFoundViewHolder, position: Int) {
        holder.binding.item = list[position]
        holder.bind(list[position])
        holder.binding.executePendingBindings()
    }
}