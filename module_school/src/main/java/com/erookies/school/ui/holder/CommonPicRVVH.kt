package com.erookies.school.ui.holder

import android.net.Uri
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.school.utils.Constants
import kotlinx.android.synthetic.main.school_common_image.view.*
import java.io.File

class CommonPicRVVH(view:View) : RecyclerView.ViewHolder(view) {
    fun load(url:String,fromLocal:Boolean){
        itemView.school_item_common_image.tag = null
        val height = Constants.height / 3.4
        if (fromLocal){
            Glide.with(itemView).load(Uri.fromFile(File(url))).override((height*1.05).toInt(),height.toInt()).into(itemView.school_item_common_image)
        }else{
            Glide.with(itemView).load(url).override((height*1.25).toInt(),height.toInt()).into(itemView.school_item_common_image)
        }
        Log.d("loadPic","picture's loading is finish")
    }
}