package com.erookies.school.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.R
import com.erookies.school.ui.holder.CommonPicRVVH

class CommonPicRVAdapter(private val list:MutableList<String> = mutableListOf()) : RecyclerView.Adapter<CommonPicRVVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonPicRVVH {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.school_common_image,parent,false)
        return CommonPicRVVH(mainView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CommonPicRVVH, position: Int) {
        holder.load(list[position])
    }

    private fun addNewData(pictureUri: MutableList<String>){
        list.clear()
        list.addAll(pictureUri)
    }

    fun updateAdapter(pictureUri: MutableList<String>){
        addNewData(pictureUri)
        notifyDataSetChanged()
    }
}