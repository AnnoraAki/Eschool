package com.erookies.school.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.Tag
import com.erookies.school.data.viewModel.SPViewModel
import com.erookies.school.databinding.SchoolItemSearchPeopleBinding
import com.erookies.school.ui.holder.SearchPeopleViewHolder
import com.erookies.school.utils.TagParseToInt

class SearchPeopleRVAdapter(viewModel:SPViewModel) :
    RecyclerView.Adapter<SearchPeopleViewHolder>() {
    private val list = viewModel.items.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPeopleViewHolder {
        val binding = SchoolItemSearchPeopleBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return SearchPeopleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: SearchPeopleViewHolder, position: Int) {
        holder.binding.item = list?.get(position) ?: ItemData(tagNum = TagParseToInt(Tag.SP))
        holder.bind(list?.get(position))
        holder.binding.executePendingBindings()
    }

    private fun updateItem(list: MutableList<ItemData>) {
        list.clear()
        list.addAll(list)
    }

    fun dataChanged(list: MutableList<ItemData>?){
        if (list != null) {
            updateItem(list)
            notifyDataSetChanged()
            Log.d("SPViewModel","适配器数据更新成功")
        }
    }
}