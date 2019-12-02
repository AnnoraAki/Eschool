package com.erookies.school.data.model

import android.os.Parcelable
import com.erookies.lib_common.bean.User
import com.erookies.school.utils.IntParseToTag
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.lang.StringBuilder

@SuppressWarnings("ParcelCreator")
@Parcelize
class ItemData(@SerializedName("id") var id:Int = -1,
               @SerializedName("user") var user: User = User(),
               @SerializedName("info") var content:String = "",
               @SerializedName("tag") var tagNum: Int = 0,
               @SerializedName("creat_time") var createTime:String = "",
               @SerializedName("image_urls") val pictures:MutableList<String> = mutableListOf()) : Parcelable {
    val tag:Tag
        get() = IntParseToTag(tagNum)

    override fun toString(): String {
        return StringBuilder().apply {
            append("{")
            append("id: $id,\n")
            append("create_time: $createTime,\n")
            append("user: ${user.nickname},\n")
            append("info: $content,\n")
            append("tag: $tagNum,\n")
            append("pictures: $pictures\n")
            append("},\n")
        }.toString()
    }
}