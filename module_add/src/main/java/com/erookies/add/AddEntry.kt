package com.erookies.add

import android.os.Parcel
import android.os.Parcelable

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
data class AddEntry(
    val tag: String = "",
    val time: String = "",
    val address: String = "",
    val nickname: String = "",
    val avatar: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(tag)
        writeString(time)
        writeString(address)
        writeString(nickname)
        writeString(avatar)
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