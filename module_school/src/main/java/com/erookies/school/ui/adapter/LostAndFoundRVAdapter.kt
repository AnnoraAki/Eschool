package com.erookies.school.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.holder.LostAndFoundViewHolder

class LostAndFoundRVAdapter(private val list: MutableList<ItemData>? = mutableListOf())
    : RecyclerView.Adapter<LostAndFoundViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostAndFoundViewHolder {
        val binding = SchoolItemLostFoundBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LostAndFoundViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("LostAndFoundFragment","lost and found item size:${list?.size}")
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: LostAndFoundViewHolder, position: Int) {
        holder.binding.item = list?.get(position) ?: ItemData()
        holder.bind(list?.get(position))
        holder.binding.executePendingBindings()
    }
}