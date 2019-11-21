package com.erookies.school.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.holder.LostAndFoundViewHolder

class LostAndFoundRVAdapter(model:LostAndFoundViewModel): RecyclerView.Adapter<LostAndFoundViewHolder>() {
    private val lostAndFoundItem = model.items.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostAndFoundViewHolder {
        val binding = SchoolItemLostFoundBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LostAndFoundViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("LostAndFoundFragment","lost and found item size:${lostAndFoundItem?.size}")
        return lostAndFoundItem?.size ?: 0
    }

    override fun onBindViewHolder(holder: LostAndFoundViewHolder, position: Int) {
        holder.binding.item = lostAndFoundItem?.get(position) ?: ItemData()
        holder.bind(lostAndFoundItem?.get(position))
        holder.binding.executePendingBindings()
    }

    private fun updateItem(list: MutableList<ItemData>) {
        lostAndFoundItem?.clear()
        lostAndFoundItem?.addAll(list)
    }

    fun dataChanged(list: MutableList<ItemData>?){
        if (list != null) {
            updateItem(list)
            notifyDataSetChanged()
        }
    }
}