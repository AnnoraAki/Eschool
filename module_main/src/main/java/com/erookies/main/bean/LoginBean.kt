package com.erookies.main.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Create by Cchanges.
 * Time: 2019-11-12
 */
data class LoginBean(val sno: String, val password: String) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(sno)
        writeString(password)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LoginBean> = object : Parcelable.Creator<LoginBean> {
            override fun createFromParcel(source: Parcel): LoginBean =
                LoginBean(source)
            override fun newArray(size: Int): Array<LoginBean?> = arrayOfNulls(size)
        }
    }
}