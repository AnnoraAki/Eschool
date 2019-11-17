package com.erookies.school.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
enum class Tag(val tag:String) : Parcelable {

    CARD("校卡/身份证"),
    DIGITAL("数码"),
    COMMODITY("生活用品"),
    OTHER("其他")
}