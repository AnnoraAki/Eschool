package com.erookies.school.data.model

import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

class ItemDataWrapper {

    @SerializedName("code")
    var code:Int = 0

    @SerializedName("msg")
    var msg:String = ""

    @SerializedName("data")
    var data:List<ItemData> = mutableListOf()

    override fun toString(): String {
        return StringBuilder().apply {
            append("code: $code,\n")
            append("msg: $msg,\n")
            append("data: $data")
        }.toString()
    }
}