package com.erookies.school.data.model

import com.erookies.lib_common.User
/**
 * Create by Koalak.
 * Time: 2019-10-21
 */
class LostAndFoundItemData : BaseItemData() {

    var user = User()

    var content = ""

    var tag:Tag = Tag.OTHER

    var tagIndex = -1

    var picUrls:MutableList<String> = mutableListOf()

    override fun handle() {
        tag = when(tagIndex){
            0 -> Tag.CARD
            1 -> Tag.DIGITAL
            2 -> Tag.DIGITAL
            3 -> Tag.COMMODITY
            else -> Tag.OTHER
        }
    }
}

enum class Tag {
    CARD,
    DIGITAL,
    COMMODITY,
    OTHER
}