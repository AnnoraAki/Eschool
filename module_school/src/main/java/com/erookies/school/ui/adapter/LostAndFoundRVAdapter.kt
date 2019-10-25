package com.erookies.school.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.holder.LostAndFoundViewHolder

class LostAndFoundRVAdapter(model:LostAndFoundViewModel): RecyclerView.Adapter<LostAndFoundViewHolder>() {
    private val list = model.items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostAndFoundViewHolder {
        val binding = SchoolItemLostFoundBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LostAndFoundViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LostAndFoundViewHolder, position: Int) {
        holder.binding.item = list[position].value
        holder.binding.executePendingBindings()
    }
}