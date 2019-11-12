package com.erookies.main.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Create by Cchanges.
 * Time: 2019-11-12
 */
data class RegisterBean(
    val institute: String,
    val name: String,
    val nickname: String,
    val password: String,
    val sno: String
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
        writeString(institute)
        writeString(name)
        writeString(nickname)
        writeString(password)
        writeString(sno)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RegisterBean> = object : Parcelable.Creator<RegisterBean> {
            override fun createFromParcel(source: Parcel): RegisterBean = RegisterBean(source)
            override fun newArray(size: Int): Array<RegisterBean?> = arrayOfNulls(size)
        }
    }
}