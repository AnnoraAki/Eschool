package com.erookies.school.data.model

import com.google.gson.annotations.SerializedName

open class Wrapper {
    @SerializedName("code")
    var code:Int = 0

    @SerializedName("msg")
    var msg:String = ""
}