package com.erookies.school.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.viewModel.SPViewModel
import com.erookies.school.databinding.SchoolItemSearchPeopleBinding
import com.erookies.school.ui.holder.SearchPeopleViewHolder

class SearchPeopleRVAdapter(viewModel:SPViewModel) :
    RecyclerView.Adapter<SearchPeopleViewHolder>() {
    private val list = viewModel.items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPeopleViewHolder {
        val binding = SchoolItemSearchPeopleBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return SearchPeopleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchPeopleViewHolder, position: Int) {
        holder.binding.item = list[position].value
        holder.binding.executePendingBindings()
    }
}