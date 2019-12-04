package com.erookies.school.ui.holder

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.school.R
import com.erookies.school.data.model.ItemData
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.activity.DetailActivity
import com.erookies.school.ui.adapter.CommonPicRVAdapter

class LostAndFoundViewHolder(val binding: SchoolItemLostFoundBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:ItemData?){
        val pictures = item?.pictures ?: mutableListOf()
        Glide.with(binding.root.context).load("http://118.24.129.217/api/download_face_api/${item?.user?.avatar}").placeholder(R.drawable.common_default_avatar).into(binding.schoolItemUserAvatar)
        if (item?.pictures.isNullOrEmpty()){
            binding.schoolItemPictures.visibility = View.GONE
        }else{
            binding.schoolItemPictures.visibility = View.VISIBLE
            Log.d("LostAndFoundRepository",item?.pictures?.size.toString())
            val layoutManager = GridLayoutManager(binding.root.context,3)
            val adapter = CommonPicRVAdapter(pictures,false)
            binding.schoolItemPictures.layoutManager = layoutManager
            binding.schoolItemPictures.adapter = adapter
        }
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context,DetailActivity::class.java)
            intent.putExtra("item_data",item)
            intent.putExtra("type",15)
            binding.root.context.startActivity(intent)
        }
    }
}