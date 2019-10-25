package com.erookies.school.data.model

import com.erookies.lib_common.User
/**
 * Create by Koalak.
 * Time: 2019-10-21
 */
class LostAndFoundItemData(var user:User = User(),
                           var content:String = "",
                           var tag:Tag = Tag.OTHER,
                           var picUrls:MutableList<String> = mutableListOf()) : BaseItemData() {

    override fun handle() {

    }
}