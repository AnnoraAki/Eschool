package com.erookies.mine.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Create by Cchanges.
 * Time: 2019-11-13
 */
data class ChangeBody(val sno: String = "",
                      @SerializedName("newpwd")
                      val newPwd: String = "") : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(sno)
        writeString(newPwd)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChangeBody> = object : Parcelable.Creator<ChangeBody> {
            override fun createFromParcel(source: Parcel): ChangeBody =
                ChangeBody(source)
            override fun newArray(size: Int): Array<ChangeBody?> = arrayOfNulls(size)
        }
    }
}