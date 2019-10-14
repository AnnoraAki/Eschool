package com.erookies.lib_common

import android.os.Parcel
import android.os.Parcelable

/**
 * Create by Cchanges.
 * Time: 2019-10-14
 */
data class User(
    val id: String = "",
    val username: String = "",
    val pwd: String = "",
    val nickname: String = "",
    val email: String = "",
    val phone: String = "",
    // 学院
    val college: String = "",
    // 学号
    val stuNum: String = "",
    // 描述
    val info: String = "",
    val avatar: String = ""
    // val addTime :
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(username)
        parcel.writeString(pwd)
        parcel.writeString(nickname)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(college)
        parcel.writeString(stuNum)
        parcel.writeString(info)
        parcel.writeString(avatar)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}