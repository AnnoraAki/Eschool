package com.erookies.school.ui.holder

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.lib_common.extentions.setImageFromUrl
import kotlinx.android.synthetic.main.school_common_image.view.*

class CommonPicRVVH(itemView:View) : RecyclerView.ViewHolder(itemView) {
    fun load(url:String){
        itemView.school_item_common_image.setImageFromUrl(url)
    }
}