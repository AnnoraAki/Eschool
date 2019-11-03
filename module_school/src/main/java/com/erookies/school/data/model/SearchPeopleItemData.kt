package com.erookies.school.data.model

import android.os.Parcel
import android.os.Parcelable
import com.erookies.lib_common.User

/**
 * Create by Koalak.
 * Time: 2019-10-21
 */
class SearchPeopleItemData(var user: User = User(),
                           var content:String = "",
                           var tag:String = "寻人",
                           var picUrls:List<Picture> = arrayListOf()
) : BaseItemData(),Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(User::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Picture)
    ) {
    }

    override fun handle() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(user, flags)
        parcel.writeString(content)
        parcel.writeString(tag)
        parcel.writeTypedList(picUrls)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchPeopleItemData> {
        override fun createFromParcel(parcel: Parcel): SearchPeopleItemData {
            return SearchPeopleItemData(parcel)
        }

        override fun newArray(size: Int): Array<SearchPeopleItemData?> {
            return arrayOfNulls(size)
        }
    }
}