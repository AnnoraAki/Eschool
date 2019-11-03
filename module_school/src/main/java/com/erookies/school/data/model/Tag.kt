package com.erookies.school.data.model

import android.os.Parcel
import android.os.Parcelable

enum class Tag(val tag:String) : Parcelable {
    CARD("校卡/身份证"),
    DIGITAL("数码"),
    COMMODITY("生活用品"),
    OTHER("其他");

    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tag)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tag> {
        override fun createFromParcel(parcel: Parcel): Tag {
            return values()[parcel.readInt()]
        }

        override fun newArray(size: Int): Array<Tag?> {
            return arrayOfNulls(size)
        }
    }
}