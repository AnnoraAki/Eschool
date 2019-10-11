package com.erookies.lib_common.extentions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Create by Cchanges.
 * Time: 2019-10-08
 */
fun Context.loadPicture(rowUrl:String?, imageView: ImageView) {
    val url = when {
        rowUrl.isNullOrBlank() -> return
        rowUrl.startsWith("http://") || rowUrl.startsWith("https://") -> rowUrl
        else -> ""
    }
    Glide.with(this).load(url).into(imageView)
}

fun ImageView.setImageFromUrl(url: String?) {
    context.loadPicture(url,this)
}