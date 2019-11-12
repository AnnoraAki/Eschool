package com.erookies.main.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Create by Cchanges.
 * Time: 2019-11-11
 */
data class SnoBean(val sno: String) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(sno)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SnoBean> = object : Parcelable.Creator<SnoBean> {
            override fun createFromParcel(source: Parcel): SnoBean = SnoBean(source)
            override fun newArray(size: Int): Array<SnoBean?> = arrayOfNulls(size)
        }
    }
}