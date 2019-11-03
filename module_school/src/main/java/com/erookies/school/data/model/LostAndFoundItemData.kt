package com.erookies.school.data.model

import android.os.Parcel
import android.os.Parcelable
import com.erookies.lib_common.User
/**
 * Create by Koalak.
 * Time: 2019-10-21
 */
class LostAndFoundItemData(var user:User = User(),
                           var content:String = "",
                           var tag:Tag = Tag.OTHER,
                           var picUrls:List<Picture> = arrayListOf()
) : BaseItemData(),Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(User::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Tag::class.java.classLoader),
        parcel.createTypedArrayList(Picture)
    ) {
    }

    override fun handle() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(user, flags)
        parcel.writeString(content)
        parcel.writeParcelable(tag, flags)
        parcel.writeTypedList(picUrls)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LostAndFoundItemData> {
        override fun createFromParcel(parcel: Parcel): LostAndFoundItemData {
            return LostAndFoundItemData(parcel)
        }

        override fun newArray(size: Int): Array<LostAndFoundItemData?> {
            return arrayOfNulls(size)
        }
    }
}

class Picture(var url:String) : Parcelable{
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Picture> {
        override fun createFromParcel(parcel: Parcel): Picture {
            return Picture(parcel)
        }

        override fun newArray(size: Int): Array<Picture?> {
            return arrayOfNulls(size)
        }
    }
}