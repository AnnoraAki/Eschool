package com.erookies.school.ui.holder

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.lib_common.extentions.setImageFromUrl
import com.erookies.school.databinding.SchoolCommonImageBinding
import kotlinx.android.synthetic.main.school_common_image.view.*
import java.io.File
import java.io.FileInputStream

class CommonPicRVVH(view:View) : RecyclerView.ViewHolder(view) {
    fun load(url:String){
        itemView.school_item_common_image.tag = null
        Glide.with(itemView).load(Uri.fromFile(File(url))).into(itemView.school_item_common_image)
        Log.d("loadPic","picture's loading is finish")
    }
}