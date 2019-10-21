package com.erookies.school.data.model

import com.erookies.lib_common.User

/**
 * Create by Koalak.
 * Time: 2019-10-21
 */
class SearchPeopleItemData : BaseItemData() {
    var use = User()
    var content:String = ""
    val tag = "寻人"

    var picUrls:MutableList<String> = mutableListOf()

    override fun handle() {

    }
}