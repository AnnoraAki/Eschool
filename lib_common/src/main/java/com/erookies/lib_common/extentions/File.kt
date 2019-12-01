package com.erookies.lib_common.extentions

import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.erookies.lib_common.BaseApp
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

/**
 * Create by Cchanges.
 * Time: 2019-12-01
 */
val File.uri: Uri
    get() = if (Build.VERSION.SDK_INT >= 24) {
        FileProvider.getUriForFile(BaseApp.context, "com.mredrock.cyxbs.fileProvider", this)
    } else {
        Uri.fromFile(this)
    }

fun File.getRequestBody(): RequestBody {
    return this.asRequestBody("multipart/form-data".toMediaTypeOrNull())
}