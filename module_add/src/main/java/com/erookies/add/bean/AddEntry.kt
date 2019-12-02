package com.erookies.add.bean

import android.os.Parcel
import android.os.Parcelable
import com.erookies.lib_common.bean.User
import com.google.gson.annotations.SerializedName

/**
 * Create by Cchanges.
 * Time: 2019-12-01
 */
data class AddEntry(
    @SerializedName("Existing_number")
    var addNum: Int = 0,
    @SerializedName("creat_time")
    val createTime: String = "",
    val id: Int = 0,
    var info: String = "",
    var number: Int = 0,
    var others: List<String> = arrayListOf(),
    var tag: Int = 0,
    var time: String = "",
    val user: User? = null,
    @SerializedName("where")
    val content: String = ""
) : Parcelable {
    constructor(source:Parcel) : this(
    source.readInt(),
    source.readString(),
    source.readInt(),
    source.readString(),
    source.readInt(),
    source.createStringArrayList(),
    source.readInt(),
    source.readString(),
    source.readParcelable<User>(User::class.java.classLoader),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(addNum)
        writeString(createTime)
        writeInt(id)
        writeString(info)
        writeInt(number)
        writeStringList(others)
        writeInt(tag)
        writeString(time)
        writeParcelable(user, 0)
        writeString(content)
    }

    companion object {

        const val CAR = "拼车"

        const val MOVIE = "电影"

        const val EAT = "约饭"

        const val GAME = "桌游"

        const val SING = "唱歌"

        const val OTHER = "其他"

        @JvmField
        val CREATOR: Parcelable.Creator<AddEntry> = object : Parcelable.Creator<AddEntry> {
            override fun createFromParcel(source: Parcel): AddEntry = AddEntry(source)
            override fun newArray(size: Int): Array<AddEntry?> = arrayOfNulls(size)
        }
    }
}