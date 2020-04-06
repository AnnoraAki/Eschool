package com.erookies.school.ui.holder

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.school.R
import com.erookies.lib_common.IStartConversation
import com.erookies.school.data.model.ItemData
import com.erookies.school.databinding.SchoolItemSearchPeopleBinding
import com.erookies.school.ui.activity.DetailActivity
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import kotlinx.android.synthetic.main.school_item_search_people.view.*

class SearchPeopleViewHolder(
    val binding: SchoolItemSearchPeopleBinding,
    private val listener: IStartConversation
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ItemData){
        val pictures = item.pictures
        Glide.with(binding.root.context).load("http://118.24.129.217/api/download_face_api/${item.user.avatar}").placeholder(R.drawable.common_default_avatar).into(binding.schoolSpItemUserAvatar)
        if (item.pictures.isNullOrEmpty()){
            binding.schoolSpItemPictures.visibility = View.GONE
        }else{
            binding.schoolSpItemPictures.visibility = View.VISIBLE
            val layoutManager = GridLayoutManager(binding.root.context,3)
            val adapter = CommonPicRVAdapter(pictures,false)
            binding.schoolSpItemPictures.layoutManager = layoutManager
            binding.schoolSpItemPictures.adapter = adapter
        }
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, DetailActivity::class.java)
            intent.putExtra("item_data",item)
            intent.putExtra("type",16)
            binding.root.context.startActivity(intent)
        }

        binding.root.school_sp_item_user_avatar.setOnClickListener {
            val event = IMEvent(
                type = IMEventType.START_CONVERSATION,
                friend = item.user
            )
            Log.d("sendEvent_sp_vh","send finish : $event")
            listener.sendEvent(event)
        }
    }
}