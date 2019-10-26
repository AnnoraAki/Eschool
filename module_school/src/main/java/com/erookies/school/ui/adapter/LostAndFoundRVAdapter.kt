package com.erookies.school.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.holder.LostAndFoundViewHolder

//TODO 修复数据未传入adapter的bug
class LostAndFoundRVAdapter(model:LostAndFoundViewModel): RecyclerView.Adapter<LostAndFoundViewHolder>() {
    private val lostAndFoundItem = model.items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostAndFoundViewHolder {
        val binding = SchoolItemLostFoundBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LostAndFoundViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("LostAndFoundFragment","lost and found item size:${lostAndFoundItem?.size}")
        return lostAndFoundItem.size
    }

    override fun onBindViewHolder(holder: LostAndFoundViewHolder, position: Int) {
        holder.binding.item = lostAndFoundItem[position].value
        holder.binding.executePendingBindings()
    }
}