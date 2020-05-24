package com.erookies.school.ui.holder

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.school.R
import com.erookies.lib_common.IStartConversation
import com.erookies.school.data.model.ItemData
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.activity.DetailActivity
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import kotlinx.android.synthetic.main.school_item_lost_found.view.*

class LostAndFoundViewHolder(
    val binding: SchoolItemLostFoundBinding,
    private val listener: IStartConversation
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:ItemData){
        val pictures = item.pictures
        Glide.with(binding.root.context).load("http://118.24.129.217/api/download_face_api/${item.user.avatar}").placeholder(R.drawable.common_default_avatar).into(binding.schoolItemUserAvatar)
        if (item.pictures.isNullOrEmpty()){
            binding.schoolItemPictures.visibility = View.GONE
        }else{
            binding.schoolItemPictures.visibility = View.VISIBLE
            Log.d("LostAndFoundRepository",item.pictures.size.toString())
            val layoutManager = GridLayoutManager(binding.root.context,3)
            val adapter = CommonPicRVAdapter(pictures,false)
            binding.schoolItemPictures.layoutManager = layoutManager
            binding.schoolItemPictures.adapter = adapter
        }
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context,DetailActivity::class.java)
            intent.putExtra("item_data",item)
            intent.putExtra("type",15)
            val options = if (item.pictures.isNullOrEmpty()) ActivityOptionsCompat
                .makeSceneTransitionAnimation(binding.root.context as Activity,
                    Pair.create(binding.schoolItemUserName,"people_nickname"),
                    Pair.create(binding.schoolItemUserAvatar,"people_avatar"),
                    Pair.create(binding.schoolItemTagButton,"people_type"),
                    Pair.create(binding.schoolItemContent,"people_content"))
            else ActivityOptionsCompat.makeSceneTransitionAnimation(binding.root.context as Activity,
                Pair.create(binding.schoolItemUserName,"people_nickname"),
                Pair.create(binding.schoolItemUserAvatar,"people_avatar"),
                Pair.create(binding.schoolItemTagButton,"people_type"),
                Pair.create(binding.schoolItemContent,"people_content"),
                Pair.create(binding.schoolItemPictures,"people_rv"))
            binding.root.context.startActivity(intent,options.toBundle())
        }
        binding.root.school_item_user_avatar.setOnClickListener {
            val event = IMEvent(
                type = IMEventType.START_CONVERSATION,
                friend = item.user
            )
            Log.d("sendEvent_ls_vh","send finish : $event")
            listener.sendEvent(event)
        }
    }
}