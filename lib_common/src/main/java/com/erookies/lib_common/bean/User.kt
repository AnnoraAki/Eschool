package com.erookies.lib_common.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson

/**
 * Create by Cchanges.
 * Time: 2019-10-14
 */
data class User(
    val id: String = "",
    val name: String = "",
    var pwd: String = "",
    var nickname: String = "",
    var email: String = "",
    var phone: String = "",
    // 学院
    val institute: String = "",
    // 学号
    val sno: String = "",
    // 描述
    var info: String = "",
    var avatar: String = ""
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
        parcel.writeString(name)
        parcel.writeString(pwd)
        parcel.writeString(nickname)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(institute)
        parcel.writeString(sno)
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

    fun toJSON(): String = Gson().toJson(this)
}