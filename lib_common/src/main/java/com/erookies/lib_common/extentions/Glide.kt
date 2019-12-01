package com.erookies.lib_common.extentions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.erookies.lib_common.R
import com.erookies.lib_common.config.PIC_BASE_URL

/**
 * Create by Cchanges.
 * Time: 2019-10-08
 */
fun Context.loadPicture(rowUrl: String?, imageView: ImageView) {
    val url = when {
        rowUrl.isNullOrBlank() -> ""
        rowUrl.startsWith("http://") || rowUrl.startsWith("https://") -> rowUrl
        else -> ""
    }
    val options = RequestOptions.errorOf(R.drawable.common_default_avatar)
    Glide.with(this).load(url).into(imageView)
}

fun ImageView.setImageFromUrl(url: String?) {
    context.loadPicture(url, this)
}

fun ImageView.setAvatar(url:String?) {
    val real = "$PIC_BASE_URL$url"
    val options = RequestOptions.errorOf(R.drawable.common_default_avatar)
    Glide.with(this).setDefaultRequestOptions(options).load(real).into(this)
}